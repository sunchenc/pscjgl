<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>

<html>
  <head><title>查看作业</title>
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
  <link href="css/style1.css" rel="stylesheet" type="text/css"/>
  </head>
  <body bgcolor="#FFFFF0">
   <div align="right">你好！<s:property value="#session.user.id"/></div>
    <table width="60%" cellspacing="0" cellpadding="0">
      <tr>
        <th>学号</th><th>作业</th><th>次数</th><th>成绩</th><th>详细</th>
      </tr>
     <s:iterator value="#request.list" id="stuGrade">
     <tr>
      <td><s:property value="#stuGrade.studentId" /></td>
      <td><s:property value="#stuGrade.path" /></td>
      <td><s:property value="#stuGrade.cishu"/></td>
      <td><s:property value="#stuGrade.grade"/></td>
      <td><s:property value="#stuGrade.gradeDetail"/></td>
     </tr>
     </s:iterator>
    </table>
  </body>
</html>
