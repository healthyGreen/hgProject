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
	����� ��й�ȣ�� <span>1111</span> �� �ʱ�ȭ �Ǿ����ϴ�.<br>
	�������������� ��й�ȣ�� ���� �� �ּ���.<br>
</p>
<table width=100% cellpadding=0 cellspacing=0 border=0>
<tr>
<td id=avoidDbl align=center height=100>
<div style="width:100%" class=noline>
    <input type="button" onClick="location.href='logInForm.action'" value="�α����ϱ�">
    <input type="button" onClick="location.href='main.action'" value="��������">
</div>
</td>
</tr>
</table>
</body>
</html>