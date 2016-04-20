<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
    <title>My JSP 'login_success.jsp' starting page</title>
  </head>
   
  <body bgcolor="#FFFFF0" >
   <div align="right">你好！<s:property value="#session.user.id"/></div>
  <s:property value="#session.file"/>
    添加成功！ <br>
  </body>
</html>
