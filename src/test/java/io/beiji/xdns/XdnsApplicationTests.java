package io.beiji.xdns;

import io.beiji.xdns.dns.DNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XdnsApplicationTests {
    @Autowired
    public DNSService dnsService;

//    @Test
//    void GetDNSRecordList() {
//        List<DNSRecord> response = dnsService.listExistDomainRecord();
//
//    }


}
