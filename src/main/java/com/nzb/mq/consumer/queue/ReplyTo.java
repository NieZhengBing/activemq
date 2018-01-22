package com.nzb.mq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ReplyTo {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(final String consumerMsg, Message produceMessage) throws JmsException, JMSException {
		jmsTemplate.send(produceMessage.getJMSReplyTo(), new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				Message msg = session.createTextMessage("QueueReceiverl accept msg " + consumerMsg);
				return msg;
			}

		});

	}
}
