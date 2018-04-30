package com.jiehang.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 监听器消费，无需手动消费
 */
public class QueueMessageListener implements MessageListener {

    public void onMessage(Message message) {

        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " listen the message: " +
                    ((TextMessage) message).getText());
        } catch (JMSException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}