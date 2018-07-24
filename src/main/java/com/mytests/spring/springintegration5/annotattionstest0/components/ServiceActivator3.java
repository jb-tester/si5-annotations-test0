package com.mytests.spring.springintegration5.annotattionstest0.components;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class ServiceActivator3 {

   @ServiceActivator(inputChannel = "channel22", outputChannel = "channel12")
   public String  servicemethod3(String arg){
       return "+++++"+arg+"+++++";
   }
}
