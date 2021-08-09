package io.beiji.xdns.dns;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/dns")
public class DNSController {
    final DNSService dnsService;

    public DNSController(DNSService dnsService) {
        this.dnsService = dnsService;
    }


    @GetMapping("/listRecords")
    public String listExistDomainRecord() throws UnirestException {
        return dnsService.ListExistDomainRecord();
    }

}
