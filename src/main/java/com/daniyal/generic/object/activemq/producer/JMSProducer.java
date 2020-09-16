package com.daniyal.generic.object.activemq.producer;


import com.daniyal.generic.object.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JMSProducer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${queue.read.objects.response}")
    String queue;

    public void send(Employee employee){
        jmsTemplate.convertAndSend(queue, employee);
    }
}
