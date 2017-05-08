<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	.wBtn input {border: none;     cursor: pointer;    float: right;    width: 120px;    height: 40px;    background: #484647;    text-align: center;    color: #fff;    display: block;    font-size: 13px;       box-sizing: border-box; padding-top: 0px !important; }
</style>
</head>
<body>
	<s:if test="reply">
		<form action="reviewWritePro.action" enctype="multipart/form-data" method="post" >
		<s:hidden name="rv_pass" value="%{resultClass.rv_pass}" />
		<s:hidden name="rv_name" value="%{resultClass.rv_name}" />
		<s:hidden name="rv_number" value="%{resultClass.rv_number}" />
		<s:hidden name="currentPage" value="%{currentPage}" />
		<s:hidden name="rv_m_id" value="%{resultClass.rv_m_id}" />
		<s:hidden name="rv_score" value="%{resultClass.rv_score}" />
		<s:hidden name="rv_ref" value="%{resultClass.rv_ref}" /> 
		<s:hidden name="rv_ref_level" value="%{resultClass.rv_ref_level}" />
		<s:hidden name="rv_ref_step" value="%{resultClass.rv_ref_step}" />  
		<table width="100%" class="board-type03" style="width:1100px;margin:0 auto ;">
					<colgroup>
						<col width="" />
						<col width="" />
					</colgroup>
					<tbody>
						
						<tr class="first">
							<th scope="row">
								제목
							</th>
							<td>
								<div><input type="text" class="input1 write-box" name="rv_title"  value="<s:property value="resultClass.rv_title"/>"/></div>
							</td>
						</tr>
						
						
						<tr>
							<th scope="row" class="vertical-t">
								답글내용
							</th>
							<td>
								<div class="input3">
									<textarea id="" cols="30" rows="10" width="100%; " name="rv_content"><s:property value="resultClass.rv_content" /></textarea>
								</div>
							</td>
						</tr>
						
					</tbody>
				</table>
				<div class="wBtn clear" ><input type="submit" value="답변완료" /></div>
			</form>
	
	</s:if>
</body>
</html>