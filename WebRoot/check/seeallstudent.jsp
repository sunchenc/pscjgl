<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head><title>所有学生</title>
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
  <hr color="#FAFAFA"/>
    <table width="60%" cellspacing="0" cellpadding="0">
      <tr>
      <th>学号</th><th>名字</th><th>成绩</th><th>班级</th><th>老师</th>
      </tr>
      
     <s:iterator value="#request.list" id="student">
     <tr>
      <td><s:property value="#student.studentId" /></td>
      <td><s:property value="#student.studentName" /></td>
      <td><s:property value="#student.totalGrade" /></td>
      <td><s:property value="#student.tbclass.className"/></td>
      <td><s:property value="#student.tbclass.teacher.teacherName"/></td>
     </tr>
     </s:iterator>
     <tr><td> <a href="addStudentView.action" target="right">添加学生</a></td></tr>
    </table>
  </body>
</html>
