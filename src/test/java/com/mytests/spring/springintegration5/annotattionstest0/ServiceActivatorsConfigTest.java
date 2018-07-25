package com.mytests.spring.springintegration5.annotattionstest0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.endpoint.EventDrivenConsumer;
import org.springframework.integration.endpoint.PollingConsumer;
import org.springframework.messaging.MessageHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceActivatorsConfig.class)
public class ServiceActivatorsConfigTest {

    // Test bean names for endpoints configured using annotations:
    @Autowired
    ApplicationContext ctx;

    // @EndpointId test:
	@Autowired
    @Qualifier("helloService")
	private PollingConsumer helloService ;

	@Autowired
	@Qualifier("helloService.handler")
	private MessageHandler helloHandler;

	// @ServiceActivator-annotated @Bean method:
    @Autowired
    @Qualifier("serviceActivatorsConfig.sa2.serviceActivator")
    private PollingConsumer sa2 ;

    @Autowired
    @Qualifier("sa2")
    private MessageHandler sa2Handler;

    //@ServiceActivator-annotated method in component:
    @Autowired
    @Qualifier("serviceActivator3.servicemethod3.serviceActivator")
    private PollingConsumer sa3 ;

    @Autowired
    @Qualifier("serviceActivator3.servicemethod3.serviceActivator.handler")
    private MessageHandler sa3Handler;



    @Test
    public void name() {


    }
}