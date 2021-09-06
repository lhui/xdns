package io.beiji.xdns.dns;

import eu.roboflax.cloudflare.objects.dns.DNSRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "DNS接口")
@RestController
@RequestMapping("/dns")
public class DNSController {

    private final DNSService dnsService;

    public DNSController(DNSService dnsService) {
        this.dnsService = dnsService;
    }

    @ApiOperation(value = "dns列表")
    @GetMapping("/records")
    public List<DNSRecord> listExistDomainRecord() {
        return dnsService.listExistDomainRecord();
    }

    @ApiOperation(value = "增加新的dns记录")
    @PostMapping("/records")
    public List<DNSRecord> addNewDomainRecord(@RequestBody DNSRecord dnsRecord) {
        return dnsService.addNewDomainRecord(dnsRecord);
    }
}
