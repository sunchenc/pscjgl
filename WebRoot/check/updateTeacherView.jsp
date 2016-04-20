<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>

<html>
  <head><title>修改班级</title>
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
  var name=document.getElementById("name");
   if(name.value=="")
   {alert("请输入名字!");
     return false; 
   }
   return true;
 }
 </script>
  </head>
  <body bgcolor="#FFFFF0" >
   <div align="right">你好！<s:property value="#session.user.id"/></div>
    <s:set name="teacher" value="#request.teacher1"></s:set>
    <s:form action="updateTeacher.action" method="post" validate="true" onsubmit="return validate();">
     <table>
      <tr>
      <td>教师编号</td><td><input type="text" name="teacher.teacherId" value="<s:property value="#teacher.teacherId"/>"readonly/></td>
      </tr>
      <tr>
       <td>名字</td><td><input type="text" id="name" name="teacher.teacherName"/></td>
      </tr>
    </table>
  
    <div align="center"> <input type="submit" value="修改"/> &nbsp; &nbsp; &nbsp;
      <input type="button" value="返回" onclick="javascript:history.back();"/>  </div> 
        </s:form>
  
  </body>
</html>
