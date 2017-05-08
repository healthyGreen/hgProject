<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>댓글 답변</title>
</head>
<body>
<div class="con111">
                           <div id="contents-wrapper">
                          <table width="100%" cellpadding="0" cellspacing="0" border="0" class="gv_bbs">
                           <colgroup>
                           <col width="50">
                           <col>
                           <col width="110">
                           <col width="85">
                           </colgroup>
                           
                            <form action="replyWrite.action" method="post">
         <table>
            <tr>
            <td width="170">
            이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름<s:textfield name="name" theme="simple" value="" cssStyle="width:100px" maxlength="20" /><br>
            비밀번호 <s:textfield name="password" theme="simple" value="" cssStyle="width:100px" maxlength="20" />
         </td>
         <s:hidden name="originno" value="%{resultClass.rp_number}"/>
         <s:hidden name="no" value="%{resultClass.no}"/>
         <s:hidden name="currentPage" value="%{currentPage}"/>
         <s:hidden name="g_number" value="%{goodsResult.g_number}"/>
         <s:hidden name="checked" value="1"/>
         <td align="left">
         <s:textarea name="content" theme="simple" value="" cols="60" rows="3"/>
         </td>
         </tr>
         <tr>
            <td colspan="2" align="right">
            <!-- <input name="submit" type="submit" value="작성완료" class="inputb"> -->
            <input type="button" value="답변완료" onclick="javascript:location.href='replyComment.action?g_number=${g_number}&currentPage=${currentPage}&rp_number=${rp_number}'"/>
            </td>
            </tr>
             
            </table>
           </form>
</body>

</html>