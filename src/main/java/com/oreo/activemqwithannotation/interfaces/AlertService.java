package com.oreo.activemqwithannotation.interfaces;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/13 ~ 下午 5:43
 * @apiNote 演示服务，生产者使用该服务发送消息
 */

public interface AlertService {

	/**
	 * 生产者实现该方法，发送消息
	 * @param message String，要发送的消息
	 * @return String，返回发送消息后的自定义结果
	 */
	void sendAlertMessage(String message);
}
