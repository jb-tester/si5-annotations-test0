package com.mytests.spring.springintegration5.annotattionstest0.ica_components;

import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;

@MessageEndpoint
public class MyAdapter1Component {
    @InboundChannelAdapter(value = "ica1channel", poller = @Poller(fixedRate = "1000"))
    public String myadapter1() {
        return "boo";
    }
}
