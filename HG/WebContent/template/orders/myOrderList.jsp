<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="sub_tit" style="width:1100px;margin:0 auto ; padding:30px 0;">
	  <div class="tit">나의 주문 목록들<span>/ MY ORDER LIST</span></div>
	  <div class="local">홈 > <span>MYPAGE> 주문목록 </span></div>
	</div>


	<table width="100%" class="board-type01" style="width:1100px;margin:0 auto ; padding:30px 0;">
							<colgroup>
								<col width="5%" />
								<col width="10%" />
								<col width="20%" />
								<col width="10%" />
								<col width="7%" />
							</colgroup>
							<thead>
							<tr>
								<th scope="col">상품번호</th>
								<!-- <th scope="col">이미지</th> -->
								<th scope="col">상품이름</th>
								<th scope="col">bottle</th>
								<th scope="col">주문일</th>
							</tr>
							</thead>
							<tbody>
							<s:iterator value="orderList" status="status">
								<tr>
									<td>${o_number} </td>
									<%-- <td><s:property value="rv_sav_image"/></td> --%>
									<%-- <td class="subject"><a href="reviewView.action?rv_number=<s:property value="rv_number"/>&currentPage=<s:property value="currentPage"/>">&nbsp;&nbsp;&nbsp;<s:property value="rv_title" /></a></td> --%>
									<td><s:property value="o_name"/></td>
									<td><s:property value="o_g_bottle"/></td>
									<td><s:property value="o_date"/></td>
								</tr>
							</s:iterator>
							
							</tbody>
						</table>
						
						
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