<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
    <title>登陆成功</title>
     <link href="css/style1.css" rel="stylesheet" type="text/css"/>
   </head>
  
  <body bgcolor="#FFFFF0"> 
 <!-- <script type="text/javascript"> alert("登陆成功！");</script>-->
   <div align="right">你好！<s:property value="#session.user.id"/></div>
  <font size="20"><s:a href="seeAnm.action">查看公告</s:a>
       <a href="modifypassword.jsp">修改密码</a>
    <%
   Integer iden = (Integer)session.getAttribute("iden"); 
   if(iden==0) {%>
         <s:a href="check/publish.jsp">发布公告</s:a>
         <s:a href="seeAllStudent.action">查看所有学生</s:a>
         <s:a href="seeClass.action">班级管理</s:a>
          <s:a href="addClassView.action">添加班级</s:a>
           <s:a href="showTeacher.action">查看老师</s:a>
<%} else if(iden==1){ %>
       <a href="check/addstudent.jsp">添加学生</a>
        <s:a href="checkwork.action">检查作业</s:a>
         <s:a href="studentTotalGrade.action">学生总成绩</s:a>
         <s:a href="showStudent.action">汇总总成绩</s:a>
 <%}else{ %>
       <s:a href="checkwork.jsp">查看作业</s:a>
       <s:a href="check/uploadwork.jsp">上传作业</s:a>
       <s:a href="studentViewTotal.action">查看总成绩</s:a>
 <%}%>
</font>
  </body>
</html>
