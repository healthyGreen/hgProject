<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="sub_tit" style="width:1100px;margin:0 auto ; padding:30px 0;">
	  <div class="tit">후기<span>/ PRODUCT REVIEW</span></div>
	  <div class="local">홈 > <span>상품후기</span></div>
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
								<th scope="col">번호</th>
								<th scope="col">이미지</th>
								<th scope="col">제목</th>
								<th scope="col">내용</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일</th>
								<th scope="col">평점</th>
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
						<form name="searchBox"  method="post">
							<div style="width: 1100px; margin: 0 auto; ">
								<select class="border" name="forSearch">
									<option value="writer">작성자</option>
									<option value="content">내용</option>
									<option value="title">제목</option>
									
								</select>
								
								<s:textfield name="search" theme="simple" value="" cssStyle="width:120px" maxlength="20" />
								<input class="click" type="submit" value="검색" name="submit">
							</div>
						</form>
						<c:if test="${session.session_admin == 1 }"> 
							<div class="wBtn" ><span onclick="location.href='reviewWriteForm.action?currentPage=<s:property value="currentPage"/>'">작성하기</span></div>
						</c:if>
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