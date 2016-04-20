<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>

<html>
  <head><title>检查作业</title>
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
   <s:form action="outputToExcel" method="post" enctype="multipart/form-data">
    <table width="60%" cellspacing="0" cellpadding="0">
      <tr>
        <th>学号</th><th>名字</th><th>班级</th><th>成绩</th>
      </tr>
     <s:iterator value="#request.list" id="stuTotal">
     <tr>
      <td><s:property value="#stuTotal.studentId" /></td>
      <td><s:property value="#stuTotal.studentName" /></td>
      <td><s:property value="#stuTotal.tbclass.className"/></td>
      <td><s:property value="#stuTotal.totalGrade"/></td> 
     </tr>
     </s:iterator>
     <tr>
      <td><s:submit value="导出"></s:submit> </td>
     </tr>
    </table>
   </s:form>
  </body>
</html>
