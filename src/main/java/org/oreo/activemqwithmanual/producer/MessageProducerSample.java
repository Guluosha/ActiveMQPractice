package org.oreo.activemqwithmanual.producer;

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

public class MessageProducerSample {

	private static final Logger LOGGER = LogManager.getLogger(MessageProducerSample.class);

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String USERPASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
//	private static final String DEFAULTBROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final String DEFAULTBROKERURL = "tcp://localhost:22220";
	private static final int SENDERNUM = 10;

	public static void main(String[] args) {
		LOGGER.debug("程序开始");
		ConnectionFactory connectionFactory;
		Connection connection = null;
		Session session = null;
		Destination destination;
		MessageProducer messageProducer;
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, USERPASSWORD, DEFAULTBROKERURL);
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("HelloWorld");
			messageProducer = session.createProducer(destination);
			for (int index = 0; index < SENDERNUM; index++) {
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				TextMessage textMessage = session.createTextMessage("发送消息：" + index);
				System.out.println(textMessage);
				messageProducer.send(textMessage);
			}
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
		LOGGER.debug("程序结束");
	}
}