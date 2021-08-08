package io.beiji.xdns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class XdnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdnsApplication.class, args);
	}

}
