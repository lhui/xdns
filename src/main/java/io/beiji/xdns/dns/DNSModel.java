package io.beiji.xdns.dns;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DNSModel {
    private String dns_name;
    private String dns_type;
    private String dns_content;

    public DNSModel(String dns_name, String dns_type, String dns_content) {
        this.dns_name = dns_name;
        this.dns_type = dns_type;
        this.dns_content = dns_content;

    }
}
