package com.mytests.spring.springintegration5.annotattionstest0.components;

import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;

import java.util.function.Supplier;

@MessageEndpoint
public class MyAdapter1Component {
    @InboundChannelAdapter(value = "channel11", poller = @Poller(fixedRate = "1000"))
    public Supplier<?> myadapter1() {
        return () -> {
            return "boo";
        };

    }
}
