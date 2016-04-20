<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head><title>某老师的学生</title>
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
     <%
   Integer iden = (Integer)session.getAttribute("iden"); %>
      <tr>
      <th>学号</th><th>名字</th><th>班级</th><th>修改</th><th>删除</th>
      <%if(iden==1){%>
      <th>录入成绩</th>
      <%} %>
      </tr>
  
     <s:iterator value="#request.list" id="student">
     <tr >
      <td><s:property value="#student.studentId" /></td>
      <td><s:property value="#student.studentName" /></td>
      <td><s:property value="#student.tbclass.className"/></td>
      <td><a href="modifyStudentView.action?student.studentId=<s:property value="#student.studentId"/>">修改</a></td>
      <td><a href="deleteStudent.action?student.studentId=<s:property value="#student.studentId"/>" onClick="if(!confirm('确定删除吗？'))return false;else return true;">删除</a></td>
      <%if(iden==1){%>
      <td><a href="check/summary.jsp?studentId=<s:property value="#student.studentId"/>">整合总成绩</a></td>
      <%} %>
     </tr>
     </s:iterator>
    </table>
  </body>
</html>
