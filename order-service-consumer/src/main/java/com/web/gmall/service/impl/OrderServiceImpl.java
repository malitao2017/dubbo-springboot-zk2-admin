package com.web.gmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.web.gmall.bean.UserAddress;
import com.web.gmall.service.OrderService;
import com.web.gmall.service.UserService;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 		2）、配置服务提供者
 *
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 * @author lfy
 *
 */
@Service
public class OrderServiceImpl implements OrderService {



	@Autowired
	UserService userService;

	@Override
	public List<UserAddress> initOrder(String userId) {
		System.out.println("消费者实现类的调用：用户id："+userId);
//		1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		System.out.println("消费者实现类的接收到的数据为：");
		for (UserAddress userAddress : addressList) {
			System.out.println(userAddress.getUserAddress());
		}
		return addressList;
	}



}
