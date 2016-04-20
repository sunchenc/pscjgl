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
  var name=document.getElementById("cla");
   var num=document.getElementById("num");
   if(name.value=="")
   {alert("请输入班级名!");
     return false; 
   }
     if(num.value=="")
   {alert("请输入人数!");
     return false; 
   }
   return true;
 }
 </script>
  </head>
  <body bgcolor="#FFFFF0" >
   <div align="right">你好！<s:property value="#session.user.id"/></div>
    <s:set name="tbClass" value="#request.tbclass"></s:set>
    <s:form action="updateClass.action" method="post" validate="true" onsubmit="return validate();">
     <table>
      <tr>
      <td>班级id</td><td><input type="text" name="tbClass.id" value="<s:property value="#tbClass.id"/>"readonly/></td>
      </tr>
      <tr>
       <td>班级</td><td><input type="text" id="cla" name="tbClass.className"/></td>
      </tr>
      <tr> <td>人数</td><td><input type="text" id="num" name="tbClass.number"/></td>
      </tr>
      <tr>
     <td>老师</td>
     <td><select name="tbClass.teacher.teacherId">
           <s:iterator value="#request.teachers" id="teacher">
             <option value="<s:property value="#teacher.teacherId"/>">
                 <s:property value="#teacher.teacherName"/>
             </option>
           </s:iterator>
          </select>
      </td>
     </tr>
    </table>
    <div align="center"> <input type="submit" value="修改"/> &nbsp; &nbsp; &nbsp;
      <input type="button" value="返回" onclick="javascript:history.back();"/>
   </div> 
    </s:form>
    <script type="text/javascript">
       document.getElementById("tbClass.teacher.teacherId").value=<s:property value="#tbClass.teacher.teacherId"/>
    </script>

  </body>
</html>
