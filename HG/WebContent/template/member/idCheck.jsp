<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>���̵� �ߺ� Ȯ��</title>
<script language="javascript">
   function windowclose() {
      opener.document.join.M_id.value = "${m_id}";
      /* opener.document.joinForm.checkConfirmId.value="true"; */
      self.close();
   }
   function check() {
	      if(document.idChk.M_id.value == ""){
	         alert("���̵� �Է��� �ּ���");
	         document.idChk.M_id.focus();
	         return false;
	      }else{
	         var m_id = document.idChk.M_id.value;
	         var url = "idCheckAction?m_id="+m_id;   
	         open(url, "IdConfirm", "toolbar=no,location=no,status=no,menubar=no,"+
	               "scrollbars=no,resizable=no,width=400,height=200");
	      }
	   }
</script>
</head>
<body>

   <s:if test="chkId eq 1">

      <form name=idChk onsubmit="return check();">

         <table align="center" width="265" border="0" cellspacing="0"
            cellpadding="0">

            <tr height="25">
               <td bgcolor="red" align="left" colspan="1" width="10"></td>
               <td align="left" colspan="3"><font color="red"><strong>&nbsp;&nbsp;ID�ߺ�</strong></font></td>
            </tr>

         </table>

         <br>

         <table align="center" width="265" border="0" cellspacing="0"
            cellpadding="0">

            <tr bgcolor="red">
               <td height="1"></td>
            </tr>

            <tr height="10">
               <td></td>
            </tr>

            <tr>
               <td><font color="red">"${m_id }" �� �̹� ������� ���̵��Դϴ�. �ٸ�
                     ���̵� ������ �ּ���</font></td>
            </tr>

            <tr height="10">
               <td></td>
            </tr>

            <tr bgcolor="red">
               <td height="1"></td>
            </tr>

         </table>

         <br> <br>

         <table align="center" width="265" border="0" cellspacing="0"
            cellpadding="0">

            <tr height="25">
               <td bgcolor="1E90FF" align="left" colspan="1" width="10"></td>
               <td align="left" colspan="3"><font color="black"><strong>&nbsp;&nbsp;ID �ߺ� Ȯ��</strong></font></td>
            </tr>

         </table>

         <br>

         <table align="center" width="265" border="0" cellspacing="0"
            cellpadding="0">

            <tr bgcolor="1E90FF">
               <td height="1"></td>
            </tr>

            <tr height="10">
               <td></td>
            </tr>

            <tr align="center">
               <td><input type=text maxlength=20 name="M_id" /> <input type=submit value="ID �ߺ�Ȯ��" class="topb" /></td>
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
               <td align="center"><input type="button" class="login1" value="�ݱ�" onclick="javascript:window.close();" /></td>
            </tr>

         </table>

      </form>

   </s:if>

   <s:else>

      <table align="center" width="265" border="0" cellspacing="0"
         cellpadding="0">

         <tr height="25">
            <td bgcolor="1E90FF" align="left" colspan="1" width="10"></td>
            <td align="left" colspan="3"><font color="black"><strong>&nbsp;&nbsp;��밡��</strong></font></td>
         </tr>

      </table>

      <br>

      <table align="center" width="265" border="0" cellspacing="0"
         cellpadding="0">

         <tr bgcolor="1E90FF">
            <td height="1"></td>
         </tr>

         <tr height="10">
            <td></td>
         </tr>

         <tr>
            <td>�Է��Ͻ� "${m_id }" �� ����� �� �ִ� ���̵��Դϴ�.</td>
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
            <td align="center"><input type="button" class="login1"
               value="�ݱ�" onclick="javascript:window.close();" /></td>
         </tr>
      </table>
   </s:else>
</body>
</html>