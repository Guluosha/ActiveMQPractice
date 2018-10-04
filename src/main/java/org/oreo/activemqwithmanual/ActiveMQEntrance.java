package org.oreo.activemqwithmanual;

import com.oreo.activemqwithmanual.service.AlertServiceImpl;
import com.oreo.activemqwithmanual.service.ConsumerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.oreo.activemqwithmanual.service.*;
import org.oreo.observersubscribe.activemqwithmanual.service.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/3/16 ~ 上午 10:50
 */

public class ActiveMQEntrance {

	private static final Logger LOGGER = LogManager.getLogger(ActiveMQEntrance.class);

	private static String contextLocation = "classpath:*.xml";

	public static void main(String[] args) {
		LOGGER.debug("程序开始");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(contextLocation);
		AlertServiceImpl alertServiceImpl = context.getBean("alertServiceImpl", AlertServiceImpl.class);
		ConsumerServiceImpl consumerServiceImpl = context.getBean("consumerServiceImpl", ConsumerServiceImpl.class);
		alertServiceImpl.sendAlertString("这句话是生产者发送的");
		String messageFromProducer = consumerServiceImpl.receiveMessage();
		System.out.println("生产者发送的消息是：" + messageFromProducer);
		context.close();
		System.out.println("啥意思？");
		LOGGER.debug("程序结束");
	}
}