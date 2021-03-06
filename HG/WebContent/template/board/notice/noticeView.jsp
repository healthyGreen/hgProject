<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import = "java.util.HashMap" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
	function boardDelete() {
		if (confirm("삭제하시겠습니까?")) {
			window.location.href = 'noticeDelete.action?n_number=<s:property value="resultClass.n_number"/>';
		} else {
			alert("취소되었습니다");
		}
	}
</script>


<div class="sub_tit" style="width:1100px;margin:0 auto ; padding:30px 0;">
	  <div class="tit">공지사항<span>/ NOTICE</span></div>
	  <div class="local">홈 > <span>공지사항</span></div>
	</div>

<form name="boardView" enctype="multipart/form-data" method="post">
							<s:hidden name="n_title" value="%{resultClass.n_title}" />
							<s:hidden name="n_name" value="%{resultClass.n_name}" />
							<s:hidden name="n_number" value="%{resultClass.n_number}" />
							<s:hidden name="n_content" value="%{resultClass.n_content}" />  
							<table width="100%" class="board-type02"  style="width:1100px;margin:0 auto ; padding:30px 0;">
									<colgroup>
										<col width="" />
									</colgroup>
									<thead>
									<tr>
										<th scope="col">
											<div class="tit" style="float:left; "><s:property value="resultClass.n_title" /></div>
											<c:if test="${session.session_admin == 1 }"> 
												<div class="delete" style="float:right; cursor: pointer; padding-right: 20px;  " onclick="return boardDelete()"><span>X</span></div>
											</c:if>
										</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>
											<div class="board-infor">
												<strong>작성자</strong>
												<span><s:property value="resultClass.n_name" /></span>
												<span >/</span>
												<strong>작성일</strong>
												<span><s:property value="resultClass.n_date"/></span>
												
											</div>
											
										</td>
									</tr>
									<tr>
										<td class="content">
											<s:property value="resultClass.n_content"/>

										</td>
									</tr>
									</tbody>
								</table>
</form>							<div style="width: 1100px; margin: 0 auto; ">
								<c:if test="${session.session_admin == 1 }"> 
									<div class="wBtn clear" style="float: left; width: 120px;" onclick="javascript:window.location.href='noticeModifyForm.action?n_number=<s:property value="resultClass.n_number"/>&currentPage=<s:property value="currentPage"/>'"><span>수정하기</span></div>
								</c:if>
									<div class="wBtn clear" style="float: right; width: 120px;" onclick="javascript:window.location.href='noticeList.action?n_number=<s:property value="resultClass.n_number"/>&currentPage=<s:property value="currentPage"/>'"><span>목록가기</span></div>
								</div>
</td>
</tr>
<tr>
  <td> 