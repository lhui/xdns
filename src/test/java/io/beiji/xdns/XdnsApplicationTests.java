package io.beiji.xdns;

import com.mashape.unirest.http.exceptions.UnirestException;
import eu.roboflax.cloudflare.CloudflareResponse;
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
	void GetDNSRecordList() throws UnirestException {
		CloudflareResponse<List<DNSRecord>> response = dnsService.ListExistDomainRecord();
	}


}
