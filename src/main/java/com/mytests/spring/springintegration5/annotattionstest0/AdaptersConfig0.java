package com.mytests.spring.springintegration5.annotattionstest0;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.EndpointId;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.PollableChannel;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.function.Supplier;

@Configuration
@EnableIntegration
public class AdaptersConfig0 {

    @Bean
    public PollableChannel ica0channel(){
        return new QueueChannel();
    }



    @Bean
    public DirectChannel pollerErrorChannel(){
        return new DirectChannel();
    }

    @Bean(name = "myPoller0")
    public PollerMetadata myPoller() {
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(new PeriodicTrigger(1000));
        return pollerMetadata;
    }


    @Bean("myadapter.source")
    @EndpointId("myadapter")
    @InboundChannelAdapter(value = "ica0channel", poller = @Poller(value = "myPoller0", errorChannel = "pollerErrorChannel"))
    public Supplier<String> pojoSupplier() {
        return () -> {
            return "foo";
        };
    }

}
