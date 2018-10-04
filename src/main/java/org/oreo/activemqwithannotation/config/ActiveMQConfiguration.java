package org.oreo.activemqwithannotation.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.*;
import org.springframework.jms.core.JmsTemplate;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/13 ~ 下午 4:44
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySource(value = {"classpath*:*.properties"}, encoding = "utf-8", ignoreResourceNotFound = true)
@ComponentScan(basePackages = {"org.oreo.activemqwithannotation"})
public class ActiveMQConfiguration {

	@Bean
	public ActiveMQConnectionFactory getActiveMQConnectionFactoryBean() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:22220");
		activeMQConnectionFactory.setUserName("admin");
		activeMQConnectionFactory.setPassword("admin");
		return activeMQConnectionFactory;
	}

	@Bean
	public ActiveMQQueue getActiveMQQueue() {
		ActiveMQQueue activeMQQueue = new ActiveMQQueue("sampleQueue");
		activeMQQueue.setPhysicalName("sampleQueue");
		return activeMQQueue;
	}

	@Bean
	public ActiveMQTopic getActiveMQTopic() {
		ActiveMQTopic activeMQTopic = new ActiveMQTopic("sampleTopic");
		activeMQTopic.setPhysicalName("sampleTopic");
		return activeMQTopic;
	}

	@Bean
	public JmsTemplate getJMSQueueTemplate() {
		JmsTemplate jmsQueueTemplate = new JmsTemplate(getActiveMQConnectionFactoryBean());
		jmsQueueTemplate.setDefaultDestination(getActiveMQQueue());
		jmsQueueTemplate.setPubSubDomain(false);
		return jmsQueueTemplate;
	}
}