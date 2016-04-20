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
      <tr>
      <th>学号</th><th>次数</th><th>详细成绩</th><th>本次成绩</th><th>时间</th>
      </tr>
     <s:iterator value="#request.list" id="work">
     <tr>
      <td><s:property value="#work.studentId" /></td>
      <td><s:property value="#work.cishu" /></td>
      <td><s:property value="#work.gradeDetail" /></td>
      <td><s:property value="#work.grade"/></td>
     <!-- <s:property value="#work.time"/> -->
       <td><s:date name="#work.time" format="yyyy-MM-dd hh:mm:ss" /></td>
     </tr>
     </s:iterator>
     <tr>
     <td>总成绩</td>
     <td><s:property value="#request.total"/></td>
     </tr>
    </table>
  </body>
</html>
