package io.beiji.xdns.dns;


import lombok.Data;

@Data
public class DNSRecordResponse {
    private String id;

    private String type;

    private String name;

    private String content;

    private boolean proxiable;

    private boolean proxied;

    private int ttl;

    private boolean locked;

    private String zone_id;

    private String zone_name;

    private String created_on;

    private String modified_on;

    private DataModel data;

    private Meta meta;
}
