package com.web.gmall;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.web.gmall.service.OrderService;

public class MainApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");

		OrderService orderService = applicationContext.getBean(OrderService.class);

		System.out.println("消费者启动成功");
		orderService.initOrder("1");
		System.out.println("消费者实现类：调用完成....");
		System.in.read();
	}
}
