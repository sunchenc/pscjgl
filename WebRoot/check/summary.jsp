<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
  <head><title>汇总成绩</title>
 
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
   }
      th{
    border-bottom-width:thin;
    border-bottom-style:solid;
    border-bottom-color:#CF3;
   }
   table{
     margin:0 auto;padding:0;
   }
   </style>
       <script language="javascript">
  function validate(){ 
  var id=document.getElementById("cishu");
  var name=document.getElementById("juanmian");
  if(id.value=="")
   {alert("请输入次数！");
     return false;  
   }
   if(name.value=="")
   {alert("请输入卷面成绩!");
     return false; 
   }
   return true;
 }
  </script>
   </head>
  <body>
     <div align="right">你好！<s:property value="#session.user.id"/></div>
    <table border="1">
     <s:form action="summaryOfGrade" method="post" validate="true" onsubmit="return validate();">
          <s:hidden name="studentId" value="%{#parameters.studentId}"/>  
     <tr>
        <th>平时成绩次数</th><th>卷面成绩</th>
      </tr>
     <tr>
     <td><input type="text" name="cishu" id="cishu"/></td>
    <!--  <td><s:textfield name="cishu" id="cishu" /></td> 
     <td><s:textfield name="juanmian" id="juanmian"/></td> -->
     <td><input type="text" name="juanmian" id="juanmian"/></td>
     <td><s:submit value="整合"/></td>
     </tr>
     </s:form>
    </table>
  </body>
</html>
