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

@Autowired
    ApplicationContext ctx;

	@Autowired
    @Qualifier("helloService")
	private PollingConsumer helloService ;


	@Autowired
	@Qualifier("helloService.handler")
	private MessageHandler eipBeanHandler;

    @Test
    public void name() {


    }
}