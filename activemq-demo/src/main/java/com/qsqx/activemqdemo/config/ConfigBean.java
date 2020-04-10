package com.qsqx.activemqdemo.config;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConfigBean {
    @Value("${myQueueName}")
    private String myQueueName;

    @Bean
    public ActiveMQQueue queue() {
        //创建一个ActiveMQQueue
        return new ActiveMQQueue(myQueueName);
    }
}
 
 
