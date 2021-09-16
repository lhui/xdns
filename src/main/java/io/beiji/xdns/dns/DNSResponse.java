package io.beiji.xdns.dns;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
public class DNSResponse implements Serializable {
    private List<DNSModel> dnsModelList;

    public DNSResponse(List<DNSModel> dnsModelList) {
        this.dnsModelList = dnsModelList;
    }

    public List<DNSModel> getDnsModelList() {
        return dnsModelList;
    }

    public void setDnsModelList(List<DNSModel> dnsModelList) {
        this.dnsModelList = dnsModelList;
    }
}
