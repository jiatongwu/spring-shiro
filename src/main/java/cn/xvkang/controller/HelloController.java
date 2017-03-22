package cn.xvkang.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xvkang.service.HelloService;

@Controller
@RequestMapping("/test")
public class HelloController {
	@Autowired
	HelloService helloService;
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return helloService.hello();
	}
	@RequestMapping("/testUserQuery")
	@ResponseBody
	@RequiresPermissions("user:query")
	public String testUserQuery(){
		return "has user:query";
	}
	@RequestMapping("/testItemQuery")
	@ResponseBody
	@RequiresPermissions("item:query")
	public String testItemQuery(){
		return "has item:query";
	}
}
