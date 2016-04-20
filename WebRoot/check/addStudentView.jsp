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
  var id=document.getElementById("id");
  var name=document.getElementById("name");
  if(id.value=="")
   {alert("请输入编号！");
     return false;  
   }
   if(name.value=="")
   {alert("请输入名字!");
     return false; 
   }
   return true;
 }
 function check(){
  var upload=document.getElementById("upload");
   if(upload.value==""){
    alert("请选择excel表");
    return false;
  }
  var allow=".xls";
  var fileType=upload.value.substr(upload.value.lastIndexOf(".")).toLowerCase(); 
  if(allow.indexOf(fileType)==-1)//判断文件类型
  {
     alert("请上传后缀为.xls的文件");
     return false;
  }
  return true;
 }
  </script>
  </head>
  <body>

   <table>
   <s:form action="addOneStudent.action" method="post" validate="true" onsubmit="return validate();">
     <tr  align="center">
       <th>单个导入</th>
     </tr>
      <tr>
       <td>编号</td><td><input type="text" id="id" name="tbStudent.studentId"/></td>
      </tr>
      <tr> <td>姓名</td><td><input type="text" id="name" name="tbStudent.studentName"/></td>
      </tr>
      <tr>
     <td>班级</td>
     <td><select name="tbStudent.tbclass.id">
           <s:iterator value="#request.classes" id="tbclass">
             <option value="<s:property value="#tbclass.id"/>">
                 <s:property value="#tbclass.className"/>
             </option>
           </s:iterator>
          </select>
      </td>
     </tr>
     <tr>
     <td> <input type="submit" value="添加"/> </td>
    <td> <input type="button" value="返回" onclick="javascript:history.back();"/></td>
     </tr>
     </s:form>
    </table>
   
    
    <script type="text/javascript">
       document.getElementById("tbStudent.tbclass.id").value=<s:property value="#tbStudent.tbclass.id"/>
    </script>
    
  <table>
     <tr><th>批量添加</th></tr>
  <tr> <s:form action="addStudent.action" method="post" enctype="multipart/form-data" onsubmit="return check();">
			<s:file name="upload" id="upload" label="上传的文件"></s:file>
			<s:submit value="上传"></s:submit>
   </s:form>
   </tr>
   </table>
  </body>
</html>