<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <title>学生成绩管理系统</title>
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
  <body bgcolor="#FFFFF0">
   <table height="100%" width="100%" border="0">  
        <tbody>  
            <tr>  
               <td align="center" valign="middle">  
                   
  
  <table height="300" width="500" align="center"  cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#FFFFFF" bordercolorlight="#0066CC" bgcolor="yellow">
  <tr>
  <td>
  <s:form action="login" method="post" validate="true">
  	<s:textfield name="login.id" label="学号" size="20"/>
  	<s:password name="login.password" label="口令" size="21"/>
  	<s:radio label="身份" list="#{0:'管理员',1:'老师',2:'学生'}" name="login.iden"></s:radio>
  	<s:submit value="登录"/>
  </s:form>
  </td>
  </tr>
  </table>
  </td>
  </tr>
  </tbody>
  </table>
  </body> 
</html>
