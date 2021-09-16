package io.beiji.xdns.dns;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class DNSModel implements Serializable {
    private String dns_name;
    private String dns_type;
    private String dns_content;

    public DNSModel(String dns_name, String dns_type, String dns_content) {
        this.dns_name = dns_name;
        this.dns_type = dns_type;
        this.dns_content = dns_content;
    }

    public String getDns_name() {
        return dns_name;
    }

    public void setDns_name(String dns_name) {
        this.dns_name = dns_name;
    }

    public String getDns_type() {
        return dns_type;
    }

    public void setDns_type(String dns_type) {
        this.dns_type = dns_type;
    }

    public String getDns_content() {
        return dns_content;
    }

    public void setDns_content(String dns_content) {
        this.dns_content = dns_content;
    }
}
