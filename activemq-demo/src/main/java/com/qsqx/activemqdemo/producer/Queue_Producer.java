package com.qsqx.activemqdemo.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
public class Queue_Producer {
    //JmsMessagingTemplate是Springboot的Jms模板,Spring的是JmsTemplate
    private JmsMessagingTemplate jmsMessagingTemplate;

    //把ConfigBean类的ActiveMQQueue注入进来
    private ActiveMQQueue activeMQQueue;

    //发送Queue的方法
    @RequestMapping(value = "/producer")
    public void producerMsg() {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.now();
//        String Date = dateTimeFormatter.format(localDateTime);
        jmsMessagingTemplate.convertAndSend(activeMQQueue, "**************" + UUID.randomUUID().toString());
    }

    //构造注入对象(推荐)
    public Queue_Producer(JmsMessagingTemplate jmsMessagingTemplate, ActiveMQQueue activeMQQueue) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
        this.activeMQQueue = activeMQQueue;
    }

}
 
 
