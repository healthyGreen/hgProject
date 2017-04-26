<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import = "java.util.HashMap" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="sub_tit" style="width:1100px;margin:0 auto ; padding:30px 0;">
	 <div class="tit">공지사항<span>/ NOTICE</span></div>
	  <div class="local">홈 > <span>공지사항</span></div>
	</div>


	<table width="100%" class="board-type01" style="width:1100px;margin:0 auto ; padding:30px 0;">
							<colgroup>
								<col width="5%" />
								<col width="" />
								<col width="7%" />
								<col width="10%" />
							</colgroup>
							<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일</th>
							</tr>
							</thead>
							<tbody>
							<s:iterator value="list" status="stat">
								<tr>
									<td><s:property value="n_number"/></td>
									<td class="subject"><a href="noticeView.action?n_number=<s:property value="n_number"/>&currentPage=<s:property value="currentPage"/>">&nbsp;&nbsp;&nbsp;<s:property value="n_title" /></a></td>
									<td><s:property value="n_name"/></td>
									<td><s:property value="n_date"/></td>
								</tr>
							</s:iterator>
							</tbody>
						</table>
						
							<div class="wBtn" ><span onclick="location.href='noticeForm.action?currentPage=<s:property value="currentPage"/>'">작성하기</span></div>
						
						<div class="pageing" >
							<s:property value="pagingHtml" escape="false"/>
						</div>
 
						

</td>
 
</tr>
</table>
</td>
</tr>
<tr>
  <td> 