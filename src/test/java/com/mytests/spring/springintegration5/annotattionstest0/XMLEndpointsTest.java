package com.mytests.spring.springintegration5.annotattionstest0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.endpoint.EventDrivenConsumer;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
import org.springframework.messaging.MessageHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:xml-config.xml")
public class XMLEndpointsTest {

    // Tests implicit bean names for beans configured in xml

    @Autowired
    ApplicationContext ctx;

    //service-activator:
	@Autowired
    @Qualifier("sa_xml")
	private EventDrivenConsumer sa4 ;

	@Autowired
	@Qualifier("sa_xml.handler")
	private MessageHandler sa4Handler;

    // inbound-channel-adapter:
    @Autowired
    @Qualifier("ica_xml")
    private SourcePollingChannelAdapter ica4;


    @Autowired
    @Qualifier("ica_xml.source")
    private MessageSource messageSource;


    @Test
    public void name() {
        System.out.println(ctx.getBean("sa_xml").getClass());

    }
}