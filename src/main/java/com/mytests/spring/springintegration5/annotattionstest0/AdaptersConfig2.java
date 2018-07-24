package com.mytests.spring.springintegration5.annotattionstest0;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.EndpointId;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.PollableChannel;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.function.Supplier;

@Configuration
@EnableIntegration
public class AdaptersConfig2 {



    @Bean
    public PollableChannel ica2channel(){
        return new QueueChannel();
    }



    @Bean
    @InboundChannelAdapter(value = "ica2channel", poller = @Poller(fixedRate = "1000"))
    public Supplier<String> myadapter2() {
        return () -> {
            return "bar";
        };
    }
}
