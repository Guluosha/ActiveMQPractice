package org.oreo.activemqwithannotation.producer;

import com.oreo.activemqwithannotation.interfaces.AlertService;
import org.oreo.activemqwithannotation.interfaces.*;
import org.oreo.observersubscribe.activemqwithannotation.interfaces.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
