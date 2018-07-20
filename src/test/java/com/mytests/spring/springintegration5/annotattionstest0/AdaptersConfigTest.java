package com.mytests.spring.springintegration5.annotattionstest0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Supplier;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AdaptersConfig.class)
public class AdaptersConfigTest {


	@Autowired
    @Qualifier("myadapter")
	private SourcePollingChannelAdapter adapter;


    @Autowired
    @Qualifier("myadapter.source")
    private Supplier<?> adapterSource;

    @Test
    public void name() {
        System.out.println(adapter.getMessageSource().toString());
        System.out.println(adapterSource.toString());
    }
}