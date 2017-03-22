<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="baseurl" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>平台</title>

<script type="text/javascript" src="${baseurl }/js/jquery-1.4.4.js"></script>
<script type="text/javascript">
	//登录提示方法
	function loginsubmit() {
		$("#loginform").submit();

	}
	function swap(newImg){
			
		  newImg.src = '${baseurl}/validatecode.jsp?' +new Date().getTime();
		  
	}
	
</script>
</head>
<body>
<h1>${pageContext.request.contextPath}</h1>
<h1>${loginMessage }</h1>
<h1>${shiroLoginFailure }</h1>
	<form id="loginform" name="loginform" action="${baseurl}/login.action"
		method="post">
		<div class="logincon">

			<div class="tab_con">

			
					
							用户名：
							<input type="text" id="usercode"
								name="username" style="WIDTH: 130px" />
						
						
							密 码：
							<input type="password" id="pwd" name="password"
								style="WIDTH: 130px" />
						
						
							验证码：
						<input id="randomcode" name="randomcode" size="8" /> <img
								id="randomcode_img" src="${baseurl}/validatecode.jsp" 
								width="50" height="20"  onclick="swap(this);"/> 
								
						
							
							<input type="checkbox" name="rememberMe" />自动登陆
						

						
							<input type="button"
								class="btnalink" onclick="loginsubmit()" value="登&nbsp;&nbsp;录" />
								<input type="reset" class="btnalink" value="重&nbsp;&nbsp;置" />
				

			</div>
		</div>
	</form>
	
</body>
</html>
