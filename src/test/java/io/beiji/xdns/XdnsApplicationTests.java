package io.beiji.xdns;

import eu.roboflax.cloudflare.objects.dns.DNSRecord;
import io.beiji.xdns.dns.DNSService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class XdnsApplicationTests {
    @Autowired
    public DNSService dnsService;

    @Test
    void GetDNSRecordList() {
        List<DNSRecord> response = dnsService.listExistDomainRecord();
    }


}
