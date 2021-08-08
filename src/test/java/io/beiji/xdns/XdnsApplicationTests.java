package io.beiji.xdns;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.beiji.xdns.dns.DNSService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XdnsApplicationTests {
	@Autowired
	public DNSService dnsService;

	@Test
	void GetDNSRecordList() throws UnirestException {
		String response = dnsService.ListExistDomainRecord();
	}


}
