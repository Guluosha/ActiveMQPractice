package com.oreo.activemqwithspring.consumer;

import org.springframework.stereotype.Component;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/3/16 ~ 下午 3:10
 */
@Component
public class SampleConsumer {
	public void disPlayMessage() {
		System.out.println("我来处理消息");
	}
}
