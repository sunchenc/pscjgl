<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.jspsmart.upload.*" %>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
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
  
  <body bgcolor="#FFFFF0" >
   <div align="right">你好！<s:property value="#session.user.id"/></div>
<%
    String from=request.getHeader("referer");
 //   if((from==null)||(from.indexOf("localhost:8080/checkwork.jsp")<0)){
 //   out.print("<script>alert('sorry');window.location.href='http://localhost:8080/checkwork.jsp';</script>");
 //   }
 //   else{
   
    response.setCharacterEncoding("utf-8");
    String path=request.getParameter("path");
    path=new String(path.getBytes("iso-8859-1"));
//   String fileName=path.substring(path.lastIndexOf("\\")+1);
    SmartUpload su=new SmartUpload();
    su.initialize(pageContext);
    su.setContentDisposition(null);
    su.downloadFile(path);
    
    out.clear();
    out=pageContext.pushBody();
 //   }
%>

   
  </body>
</html>
