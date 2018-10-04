package org.oreo.activemqwithannotation.consumer;

import org.oreo.activemqwithannotation.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jms.core.*;
import org.springframework.stereotype.*;

import javax.annotation.*;

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
