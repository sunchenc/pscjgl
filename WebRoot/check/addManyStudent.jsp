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
     <s:form action="addStudent" method="post" enctype="multipart/form-data">
			<s:file name="upload" label="上传的文件"></s:file>
			<s:submit value="上传"></s:submit>
   </s:form>
     </body>
</html>