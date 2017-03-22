package cn.xvkang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xvkang.dao.HelloMapper;

@Service
public class HelloService {
	@Autowired
	HelloMapper helloMapper;
	
	public String hello(){
		return helloMapper.hello();
	}
}
