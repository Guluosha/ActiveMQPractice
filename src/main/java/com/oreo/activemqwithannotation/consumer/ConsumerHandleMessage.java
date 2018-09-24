package com.oreo.activemqwithannotation.consumer;

import com.oreo.activemqwithannotation.interfaces.ConsumerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/13 ~ 下午 5:55
 */
@Component
public class ConsumerHandleMessage implements ConsumerService {

	@Resource
	private JmsOperations JMSOPERATIONS;
	@Value(value = "${QueueName}")
	private String QUEUENAME;

	@Override
	public String handleAlertMessage(String message) {
		return JMSOPERATIONS.receiveAndConvert(QUEUENAME).toString();
	}
}
