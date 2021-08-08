package io.beiji.xdns.dns;

import lombok.Data;
import org.springframework.validation.Errors;
import sun.misc.resources.Messages;

import java.util.List;

@Data
public class DNSResponse {

    private boolean success;

    private List<Errors> errors;

    private List<Messages> messages;

    private List<DNSRecordResponse> result;


}
