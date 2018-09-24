package com.oreo.activemqwithannotation.interfaces;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/13 ~ 下午 5:51
 * @apiNote 消费者实现的接口
 */

public interface ConsumerService {

	/**
	 * 消费者处理消息
	 *
	 * @param message String，要处理的消息
	 * @return String，处理完后返回的自定义结果
	 */
	String handleAlertMessage(String message);
}
