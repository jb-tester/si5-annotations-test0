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
@ContextConfiguration(classes = AdaptersConfig.class)
public class AdaptersConfigTest {


	@Autowired
    @Qualifier("myadapter")
	private SourcePollingChannelAdapter adapter;


    @Autowired
    @Qualifier("myadapter.source")
    private Supplier<?> messageSource;



    @Test
    public void name() {
        Assert.assertNotNull(adapter);
        Assert.assertNotNull(messageSource);
        System.out.println(adapter.getMessageSource().toString());
        System.out.println(messageSource.get());
    }
}