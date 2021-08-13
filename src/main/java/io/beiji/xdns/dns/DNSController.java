package io.beiji.xdns.dns;

import eu.roboflax.cloudflare.CloudflareResponse;
import eu.roboflax.cloudflare.objects.dns.DNSRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dns")
public class DNSController {

    @Autowired
    private DNSService dnsService;

    @GetMapping("/records")
    public CloudflareResponse<List<DNSRecord>> listExistDomainRecord() {
        return dnsService.listExistDomainRecord();
    }

}
