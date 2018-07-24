package com.mytests.spring.springintegration5.annotattionstest0;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.EndpointId;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.handler.ServiceActivatingHandler;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.PollableChannel;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.function.Supplier;

@Configuration
@EnableIntegration
@ComponentScan("com.mytests.spring.springintegration5.annotattionstest0.components")
public class ServiceActivatorsConfig {

    @Bean
    public PollableChannel channel1(){
        return new QueueChannel();
    }

    @Bean
    public PollableChannel channel2(){
        return new QueueChannel();
    }
    @Bean
    public PollableChannel channel11(){
        return new QueueChannel();
    }

    @Bean
    public PollableChannel channel21(){
        return new QueueChannel();
    }
    @Bean
    public PollableChannel channel12(){
        return new QueueChannel();
    }

    @Bean
    public PollableChannel channel22(){
        return new QueueChannel();
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

    @Bean("helloService.handler")
    @EndpointId("helloService")
    @ServiceActivator( inputChannel = "channel2")
    public MessageHandler sa1(){

        MessageHandler handler = new ServiceActivatingHandler(service1(),"servicemethod");
        ((ServiceActivatingHandler) handler).setOutputChannel(channel1());
        return handler;
    }

    @Bean
    @ServiceActivator( inputChannel = "channel21")
    public MessageHandler sa2(){

        MessageHandler handler = new ServiceActivatingHandler(service1(),"servicemethod2");
        ((ServiceActivatingHandler) handler).setOutputChannel(channel11());
        return handler;
    }


    @Bean
    MyService1 service1(){
        return new MyService1();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata defaultPoller() {
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(new PeriodicTrigger(10));
        return pollerMetadata;
    }
}
