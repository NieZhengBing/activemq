package com.nzb.mq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class QueueReceiver2 implements MessageListener {

	public void onMessage(Message message) {
		try {
			String textMsg = ((TextMessage) message).getText();
			System.out.println("QueueReceiver2 accept msg " + textMsg);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
