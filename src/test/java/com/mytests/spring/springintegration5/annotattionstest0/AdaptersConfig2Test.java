package com.mytests.spring.springintegration5.annotattionstest0;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Supplier;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AdaptersConfig2.class)
public class AdaptersConfig2Test {



    @Autowired
    @Qualifier("adaptersConfig2.myadapter2.inboundChannelAdapter")
    private SourcePollingChannelAdapter adapter2;


    @Autowired
    @Qualifier("myadapter2")
    private Supplier<?> messageSource2;



    @Test
    public void testAdapters() {
        Assert.assertNotNull(adapter2);
        Assert.assertNotNull(messageSource2);
        System.out.println(adapter2.getComponentName());
        System.out.println(messageSource2.get());
    }
}