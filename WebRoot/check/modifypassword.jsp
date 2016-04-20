<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head><title>修改密码</title>
   <style type="text/css">
   body{
    background-color:"#FFFFF0";
   }
  tr{
  background-color:powderblue;
  }
      td{
    border-bottom-width:thin;
    border-bottom-style:solid;
    border-bottom-color:#CF3;
    text-align:center;
    height:40px;
   }
    th{
    border-bottom-width:thin;
    border-bottom-style:solid;
    border-bottom-color:#CF3;
    height:40px;
   }
   table{
     margin:0 auto;padding:0;
   }
  </style>
  </head>
  <body> 
   <div align="right">你好！<s:property value="#session.user.id"/></div>
  <table align="center">
  <s:form action="modifyPassword" method="post" validate="true">
  <tr><td>用户名:</td><td><input type="text" name="login.id" size="20" value="<s:property value="#session.user.id"/>"readonly/>
   </td>
   </tr>
   <tr><td><s:password name="oldpassword" label="原密码" size="20"/></td></tr>
   <tr><td><s:password name="newpassword" label="新密码" size="20"/></td></tr>
  <tr><td><s:password name="login.password" label="确认密码" size="20"/></td></tr>	
  <tr align="center"><td><s:submit value="修改"></s:submit></td></tr>
  </s:form>
   </table>
  </body>
</html>