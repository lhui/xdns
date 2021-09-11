package io.beiji.xdns.dns;

import lombok.Data;

import java.util.List;

@Data
public class DNSResponse {
 private List<DNSModel> dnsModelList;

 public DNSResponse(List<DNSModel> dnsModelList) {
  this.dnsModelList = dnsModelList;
 }
}
