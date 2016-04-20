<%@ page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>

<html>
  <head><title>检查作业</title>
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
   <%  String path=request.getParameter("path");%>
    <table border="1">
    <s:form action="updateWork" method="post" validate="true">
      <tr bgcolor="silver">
        <th>下载</th><th>成绩</th><th>detail</th><th>留言</th>
      </tr>
     <tr>
     <s:hidden name="id" value="%{#parameters.id}"></s:hidden>
     
   <!--       <td><a href="down.jsp?path='%{#parameters.path}'">下载</a></td> -->
    <td><a href="down.jsp?path=<%=path%>">下载</a></td>
     <td><input type="text" name="grade"/></td>
     <td><input type="text" name="gradeDetail"/></td>
     <td><input type="text" name="liuyan" size="60" value="<s:property value="%{#parameters.liuyan}" escape='false'/>"readonly/></td>
   <!--   <td><s:textfield name="grade" id="grade" size="5"/></td> 
     <td><s:textfield name="gradeDetail" id="gradeDetail" size="5"/></td> --> 
     <td><s:submit value="提交"/></td>
     </tr>
   
     </s:form>
    </table>
  </body>
</html>
