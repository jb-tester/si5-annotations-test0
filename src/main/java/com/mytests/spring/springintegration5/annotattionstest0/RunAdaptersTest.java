package com.mytests.spring.springintegration5.annotattionstest0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

public class RunAdaptersTest {

    public static void main(String[] args) {
        testAdaptersFromDiffContexts(AdaptersConfig0.class, "ica0channel");
        testAdaptersFromDiffContexts(AdaptersConfig1.class, "ica1channel");
        testAdaptersFromDiffContexts(AdaptersConfig2.class, "ica2channel");

    }

    private static void testAdaptersFromDiffContexts(Class configClass, String channel) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(configClass);

        PollableChannel out = ctx.getBean(channel, PollableChannel.class );
        Message mess = out.receive(100);
        System.out.println(mess);
        ((AnnotationConfigApplicationContext) ctx).close();
    }
}
