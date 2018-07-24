package com.mytests.spring.springintegration5.annotattionstest0;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.PollableChannel;

@Configuration
@EnableIntegration
@ComponentScan("com.mytests.spring.springintegration5.annotattionstest0.ica_components")
public class AdaptersConfig1 {



    @Bean
    public PollableChannel ica1channel(){
        return new QueueChannel();
    }





}
