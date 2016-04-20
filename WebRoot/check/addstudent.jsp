<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head><title>添加学生</title>
   <style type="text/css">
     body{
    background-color:"#FFFFF0";
   }
  tr{
  background-color:powderblue;
  }
  </style>
  </head>
  <body>
      <div align="right">你好！<s:property value="#session.user.id"/></div>
      <table>
        <tr>
          <td>
          <a href="addManyStudent.jsp"> 批量导入</a>
          </td>
        </tr>
              <tr>
          <td>
            <a href="addStudentView.action">单个导入</a>
          </td>
        </tr>
      </table>
  </body>
</html>
