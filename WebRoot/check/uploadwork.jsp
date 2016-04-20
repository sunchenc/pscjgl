<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head><title>上传作业</title>
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
  <script language="javascript">
  function validate(){ 
  var upload=document.getElementById("upload");
   if(upload.value=="")
   {alert("请选择作业！");
     return false;  
   }
   return true;
 }
  </script></head>
  <body>
   <div align="right">你好！<s:property value="#session.user.id"/></div>
     <s:form action="uploadWork" method="post" enctype="multipart/form-data" onsubmit="return validate();">
     <table>
		<tr><td>	<s:file name="upload" id="upload" label="上传的文件"></s:file></td></tr>
		<tr><td>	<s:select label="次数" list="#{1:'第一次',2:'第二次',3:'第三次',4:'第四次',5:'第五次',6:'第六次'}" listKey="key" listValue="value" name="cishu">
			</s:select> </td></tr>
		<tr><td>	<s:textfield name="liuyan" label="留言" size="50"/> </td></tr>
		<tr><td>	<s:submit value="上传"></s:submit> </td></tr>
	</table>
   </s:form>
  </body>
</html>
