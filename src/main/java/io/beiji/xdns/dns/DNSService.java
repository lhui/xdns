package io.beiji.xdns.dns;

import com.google.gson.Gson;
import eu.roboflax.cloudflare.CloudflareAccess;
import eu.roboflax.cloudflare.CloudflareRequest;
import eu.roboflax.cloudflare.CloudflareResponse;
import eu.roboflax.cloudflare.constants.Category;
import eu.roboflax.cloudflare.objects.dns.DNSRecord;
import io.beiji.xdns.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DNSService {
    @Value("${cloudflare.zone-id}")
    public String zoneId;
    @Value("${cloudflare.x-auth-key}")
    public String CF_API_TOKEN;
    private Gson gson = new Gson();
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public DNSResponse listExistDomainRecord() {
        CloudflareAccess cfAccess = new CloudflareAccess(CF_API_TOKEN);
        var redisKeyListExistDomain = "listExistDomain";
        if (redisUtil.hasKey(redisKeyListExistDomain)) {
            log.info("redisUtil set");
            List<DNSModel> dnsRecords = (List<DNSModel>) (Object) redisUtil.lGet(redisKeyListExistDomain, 0, -1);
            log.info("get the DNSRecord List from redis = {}", dnsRecords);
            return new DNSResponse(dnsRecords);
        }
        log.info(zoneId);
        CloudflareResponse<List<DNSRecord>> response =
                new CloudflareRequest(Category.LIST_DNS_RECORDS, cfAccess)
                        .identifiers(zoneId)
                        .asObjectList(DNSRecord.class);
        log.info("response = {}", gson.toJson(response));

        List<DNSRecord> dnsRecords = response.getObject();
        log.info(gson.toJson(dnsRecords));
        log.info("get the DNSRecord from cloudflare api = {}", dnsRecords);

        List<DNSModel> dnsModelList = dnsRecords.stream()
                .map(dnsRecord -> new DNSModel(dnsRecord.getName(), dnsRecord.getType(), dnsRecord.getContent()))
                .collect(Collectors.toList());
        DNSResponse dnsResponse = new DNSResponse(dnsModelList);
        redisUtil.lSet(redisKeyListExistDomain, dnsModelList);
        return new DNSResponse(dnsModelList);
    }

    public List<DNSRecord> addNewDomainRecord(DNSRecord dnsRecord) {
        var cfAccess = new CloudflareAccess(CF_API_TOKEN);

        CloudflareResponse<List<DNSRecord>> dnsRecordList =
                new CloudflareRequest(Category.LIST_DNS_RECORDS, cfAccess)
                        .identifiers(zoneId)
                        .queryString("name", dnsRecord.getName())
                        .asObjectList(DNSRecord.class);
        log.info("if the old exist: {}", dnsRecordList.getObject().size());

        if (!dnsRecordList.getObject().isEmpty()) {
            return new ArrayList<>();
        }
        log.info("create new dnsRecord: {} ", dnsRecord);
        CloudflareResponse<DNSRecord> response = new CloudflareRequest(Category.CREATE_DNS_RECORD, cfAccess)
                .identifiers(zoneId)
                .body(gson.toJson(dnsRecord))
                .asObject(DNSRecord.class);
        log.info("add new dnsRecord info is {}", gson.toJson(response));
        listExistDomainRecord();// refresh the redis to get all the domain records.
        var dnsRecords = response.getObject();
        return new ArrayList<>(Collections.singletonList(dnsRecords));

    }
}
