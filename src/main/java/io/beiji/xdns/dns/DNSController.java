package io.beiji.xdns.dns;

import eu.roboflax.cloudflare.CloudflareResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/dns")
public class DNSController {

    @Autowired
    private DNSService dnsService;

    @GetMapping("/listRecords")
    public CloudflareResponse listExistDomainRecord() {
        return dnsService.ListExistDomainRecord();
    }

}
