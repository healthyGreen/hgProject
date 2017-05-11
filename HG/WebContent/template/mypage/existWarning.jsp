<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<style>
   input{width: 120px; height: 40px; background: #f0f0f0; border: 1px solid #000; cursor: pointer; }
   p{text-align: center; font-size: 20px; margin-top: 100px; }
   p span{color: blue; font-weight: 600; }
</style>
<body>
<p>정말 탈퇴하시겠습니까??</p>
<table width=100% cellpadding=0 cellspacing=0 border=0>
<tr>
<td id=avoidDbl align=center height=100>
<div style="width:100%" class=noline>
    <input type="button" style="background:#484647;cursor: pointer; border: none; color: #Fff;     padding: 11px 25px;font-size: 15px;" onclick="location.href='existPro.action'" value="탈퇴하기">
    <input type="button" onclick="location.href='main.action'" value="메인으로">
</div>
</td>
</tr>
</table>
</body>
</html>