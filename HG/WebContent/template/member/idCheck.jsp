<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>���̵� �ߺ� Ȯ��</title>
<script language="javascript">
function windowclose(){
	opener.document.joinForm.M_id.value="${M_id}";
	/* opener.document.joinForm.checkConfirmId.value="true"; */
	window.close();
}
function check(){
	if(idChk.M_id.value==""){
		alert("���̵� �Է��� �ּ���");
		idChk.M_id.focus();
		return false;
	}
}
</script>
</head>
<body>

<s:if test="chkId==1">

	<form name=idChk onsubmit="return check();">
	
	<table align="center" width="265" border="0" cellspacing="0" cellpadding="0">
	
		<tr height="25">
			<td bgcolor="red" align="left" colspan="1" width="10"></td>
			<td align="left" colspan="3"><font color="red"><strong>&nbsp;&nbsp;ID �ߺ�</strong></font></td>
		</tr>
	
	</table>

	<br>

	<table align="center" width="265" border="0" cellspacing="0" cellpadding="0">
	
		<tr bgcolor="red">
			<td height="1"></td>
		</tr>
		
		<tr height="10">
			<td></td>
		</tr>
		
		<tr>
			<td><font color="red">"${M_id }" �� �̹� ������� ���̵��Դϴ�. �ٸ� ���̵� ������ �ּ���</font></td>
		</tr>
		
		<tr height="10">
			<td></td>
		</tr>
		
		<tr bgcolor="red">
			<td height="1"></td>
		</tr>
	
	</table>
	
	<br>
	<br>

	<table align="center" width="265" border="0" cellspacing="0" cellpadding="0">

		<tr height="25">
			<td bgcolor="1E90FF" align="left" colspan="1" width="10"></td>
			<td align="left" colspan="3"><font color="black"><strong>&nbsp;&nbsp;ID �ߺ� Ȯ��</strong></font></td>
		</tr>

	</table>

	<br>

	<table align="center" width="265" border="0" cellspacing="0" cellpadding="0">
	
		<tr bgcolor="1E90FF">
			<td height="1"></td>
		</tr>
	
		<tr height="10">
			<td></td>
		</tr>
	
		<tr align="center">
			<td>
				<input type=text maxlength=20 name="M_id"/>
				<input type=submit value="ID �ߺ�Ȯ��" class="topb"/>
			</td>
		<tr>
		
		<tr height="10">
			<td></td>
		</tr>
	
		<tr bgcolor="1E90FF">
			<td height="1"></td>
		</tr>
	
		<tr height="20">
			<td></td>
		</tr>
		
		<tr>
			<td align="center"><input type="button" class="login1" value="�ݱ�" onclick="javascript:window.close();"/></td>
		</tr>
		
	</table>

	</form>
	
</s:if>

<s:else>

	<table align="center" width="265" border="0" cellspacing="0" cellpadding="0">

		<tr height="25">
			<td bgcolor="1E90FF" align="left" colspan="1" width="10"></td>
			<td align="left" colspan="3"><font color="black"><strong>&nbsp;&nbsp;��� ����</strong></font></td>
		</tr>

	</table>

	<br>

	<table align="center" width="265" border="0" cellspacing="0" cellpadding="0">
	
		<tr bgcolor="1E90FF">
			<td height="1"></td>
		</tr>
	
		<tr height="10">
			<td></td>
		</tr>
		
		<tr>
			<td>�Է��Ͻ� "${M_id }" �� ����� �� �ִ� ���̵��Դϴ�.</td>
		</tr>
		
		<tr height="10">
			<td></td>
		</tr>
		
		<tr bgcolor="1E90FF">
			<td height="1"></td>
		</tr>
		
		<tr height="20">
			<td></td>
		</tr>
		
		<tr>
			<td align="center"><input type="button" class="login1" value="�ݱ�" onclick="javascript:window.close();"/></td>
		</tr>
	</table>
</s:else>
</body>
</html>