package cn.xvkang.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xvkang.pojo.ActiveUser;



/**
 * 
 */
@Controller
public class LoginController {
	@RequestMapping("/unauthorized")
	public String unauthorized(){
		return "unauthorized";
		
	}
	//登陆提交地址，和applicationContext-shiro.xml中配置的loginurl一致
	@RequestMapping("/login")
	public String login(HttpServletRequest request)throws Exception{
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		//通过model传到页面
		//没有认证成功activeUser是空的
		System.out.println(activeUser);
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				request.setAttribute("loginMessage", "account not exist");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {
				request.setAttribute("loginMessage", "password error");
			} else if("randomCodeError".equals(exceptionClassName)){
				request.setAttribute("loginMessage", "验证码错误");
			}else {
				request.setAttribute("loginMessage", "其他错误");
			}
		}
		//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		//登陆失败还到login页面
		return "login";
	}
	
	//系统首页
	@RequestMapping("/success")
	public String first(Model model)throws Exception{
		
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		//通过model传到页面
		model.addAttribute("activeUser", activeUser);
		
		return "success";
	}
	
	//欢迎页面
	@RequestMapping("/welcome")
	public String welcome(Model model)throws Exception{
		
		return "welcome";
		
	}
	

	

}
