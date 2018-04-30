package com.jiehang.consumer;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * 消费者
 */
public class Consumer {

    private JmsTemplate jmsTemplate;

    public void receive(Destination destination) {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        try {
            System.out.println("get message from " + destination.toString() + ": " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
