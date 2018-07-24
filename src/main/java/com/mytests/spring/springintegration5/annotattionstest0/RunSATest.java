package com.mytests.spring.springintegration5.annotattionstest0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

public class RunSATest {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ServiceActivatorsConfig.class);
        PollableChannel in = ctx.getBean("channel2", PollableChannel.class);
        in.send(new GenericMessage<String>("hello"));
        PollableChannel out = ctx.getBean("channel1", PollableChannel.class );
        Message mess = out.receive(100);
        System.out.println(mess);

        PollableChannel in1 = ctx.getBean("channel21", PollableChannel.class);
        in1.send(new GenericMessage<String>("hello"));
        PollableChannel out1 = ctx.getBean("channel11", PollableChannel.class );
        Message mess1 = out1.receive(100);
        System.out.println(mess1);

        PollableChannel in2 = ctx.getBean("channel22", PollableChannel.class);
        in2.send(new GenericMessage<String>("hello"));
        PollableChannel out2 = ctx.getBean("channel12", PollableChannel.class );
        Message mess2 = out2.receive(100);
        System.out.println(mess2);


        ((AnnotationConfigApplicationContext) ctx).close();
    }
}
