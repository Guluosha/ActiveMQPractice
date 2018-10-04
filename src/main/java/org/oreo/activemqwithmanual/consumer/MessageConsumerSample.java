package org.oreo.activemqwithmanual.consumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jms.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/3/16 ~ 下午 12:47
 */

public class MessageConsumerSample {

	private static final Logger LOGGER = LogManager.getLogger(MessageConsumerSample.class);

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String USERPASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String DEFAULTBROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) {
		LOGGER.debug("程序开始");
		ConnectionFactory connectionFactory;
		Connection connection;
		Session session;
		Destination destination;
		MessageConsumer messageConsumer;
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, USERPASSWORD, DEFAULTBROKERURL);
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("HelloWorld");
			messageConsumer = session.createConsumer(destination);
			while (true) {
				TextMessage textMessage = (TextMessage) messageConsumer.receive();
				if (textMessage != null) {
					System.out.println("接收到的消息：" + textMessage.getText());
				} else {
					break;
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
		LOGGER.debug("程序结束");
	}
}