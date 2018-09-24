package com.oreo.activemqwithmanual.service;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/2/28 ~ 下午 11:42
 */

public interface ConsumerService {

	/**
	 * 消费者接收消息后并处理
	 * @return
	 */
	String receiveMessage();
}
