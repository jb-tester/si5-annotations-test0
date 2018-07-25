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

    // test implicit bean names for ica configured as @InboundChannelAdapter-annotated method in component


    @Autowired
    @Qualifier("myAdapter1Component.myadapter1.inboundChannelAdapter") // should navigate to com.mytests.spring.springintegration5.annotattionstest0.ica_components.MyAdapter1Component.myadapter1 method
    private SourcePollingChannelAdapter adapter11;


    @Autowired
    @Qualifier("myAdapter1Component.myadapter1.inboundChannelAdapter.source")// should navigate to com.mytests.spring.springintegration5.annotattionstest0.ica_components.MyAdapter1Component.myadapter1 method
    private MessageSource messageSource11;



    @Test
    public void testAdapters() {
        Assert.assertNotNull(adapter11);
        Assert.assertNotNull(messageSource11);
        System.out.println(adapter11.getComponentName());
        System.out.println(messageSource11.receive());
    }
}