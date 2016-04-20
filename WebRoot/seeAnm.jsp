<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>

<html>
  <head><title>查看公告</title>
   <style type="text/css">
   body{
    background-color:"#FFFFF0";
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
  <link href="css/style1.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
   <div align="right">你好！<s:property value="#session.user.id"/></div>
   <marquee direction="up" onMouseOver="this.scrollAmount='1'" onMouseOut="this.scrollAmount='4';this.direction='down'" onMouseUp="this.scrollAmount='1';this.direction='up'" scrollAmount="2" height="291">
    <table width="100%" cellspacing="0" cellpadding="0">
      <tr>
        <th>主题</th><th>内容</th><th>时间</th>
          <%
        Integer iden = (Integer)session.getAttribute("iden"); 
        if(iden==0){
       %>
        <th>删除</th>
           <%} %>
      </tr>
     <s:iterator value="#request.list" id="anm">
     <tr>
      
      <td><s:property value="#anm.title" /></td>
      <td><s:property value="#anm.content" /></td>
     <!-- <td><s:property value="#anm.time"/></td>  -->
      <td><s:date name="#anm.time" format="yyyy-MM-dd hh:mm:ss" /></td>
      <%
        if(iden==0){
       %>
      <td><a href="deleteAnm.action?anm.id=<s:property value="#anm.id"/>"); onClick="if(!confirm('确定删除吗？'))return false;else return true;">删除</a></td>
      <%} %>
     </tr>
   
     </s:iterator>

   </table>
   </marquee>
  </body>
</html>
