package io.beiji.xdns.dns;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DNSService {
    @Value("${cloudflare.x-auth-key}")
    public String XAuthKey;
    @Value("${cloudflare.zone-id}")
    public String ZondId;
    private Gson gson = new Gson();

    //    public String DNSRecords;
//    public String name;
//    public String Content;
//    public int page;
//    public int per_page;
//    public String order;
//    public String direction;
//    public String match;
    public String ListExistDomainRecord() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://api.cloudflare.com/client/v4/zones/" + ZondId + "/dns_records")
                .header("Authorization", XAuthKey)
                .header("Content-Type", "application/json")
                .asString();
        log.info("response = {}", gson.toJson(response));
        return "OK";
    }

}
