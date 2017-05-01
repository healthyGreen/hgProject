<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
     <%
     	String session_id = (String)session.getAttribute("session_id");
     	/* String b_g_bottle = "병";
     	int b_g_amount = 3; */
     %>
     <script type="text/javascript">
	function cartAdde(goodsForm) {
		var b_g_amount = document.goodsForm.b_g_amount.value;
		window.location.href='basketInput.action?b_m_id=<%= session_id%>&b_g_number=${g_number}&b_g_name=${goodsResult.g_name}&b_g_price=${goodsResult.g_price}&b_g_amount='+b_g_amount;
	}
	function buyIt(goodsForm) {
		var b_g_amount = document.goodsForm.b_g_amount.value;
		var b_g_bottle = document.goodsForm.b_g_bottle.value;
		window.location.href='orderForm.action?m_id=<%=session_id%>&g_number=${g_number}&g_name=${goodsResult.g_name}&price=${goodsResult.g_price}&amount='+b_g_amount+'&bottle='+b_g_bottle+'&orderType=goods';
	} 
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<tr>
		<td height=100%>
		<form name="goodsForm">
		 <%-- <input type="hidden" name="b_m_id" value="<%= session_id%>">
		 <s:hidden name="b_g_number" value="%{g_number}"/>
		 <s:hidden name="b_g_name" value="%{goodsResult.g_name}"/>
		 <s:hidden name="b_g_price" value="%{goodsResult.g_price}"/> --%>
		 
			<table height=100% cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
 	<tr><td> <%-- <a href="basketInput.action?b_g_number=<s:property value="g_number"/>&b_m_id=<%=session_id%>
			&b_g_name=<s:property value="goodsResult.g_name"/>
			&b_g_price=<s:property value="goodsResult.g_price"/>">장바구니</a> --%>
			
			</td></tr>
				<tr>
					<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>
						
						<div class="gv_tit">PRODUCT<span> DETAIL</span></div>
						<div class="indiv">
							<div class="goods_viewbox">
								<div class="goods_view">
									<div class="view_img">
										<div class="img_big">
											<span onclick="popup('goods_popup_large.php?goodsno=19',800,600)" class="">
												<img src='../images/1480927871296m0.jpg' id=objImg />
											</span>
										</div>
									</div>
									<div id=goods_spec class="view_info"> 
										<div class="info_name"> <span class="tit">그린메디신(warm green) 1L 기준</span> <span class="txt">약보다 그린 주스</span> </div>
										<table border=0 cellpadding=0 cellspacing=0 class=top>
											<tr class="info_price">
												<th>판매가격 </th>
												<td>
												<b><span id=price><s:property value="goodsResult.g_price"/></span>원</b>
												</td>
											</tr>
										</table>
										<table border=0 cellpadding=0 cellspacing=0>
											<tr>
												<th>구성 </th>
												<td>콜라비/오이/파인애플/사과/파슬리</td>
											</tr>
											<tr>
												<th>용량 </th>
												<td>1,615g</td>
											</tr>
											<tr>
												<th>배송  </th>
												<td>배송비3,000원</td>
											</tr>
											<tr>
												<th>배송 1 </th>
												<td>*3만원 이상 구매시 무료 배송</td>
											</tr>
											<tr>
												<th>배송 2 </th>
												<td>*주스키트는 다른 제품(하루슈퍼푸드, 하루과일칩, 리프레시워터)과 '별도로 배송'됩니다.</td>
											</tr>
											<tr>
												<th class=count >구매수량 </th>
												<td class=count >
													<div style="float:left;">
														<select name="b_g_amount">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
			</select>
													</div>
												</td>
											</tr>
											<tr>
												<td class=count>bottle</td>
												<td class=count >
													<div style="float:left;">
														<select name="b_g_bottle">
				<option value="small">350 mL</option>
				<option value="medium">500 mL<option>
				<option value="big">750 mL</option>
			</select>
											</tr>

										</table>
									  <div id="el-multi-option-display" class="info_option">
										<table border="0" cellpadding="0" cellspacing="0">
										  <col width="">
										  <col width="50">
										  <col width="150">
										</table>
										<%-- <div class="info_total">총 상품금액 :  <span class="feb" id="el-multi-option-total-price">19,800 원</span></div> --%>
									  </div>
 
									  <div class="view_btn"> 					
										<a href="javascript:act('../order/order')"><img src="../images/buy_now.png"></a>
										<a href="javascript:cartAdd(this.form)"><img src="../images/cart.png"></a> 
										<input type="button" value="장바구니" onclick="return cartAdde(this.form)">
										<style>.view_btn a{margin-left:20px} </style>
									  </div><br><input type="button" value="상품구매" onclick="return buyIt(this.form)">
								   
								  </div>
								</div>
							  </div>

							  
  
						<div class="view_con"> 
							<a name="viewtab1"></a> 
							<div class="prdc_tab">
								<div>
									<ul class="cfix">
											<li class="selected"><a  href="#viewtab1">상품상세정보</a></li>
											<li><a href="#viewtab2">배송안내</a></li>
											<li><a href="#viewtab3">상품문의</a></li>
									</ul>
								</div>
							</div> 
							<!-- 상세 설명s -->
							<div class="view_detail" id=contents>
							  <table width=100%>
								<tr>
								  <td> 
									<div style="text-align: center;"><br></div>
									<div style="text-align: center;"><br></div>
									<div style="text-align: center;">
										<iframe width="880" height="445" src="https://www.youtube.com/embed/-E31jpLv1Es" frameborder="0" allowfullscreen=""></iframe>
									</div>
									<div style="text-align: center;"><br></div>
									<div style="text-align: center;"><img src="../images/dcafc160271722dd.gif"><br></div>
									<div style="text-align: center;"><br></div>
									<div style="text-align: center;"><img src="../images/9e5b43b9086cea67.jpg"><br></div>
									<div style="text-align: center;"><br></div>
									<div style="text-align: center;"><br></div>
									<div style="text-align: center;"><br></div>
									<div style="text-align: center;"><img src="../images/c1d520c053ed3b49.jpg"><br></div>
									<div style="text-align: center;"><br></div>
									<div style="text-align: center;"><br></div>
									<div style="text-align: center;"><br></div>
									<div style="text-align: center;"><br></div>
								  </td>
								</tr>
							  </table>
							</div>
							<!-- 상세 설명e --> 


							<a name="viewtab2"></a> 
							<div class="prdc_tab">
										<div>
											<ul class="cfix">
													<li><a  href="#viewtab1">상품상세정보</a></li>
													<li class="selected"><a href="#viewtab2">배송안내</a></li>
													<li><a href="#viewtab5">상품문의</a></li>
											</ul>
										</div>
							</div>
								<!-- 배송안내s -->
								  <div class="con111">
									<ul>
										<Font Size=2 color=#323130 line-height:-8px;>
										<img src="../images/delivery_page.jpg"><br>
											<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<배송비></b><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송료: 3,000원<br> 
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;무료 배송: 30,000원 이상 구매 시 무료 배송(*도서,산간,오지 일부지역은 배송비가 추가될 수 있습니다)<br>
									<br>
									<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<주문 기한 및 배송 방법></b><br>
										<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* 주스키트</b><br>
										  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- 택배사 : 로젠택배(1588-9988)<br>
										  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- 주문마감: 오후3시 (3시 이후 주문건은 익일주문으로 처리)<br>
										  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- 익일생산&배송-수령일은 수령일은 주문일로부터 평균 3일입니다.<br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- 미리 만들어 놓은게 아닌 주문과 동시에 재료를 주문하는 방식이기에 <b><u>받으셔야하는 날짜&#160;'3일'전에 주문부탁드립니다.</u></b>
										<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ex) 목요일주문(오후3시이전)-금요일제작&발송-토요일 혹은 화요일 수령<br>
										<br>
										<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* 리프레시워터/스낵(하루슈퍼푸드,하루과일칩)</b><br>
										  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- 택배사:대한통운(1588-1255)<br>
										  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- 주문마감은 오후1시.(1시이후 주문건은 익일주문으로 처리)<br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- 수령일은 주문일로부터 평균2일입니다.(지역에 따라 최장3일 걸릴 수 있습니다.) ex) 금요일주문(오후1시이전)-당일출고-토요일 혹은 월요일수령<br></Font>
										</ul>
								  </div>
								<!-- 배송안내e -->

								<a name="viewtab3"></a> 
								<div class="prdc_tab">
									<div>
										<ul class="cfix">
												<li><a  href="#viewtab1">상품상세정보</a></li>
												<li><a href="#viewtab2">배송안내</a></li>
												<li class="selected"><a href="#viewtab3">상품문의</a></li>
										</ul>
									</div>
								</div>
								<!-- 상품문의s -->
								  <div class="con111">
								   <div id="contents-wrapper">
								  <table width="100%" cellpadding="0" cellspacing="0" border="0" class="gv_bbs">
									<colgroup>
									<col width="50">
									<col>
									<col width="110">
									<col width="85">
									</colgroup>
									<tbody>
									<tr>
									  <th>번호</th>
									  <th>제목</th>
									  <th>작성자</th>
									  <th>작성일</th>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</tbody>
								</table>

								<div style="float:right;padding:10px 5px"> 
								<a href="/shop/goods/goods_qna.php?&amp;" target="_parent"><img src="/shop/data/skin/standard_C/dsm/img/goods/btn_list1.jpg"></a>
								<a href="javascript:;" onclick="popup_register( 'add_qna', '19' )"><img src="/shop/data/skin/standard_C/dsm/img/goods/btn_w1.jpg"></a>
								</div>
								<div style="clear:both;text-align:center;padding-bottom:15px;"></div>
								</div>
									  </div>
									<!-- 상품문의e--> 

						</td>
 

 
					</tr>
				</table>
				</form>
			</td>
		</tr>
<tr>
  <td> 