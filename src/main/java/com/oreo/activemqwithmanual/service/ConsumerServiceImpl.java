package com.oreo.activemqwithmanual.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/2/28 ~ 下午 11:42
 */
@Component
public class ConsumerServiceImpl implements ConsumerService {

	private static JmsOperations JMSOPERATIONS;
	@Value(value = "${QueueName}")
	private static String QUEUE;

	@Override
	public String receiveMessage() {
		return JMSOPERATIONS.receiveAndConvert(QUEUE).toString();
	}
}