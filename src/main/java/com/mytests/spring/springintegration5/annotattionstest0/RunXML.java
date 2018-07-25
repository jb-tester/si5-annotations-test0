package com.mytests.spring.springintegration5.annotattionstest0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 7/25/2018.
 * Project: si5-annotations-test0
 * *******************************
 */
public class RunXML {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("xml-config.xml");

        PollableChannel out = ctx.getBean("ica_channel", PollableChannel.class);
        Message mess = out.receive(100);
        System.out.println(mess);
        DirectChannel in = ctx.getBean("in", DirectChannel.class);
        in.send(new GenericMessage <String>("hello"));
        PollableChannel out2 = ctx.getBean("out", PollableChannel.class);
        Message mess2 = out2.receive(100);
        System.out.println(mess2);
    }
}
