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
	p{text-align: center;  font-size: 20px; }
	p span{color: blue; font-weight: 600; }
	img{width: 100px;}
</style>
<body>
<div style="text-align: center; padding-top: 100px; "><img src="images/error.png" /></div>
<p>정보가 맞지 않습니다. 다시 입력해 주세요.</p>

<table width=100% cellpadding=0 cellspacing=0 border=0>
<tr>
<td id=avoidDbl align=center height=100>
<div style="width:100%" class=noline>
    <input type="button" onClick="history.go(-1)" value="이전으로">
</div>
</td>
</tr>
</table>
</body>
</html>