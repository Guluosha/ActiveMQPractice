package org.oreo.activemqwithannotation.producer;

import org.oreo.activemqwithannotation.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jms.core.*;
import org.springframework.stereotype.*;

import javax.annotation.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/13 ~ 下午 6:11
 */
@Component
public class MessageProducer implements AlertService {

	@Resource
	private JmsOperations JMSOPERATIONS;
	@Value(value = "${QueueName}")
	private String QUEUENAME;

	@Override
	public void sendAlertMessage(String message) {
		JMSOPERATIONS.send(QUEUENAME, session -> session.createTextMessage(message));
	}
}
