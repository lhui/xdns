package io.beiji.xdns.dns;

import com.google.gson.Gson;
import eu.roboflax.cloudflare.CloudflareAccess;
import eu.roboflax.cloudflare.CloudflareRequest;
import eu.roboflax.cloudflare.CloudflareResponse;
import eu.roboflax.cloudflare.constants.Category;
import eu.roboflax.cloudflare.objects.dns.DNSRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DNSService {
    @Value("${cloudflare.zone-id}")
    public String ZoneId;
    @Value("${cloudflare.x-auth-key}")
    public String CF_API_TOKEN;
    private Gson gson = new Gson();

    public CloudflareResponse<List<DNSRecord>> ListExistDomainRecord() {
        log.info(ZoneId);
        CloudflareAccess cfAccess = new CloudflareAccess(CF_API_TOKEN);
        CloudflareResponse<List<DNSRecord>> response =
                new CloudflareRequest(Category.LIST_DNS_RECORDS, cfAccess)
                        .identifiers(ZoneId)
                        .asObjectList(DNSRecord.class);
        log.info("response = {}", gson.toJson(response));
        return response;
    }

}
