<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<c:set var="baseurl" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>认证通过</title>
</head>
<body>
	认证通过 ${activeUser.username } 在此页面测试下 权限是否可以使用
	<br/>
	<br/>
	<shiro:hasPermission name="user:create">
		有user:create权限
	</shiro:hasPermission>
	<br/>
	<shiro:hasPermission name="user:update">
		有user:update权限
	</shiro:hasPermission>
	<br/>
	<shiro:hasPermission name="user:delete">
		有user:delete权限
	</shiro:hasPermission>
	<br/>
	<shiro:hasPermission name="item:query">
		有item:query权限
	</shiro:hasPermission>
	<br/>
	<shiro:hasPermission name="item:update">
		有item:update权限
	</shiro:hasPermission>
	<br/>
	<shiro:hasPermission name="item:delete">
		有item:delete权限
	</shiro:hasPermission>
</body>
</html>