<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.HashMap"%>
    <%
    	String session_id = (String)session.getAttribute("session_id");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="sub_tit" style="width:1100px;margin:0 auto ; padding:30px 0;">
	  <div class="tit">�ı�<span>/ PRODUCT REVIEW</span></div>
	  <div class="local">Ȩ > <span>��ǰ�ı�</span></div>
	</div>


	<table width="100%" class="board-type01" style="width:1100px;margin:0 auto ; padding:30px 0;">
							<colgroup>
								<col width="5%" />
								<col width="10%" />
								<col width="20%" />
								<col width="" />
								<col width="7%" />
								<col width="10%" />
								<col width="7%" />
							</colgroup>
							<thead>
							<tr>
								<th scope="col">��ȣ</th>
								<th scope="col">�̹���</th>
								<th scope="col">����</th>
								<th scope="col">����</th>
								<th scope="col">�ۼ���</th>
								<th scope="col">�ۼ���</th>
								<th scope="col">����</th>
							</tr>
							</thead>
							<tbody>
							<s:iterator value="list" status="stat">
								<tr>
									<td><s:property value="rv_number"/></td>
									<td><s:property value="rv_sav_image"/></td>
									<td class="subject"><a href="reviewView.action?rv_number=<s:property value="rv_number"/>&currentPage=<s:property value="currentPage"/>">&nbsp;&nbsp;&nbsp;<s:property value="rv_title" /></a></td>
									<td><s:property value="rv_content"/></td>
									<td><s:property value="rv_name"/></td>
									<td><s:property value="rv_date"/></td>
									<td><s:property value="rv_score"/></td>
								</tr>
							</s:iterator>
							
							</tbody>
						</table>
						
						
 
 
						

</td>
 
</tr>
</table>
</td>
</tr>
<tr>
  <td> 