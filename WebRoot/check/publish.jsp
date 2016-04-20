<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head><title>发布公告</title>
  <script language="javascript">
  function validate(){ 
  var id=document.getElementById("title");
  var name=document.getElementById("content");
  if(id.value=="")
   {alert("请输入主题！");
     return false;  
   }
   if(name.value=="")
   {alert("请输入内容!");
     return false; 
   }
   return true;
 }
 </script>
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
  </style></head>
  <body>
   <div align="right">你好！<s:property value="#session.user.id"/></div>
    <h1 align="center">发布公告</h1>
    <table width="60%" cellspacing="0" cellpadding="0" >
    <s:form action="publishAnm" method="post" validate="true" onsubmit="return validate();">
     <tr>
     <td><s:textfield name="announcement.title" id="title" label="主题" size="20"/></td> 
     <td><s:textfield name="announcement.content" id="content" label="内容" size="100"/></td> 
     <td><s:submit value="发布"/></td>
     </tr> 
     </s:form>
    </table>
  </body>
</html>


