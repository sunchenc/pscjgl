<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <script type="text/javascript">
  function message(){ alert("整合成功！");}</script>
  <body bgcolor="#FFFFF0" onload="message()">
   
   <div align="right">你好！<s:property value="#session.user.id"/></div>
    This is my JSP page. <br>
    
  </body>
</html>
