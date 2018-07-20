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
public class AdaptersConfig {

    @Bean
    public PollableChannel channel1(){
        return new QueueChannel();
    }

    @Bean
    public PublishSubscribeChannel channel2(){
        return new PublishSubscribeChannel();
    }

    @Bean
    public DirectChannel channel3(){
        return new DirectChannel();
    }

    @Bean
    public PollerMetadata myPoller() {
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(new PeriodicTrigger(1000));
        return pollerMetadata;
    }

    @Bean("myadapter.source")
    @EndpointId("myadapter")
    @InboundChannelAdapter(value = "channel1", poller = @Poller(value = "myPoller", errorChannel = "channel3"))
    public Supplier<String> pojoSupplier() {
        return () -> {
            return "foo";
        };
    }

}
