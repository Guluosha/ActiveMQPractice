package org.oreo.activemqwithannotation;

import com.oreo.activemqwithannotation.config.ActiveMQConfiguration;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.oreo.activemqwithannotation.config.*;
import org.oreo.observersubscribe.activemqwithannotation.config.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/14 ~ 下午 4:26
 */

public class ActiveMQWithAnnotationEntrance {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ActiveMQConfiguration.class);
		applicationContext.refresh();
		ActiveMQConnectionFactory activeMQConnectionFactoryBean = applicationContext.getBean("getActiveMQConnectionFactoryBean", ActiveMQConnectionFactory.class);
		System.out.println(activeMQConnectionFactoryBean + activeMQConnectionFactoryBean.getBeanName());
		applicationContext.close();
	}
}
