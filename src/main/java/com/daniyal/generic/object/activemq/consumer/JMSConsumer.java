package com.daniyal.generic.object.activemq.consumer;


import com.daniyal.generic.object.model.Employee;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSConsumer{


    @JmsListener(destination = "${queue.read.objects.request}", containerFactory = "jsaFactory")
    public Employee consume(Employee employees) {
        System.out.println("Received Object Alert Codes");
        return employees;
    }

}
