package com.oreo.activemqwithmanual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/2/28 ~ 下午 10:49
 */
@Component
public class AlertServiceImpl implements AlertService {

	private JmsOperations jmsOperations;
	@Value(value = "${QueueName}")
	private static String QUEUE;

	@Autowired
	public AlertServiceImpl(JmsOperations jmsOperations) {
		this.jmsOperations = jmsOperations;
	}

	@Override
	public void sendAlertString(final String message) {
		jmsOperations.send(QUEUE, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
}