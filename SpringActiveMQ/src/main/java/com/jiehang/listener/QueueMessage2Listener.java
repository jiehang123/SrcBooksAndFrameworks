package com.jiehang.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueMessage2Listener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(Thread.currentThread().getName() + " listen the message: " +
                    ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
