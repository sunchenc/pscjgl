<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head><title>计算机老师</title>
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
   }
      th{
    border-bottom-width:thin;
    border-bottom-style:solid;
    border-bottom-color:#CF3;
   }
   table{
     margin:0 auto;padding:0;
   }
   </style>
   </head>
  <body>
   <div align="right">你好！<s:property value="#session.user.id"/></div>
    <table width="60%" cellspacing="0" cellpadding="0">
      <tr>
        <th>学号</th><th>名字</th><th>删除</th><th>修改</th>
      </tr>
     <s:iterator value="#request.list" id="teacher">
     <tr>
      <td><s:property value="#teacher.teacherId" /></td>
      <td><s:property value="#teacher.teacherName" /></td>   
       <td><a href="deleteTeacher.action?teacher.teacherId=<s:property value="#teacher.teacherId"/>" onClick="if(!confirm('确定删除吗？'))return false;else return true;">删除</a></td>
        <td><a href="modifyTeacherView.action?teacher.teacherId=<s:property value="#teacher.teacherId"/>">修改</a></td>
     </tr>
     </s:iterator>
     <tr><td> <a href="check/addteacher.jsp" target="right">添加老师</a></td></tr>
    </table>
  </body>
</html>
