<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<style>
	input{width: 120px; height: 40px; background: #f0f0f0; border: 1px solid #000; cursor: pointer; }
	p{text-align: center;  }
	p span{color: blue; font-weight: 600; }
</style>
<body>
<p>
	당신의 비밀번호가 <span>1111</span> 로 초기화 되었습니다.<br>
	마이페이지에서 비밀번호를 변경 해 주세요.<br>
</p>
<table width=100% cellpadding=0 cellspacing=0 border=0>
<tr>
<td id=avoidDbl align=center height=100>
<div style="width:100%" class=noline>
    <input type="button" onClick="location.href='logInForm.action'" value="로그인하기">
    <input type="button" onClick="location.href='main.action'" value="메인으로">
</div>
</td>
</tr>
</table>
</body>
</html>