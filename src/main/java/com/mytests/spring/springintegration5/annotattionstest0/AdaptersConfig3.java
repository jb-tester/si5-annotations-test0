package com.mytests.spring.springintegration5.annotattionstest0;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.PollableChannel;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.function.Supplier;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 9/12/2018.
 * Project: si5-annotations-test0
 * *******************************
 */
@Configuration
@EnableIntegration
public class AdaptersConfig3 {

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata defaultPoller() {
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(new PeriodicTrigger(10));
        return pollerMetadata;
    }
    @Bean
    public PollableChannel ica3channel(){
        return new QueueChannel();
    }



    @Bean
    public DirectChannel pollerErrorChannel(){
        return new DirectChannel();
    }

    @InboundChannelAdapter("ica3channel")
    public String myAdapter3() {

            return "bazz";

    }
}
