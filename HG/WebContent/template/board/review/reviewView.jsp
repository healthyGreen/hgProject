<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import = "java.util.HashMap" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
	function boardDelete() {
		if (confirm("�����Ͻðڽ��ϱ�?")) {
			window.location.href = 'reviewDeleteCheckPassForm.action?rv_number=<s:property value="resultClass.rv_number"/>';
		} else {
			alert("��ҵǾ����ϴ�");
		}
	}
</script>


<div class="sub_tit" style="width:1100px;margin:0 auto ; padding:30px 0;">
	  <div class="tit">�ı�<span>/ PRODUCT REVIEW</span></div>
	  <div class="local">Ȩ > <span>��ǰ�ı�</span></div>
	</div>

<form name="boardView" enctype="multipart/form-data" method="post">
	<table width="100%" class="board-type02"  style="width:1100px;margin:0 auto ; padding:30px 0;">
									<colgroup>
										<col width="" />
									</colgroup>
									<thead>
									<tr>
										<th scope="col">
											<div class="tit" style="float: left; "><s:property value="resultClass.rv_title" /></div>
											
												<div class="delete" style="float:right; cursor: pointer; padding-right: 20px;  " onclick="return boardDelete()"><span>X</span></div>
											
										</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>
											<div class="board-infor">
												<strong>�ۼ���</strong>
												<span><s:property value="resultClass.rv_name" /></span>
												<span >/</span>
												<strong>�ۼ���</strong>
												<span><s:property value="resultClass.rv_date"/></span>
												<span >/</span>
												<strong>����</strong>
												<span><s:property value="resultClass.rv_score"/></span>
											</div>
											
										</td>
									</tr>
									<tr>
										<td class="content">
											<s:property value="resultClass.rv_sav_image" />
											<s:property value="resultClass.rv_content"/>

										</td>
									</tr>
									</tbody>
								</table>
								<div style="width: 1100px; margin: 0 auto; ">
								
									<div class="wBtn clear" style="float: left; width: 120px;" onclick="javascript:window.location.href='reviewCheckPassForm.action?rv_number=<s:property value="resultClass.rv_number"/>&currentPage=<s:property value="currentPage"/>'"><span>�����ϱ�</span></div>
									<div class="wBtn clear" style="float: left; width: 120px; margin-left: 10px; " onclick="javascript:window.location.href='reviewReplyForm.action?rv_number=<s:property value="resultClass.rv_number" />&currentPage=<s:property value="currentPage" />'"><span>��۴ޱ�</span></div>
								
									<div class="wBtn clear" style="float: right; width: 120px;" onclick="javascript:window.location.href='reviewList.action?rv_number=<s:property value="resultClass.rv_number"/>&currentPage=<s:property value="currentPage"/>'"><span>��ϰ���</span></div>
								</div>
</td>
</tr>
<tr>
  <td> 