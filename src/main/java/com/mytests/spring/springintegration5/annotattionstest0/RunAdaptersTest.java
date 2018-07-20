package com.mytests.spring.springintegration5.annotattionstest0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

public class RunAdaptersTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AdaptersConfig.class);

        PollableChannel out = ctx.getBean("channel1", PollableChannel.class );
        Message mess = out.receive(100);
        System.out.println(mess);
        System.out.println("_________________________");

        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        ((AnnotationConfigApplicationContext) ctx).close();
    }
}
