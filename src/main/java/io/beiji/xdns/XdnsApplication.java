package io.beiji.xdns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class XdnsApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdnsApplication.class, args);
    }

}
