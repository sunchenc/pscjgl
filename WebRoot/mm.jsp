<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<script type="text/javascript">
  function over(id){
    document.getElementById(id).style.background="skyblue";
  }
   function out(id){
    document.getElementById(id).style.background="white";
  }

  </script>
<style type="text/css">
 .navigationStyle{
   filter:wave(add=false,freq=1;lightstrength=50,phase=50);
  }
  td{
  text-align:center;
  }
</style>
</head>
 <body>
   <table width="100%" height="27" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#FFFFFF" bordercolorlight="#0066CC" bgcolor="yellow" class="navigationStyle" >
     <tr>
      <td height="30" id="td1" onmouseover="over('td1')" onmouseout="out('td1')">
         <a href="login.jsp" target="right">登录</a>
      </td>
     </tr>
     <tr>
      <td height="30" id="td2" onmouseover="over('td2')" onmouseout="out('td2')">
        <a href="check/modifypassword.jsp" target="right">修改密码</a>
      </td>
     </tr>
          <tr>
      <td height="30" id="td3" onmouseover="over('td3')" onmouseout="out('td3')">
       <ul>
         <li>  <td height="30" id="td3" onmouseover="over('td3')" onmouseout="out('td3')">老师</td></li>
         <ul>
           <li>
         <a href="check/addstudent.jsp" target="right">添加学生</a>
         </li>
         <li>
          <a href="showStudent.action" target="right">查看学生</a>
         </li>
         <li><a href="checkwork.action" target="right">检查作业</a>
         </li>
         </ul>
         <li>管理员</li>
         <li>学生</li>
       </ul>
       
      </td>
     </tr>
           <tr>
      <td height="30" id="td4" onmouseover="over('td4')" onmouseout="out('td4')">
       
      </td>
     </tr>
          <tr>
      <td height="30" id="td5" onmouseover="over('td5')" onmouseout="out('td5')">
        <a href="check/addteacher.jsp" target="right">添加老师</a>
      </td>
     </tr>
          <tr>
      <td height="30" id="td6" onmouseover="over('td6')" onmouseout="out('td6')">
        <a href="studentSeeWork.action" target="right">查看作业</a>
      </td>
     </tr>
          <tr>
      <td height="30" id="td7" onmouseover="over('td7')" onmouseout="out('td7')">
        <a href="check/uploadwork.jsp" target="right">上传作业</a>
      </td>
     </tr>
           <tr>
      <td height="30" id="td8" onmouseover="over('td8')" onmouseout="out('td8')">
        
      </td>
     </tr>
           <tr>
      <td height="30" id="td9" onmouseover="over('td9')" onmouseout="out('td9')">
        <a href="studentTotalGrade.action" target="right">学生总成绩</a>
      </td>
     </tr>
            <tr>
      <td height="30" id="td10" onmouseover="over('td10')" onmouseout="out('td10')">
        <a href="check/publish.jsp" target="right">发布公告</a>
      </td>
     </tr>
            <tr>
      <td height="30" id="td11" onmouseover="over('td11')" onmouseout="out('td11')">
        <a href="seeAnm.action" target="right">查看公告</a>
      </td>
     </tr>
              <tr>
      <td height="30" id="td12" onmouseover="over('td12')" onmouseout="out('td12')">
        <a href="showStudent.action" target="right">汇总总成绩</a>
      </td>
     </tr>
     
   </table>
 </body>
</html>