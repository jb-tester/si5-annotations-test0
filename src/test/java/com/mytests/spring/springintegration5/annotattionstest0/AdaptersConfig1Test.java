package com.mytests.spring.springintegration5.annotattionstest0;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Supplier;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AdaptersConfig1.class)
public class AdaptersConfig1Test {



    @Autowired
    @Qualifier("myAdapter11.myadapter11.inboundChannelAdapter")
    private SourcePollingChannelAdapter adapter11;


    @Autowired
    @Qualifier("myAdapter11.myadapter11.inboundChannelAdapter.source")
    private MessageSource messageSource11;



    @Test
    public void testAdapters() {
        Assert.assertNotNull(adapter11);
        Assert.assertNotNull(messageSource11);
        System.out.println(adapter11.getComponentName());
        System.out.println(messageSource11.toString());
    }
}