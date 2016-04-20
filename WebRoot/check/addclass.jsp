<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>

<html>
  <head><title>添加班级</title>
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
  <body bgcolor="#FFFFF0" >
   <div align="right">你好！<s:property value="#session.user.id"/></div>
     <s:form action="addClass.action" method="post" validate="true">
     <table>
      <tr>
       <td>班级</td><td><input type="text" name="tbClass.className"/></td>
      </tr>
      <tr> <td>人数</td><td><input type="text" name="tbClass.number"/></td>
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
    <div align="center"> <input type="submit" value="添加"/> &nbsp; &nbsp; &nbsp;
      <input type="button" value="返回" onclick="javascript:history.back();"/>
   </div> 
    </s:form>
    <script type="text/javascript">
       document.getElementById("tbClass.teacher.teacherId").value=<s:property value="#tbClass.teacher.teacherId"/>
    </script>

  </body>
</html>
