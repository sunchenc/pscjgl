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
      <th>班级</th><th>人数</th><th>老师</th><th>修改</th><th>删除</th>
      </tr>
      
     <s:iterator value="#request.list" id="tbClass">
     <tr>
      <td><s:property value="#tbClass.className" /></td>
      <td><s:property value="#tbClass.number" /></td>
      <td><s:property value="#tbClass.teacher.teacherName"/></td>
      <td><a href="modifyClassView.action?tbClass.id=<s:property value="#tbClass.id"/>">修改</a></td>
      <td><a href="deleteClass.action?tbClass.id=<s:property value="#tbClass.id"/>" onClick="if(!confirm('确定删除吗？'))return false;else return true;">删除</a></td>
      </tr>
     </s:iterator>
    </table>
  </body>
</html>
