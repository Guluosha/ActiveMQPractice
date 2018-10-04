package org.oreo.activemqwithmanual.service;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/2/28 ~ 下午 10:48
 */

public interface AlertService {

	/**
	 * 发送消息
	 * @param message 消息
	 */
	void sendAlertString(String message);
}
