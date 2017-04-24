<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</tr>
<tr>
<td height=100%>

<table height=100% cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
<tr>
<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>

<style>
#orderbox {border:5px solid #F3F3F3; height:100%;}
#orderbox div {float:left; width:150; height:100%; background-color:#F3F3F3; text-align:right;}
#orderbox table {float:left; margin:10px 0px 10px 20px; }
#orderbox table th {width:100; text-align:left; font-weight:normal; height:25;}
#orderbox table td {padding-left:10px}
.scroll {
scrollbar-face-color: #FFFFFF;
scrollbar-shadow-color: #AFAFAF;
scrollbar-highlight-color: #AFAFAF;
scrollbar-3dlight-color: #FFFFFF;
scrollbar-darkshadow-color: #FFFFFF;
scrollbar-track-color: #F7F7F7;
scrollbar-arrow-color: #838383;
}
#boxScroll{width:96%; margin:0 auto; height:130px; overflow: auto; BACKGROUND: #ffffff; COLOR: #585858;overflow-x:hidden;text-align:left; }
.n_mileage{
	cursor: pointer;
	vertical-align: middle;
}
.mileage_button{
	cursor: pointer;
	vertical-align: middle;
}
#save_button, #ncash_view{
	margin: 4px 0 0 24px;
}
#ncash_view{
	display: none;
}
.dark_gray { background:#B9B9B9 !important; }
</style>
<script id="delivery"></script>

<!-- 상단이미지 || 현재위치 -->
<div class="sub_tit">
<div class="tit">주문하기<span>/ ORDER</span></div>
<div class="local">홈 > <span>주문하기</span></div>
</div>


<div class="indiv"><!-- Start indiv -->

<div class="sub_tit2">
<span class="tit">주문상세<span>내역</span></span></div>
 <style media="screen">
table.orderitem-list {width:100%;}
table.orderitem-list thead tr th {border-top:2px solid #303030;border-bottom:1px solid #d6d6d6;background:#f0f0f0;height:25px;}
table.orderitem-list tbody tr td {border-bottom:1px solid #d6d6d6;padding:3px;}
table.orderitem-list tbody tr td table td {border:none;}
table.orderitem-list tfoot tr td {border-bottom:1px solid #efefef;background:#f7f7f7;height:25px;text-align:right;}
table.orderitem-list tfoot tr td table td {border:none;}
</style>

<table cellpadding=0 cellspacing=0 border=0 class="tlist2">
  <col width=60>
  <col>
  <col width=100  class="b_r">
  <col width=100  class="b_r">
  <col width=100  class="b_r2">
  <col width=100  class="b_r2">
<thead>
<tr>
	<th colspan=2 class="input_txt" width=200>상품정보</th>
	<th class="input_txt" style="display:none;">적립금</th>
	<th class="input_txt">판매가</th>
	<th class="input_txt">수량</th>
	<th class="input_txt">배송비</th>
	<th class="input_txt">상품합계금액</th>
</tr>
</thead>
<tbody>

	<!-- WIDERPLANET CART SCRIPT START 2017.1.9 -->
<span style="display: none;" name="wp_detection" tag="i">28</span>
<script type='text/javascript'>var wp_page_type = 'Cart';</script>
<!-- // WIDERPLANET CART SCRIPT END 2017.1.9 -->
<tr>
	<input type="hidden" name="strprice[]" value="">
	<input type="hidden" name="adultpro[]" value="0">
	<td height=60 align=center>
	<a href="" class="oi_img"><img src='../images/1481460887917s0.jpg' width=56 /></a> 
	</td>
	<td>
	<div>하루슈퍼푸드 2BOX(28팩)</div>
	<div style="margin:5px 0 5px 0;overflow:hidden;height:1px;background:url(/shop/data/skin/standard_C/img/common/line2.gif) repeat-x top left;"></div>
	</td>
	<td align=center style="display:none;">0원</td>
	<td align=right style="padding-right:10">23,900원</td>
	<td align=center>
		1개
	</td>
	<td align=center rowspan="1">
		<div id="el-default-delivery">
		기본배송
		</div>
	</td>

	<td align=right style="padding-right:10">23,900원</td>
</tr>
</tbody>

<tfoot id="orderitem_total">
<tr>
	<td colspan=10>

	<table style="display:block;float:right;">
	<tr>
		<td align=right width=80 nowrap style="padding-top:5px; padding-bottom:5px;">상품합계금액</td>
		<td align=right style="font-weight:bold;padding-left:25px; padding-top:5px; padding-bottom:5px;"><span id="el-orderitem-total-price">23,900</span>원&nbsp;</td>
	</tr>
	</table>

	</td>
</tr>
</tfoot>
</table>



<form id=form name=frmOrder action="/shop/order/settle.php" method=post onsubmit="return chkForm2(this)">
<input type=hidden name=ordno value="1492400558889">
<input type=hidden name=item_apply_coupon[]>

<div id=apply_coupon></div>



<!-- 01 주문자정보 -->
<div class="sub_tit2">
<span class="tit">주문자<span>정보</span></span></div>
<table width=100% class="order_list"  cellpadding=0 cellspacing=0>
	<col width=100><col>
	<tr>
		<th>주문하시는분</th>
		<td><input type=text name=nameOrder value="신희진" style="font-weight:bold" readonly style='border:0' required msgR="주문하시는분의 이름을 적어주세요"></td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			경기도 가평군 청평면 청평리 306 청평 경남아너스빌 경남아너스빌 103동 902호
<div style="padding-top:5px;font:12px dotum;color:#999;">경기도 가평군 청평면 골안길 7-28 (청평 경남아너스빌) 경남아너스빌 103동 902호</div>		</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>
		<input type=text name=phoneOrder[] value="" size=3 maxlength=3 option=regNum required label="주문자 전화번호"> -
		<input type=text name=phoneOrder[] value="" size=4 maxlength=4 option=regNum required label="주문자 전화번호"> -
		<input type=text name=phoneOrder[] value="" size=4 maxlength=4 option=regNum required label="주문자 전화번호">
		</td>
	</tr>
	<tr>
		<th>핸드폰번호</th>
		<td>
		<input type=text name=mobileOrder[] value="010" size=3 maxlength=3 option=regNum required label="주문자 핸드폰번호"> -
		<input type=text name=mobileOrder[] value="4158" size=4 maxlength=4 option=regNum required label="주문자 핸드폰번호"> -
		<input type=text name=mobileOrder[] value="2290" size=4 maxlength=4 option=regNum required label="주문자 핸드폰번호">
		</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type=text name=email value="ktlovegh@naver.com" required option=regEmail></td>
	</tr>
	</table>

<!-- 02 배송정보 -->
<div class="sub_tit2">
<span class="tit">배송<span>정보</span></span></div>
<table width=100% class="order_list"  cellpadding=0 cellspacing=0>
	<col width=100><col>
	
	<tr>
		<th>받으실분</th>
		<td><input type=text name=nameReceiver value="신희진" required></td>
	</tr>
	<tr>
		<th>받으실곳</th>
		<td>
		<input type=text name="zonecode" id="zonecode" size="5" class="line" readonly value="12451" readonlyCheck />
		( <input type=text name=zipcode[] id="zipcode0" size=3 class=line readonly value="477" required readonlyCheck> -
		<input type=text name=zipcode[] id="zipcode1" size=3 class=line readonly value="815" required readonlyCheck> )
		<a href="javascript:popup('../proc/popup_address.php',500,432);" id="addressSearch" style="display:none;"><img src="/shop/data/skin/standard_C/img/common/btn_zipcode.gif" align=absmiddle></a>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type=text name=address id="address" class=lineBig readonly value="경기도 가평군 청평면 청평리 306 청평 경남아너스빌" required></td>
	</tr>
	<tr>
		<td></td>
		<td>
		<input type=text name=address_sub id="address_sub" class=lineBig value="경남아너스빌 103동 902호" onkeyup="SameAddressSub(this)" oninput="SameAddressSub(this)" label="세부주소" readonlyCheck>
		<input type="hidden" name="road_address" id="road_address" style="width:100%" value="경기도 가평군 청평면 골안길 7-28 (청평 경남아너스빌)" class="line">
		<div style="padding:5px 5px 0 1px;font:12px dotum;color:#999;" id="div_road_address">경기도 가평군 청평면 골안길 7-28 (청평 경남아너스빌)</div>
		<div style="padding:5px 0 0 1px;font:12px dotum;color:#999;" id="div_road_address_sub">경남아너스빌 103동 902호</div>
		</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>
		<input type=text name=phoneReceiver[] value="" size=3 maxlength=3 option=regNum required label="수령자 전화번호" readonlyCheck> -
		<input type=text name=phoneReceiver[] value="" size=4 maxlength=4 option=regNum required label="수령자 전화번호" readonlyCheck> -
		<input type=text name=phoneReceiver[] value="" size=4 maxlength=4 option=regNum required label="수령자 전화번호" readonlyCheck>
		</td>
	</tr>
	<tr>
		<th>핸드폰번호</th>
		<td>
		<input type=text name=mobileReceiver[] value="010" size=3 maxlength=3 option=regNum required label="수령자 핸드폰번호" readonlyCheck> -
		<input type=text name=mobileReceiver[] value="4158" size=4 maxlength=4 option=regNum required label="수령자 핸드폰번호" readonlyCheck> -
		<input type=text name=mobileReceiver[] value="2290" size=4 maxlength=4 option=regNum required label="수령자 핸드폰번호" readonlyCheck>
		</td>
	</tr>
	<tr>
		<th>남기실 말씀</th>
		<td><input type=text name=memo style="width:100%"></td>
	</tr>
	<tr id="delivery_check" style="display:none;">
		<td>&nbsp;</td>
		<td>
			<input type="checkbox" name="delivery_add" id="delivery_add" value="y" onclick="deliveryAddCheck('delivery_add', this);" /><label for="delivery_add">배송지 목록에 추가</label>
			<input type="checkbox" name="delivery_default" id="delivery_default" value="y" onclick="deliveryAddCheck('delivery_default', this);" /><label for="delivery_default">기본 배송지로 선택</label>
		</td>
	</tr>
	<tr><td colspan=2>&nbsp;</td></tr>
	<tr id="paper_delivery_menu">
		<th>배송선택</th>
		<td class="noline">

		<div style='float:left'><input type="radio" name="deliPoli" value="0" checked onclick="getDelivery()" onblur="chk_emoney(document.frmOrder.emoney)"> 기본배송</div>
		</td>
	</tr>
	</table>

<!-- 03 결제금액 -->
<div class="sub_tit2">
<span class="tit">결제<span>금액</span></span></div>
<table width=100% class="order_list"  cellpadding=0 cellspacing=0>
	<col width=100><col>
    	<tr>
		<th>상품합계금액</th>
		<td><p id="paper_goodsprice" style="width:146px;text-align:right;font-weight:bold;float:left;margin:0">23,900</p> 원</td>
	</tr>

	<tr style="display:none;">
		<th valign=top style="padding-top:4px">적립금 적용</th>
		<td>

		<table cellpadding=0 cellspacing=0>
		<div style="display:none;">
		<tr>
			<td width=60 align=right>적립금 :</td>
			<td style="padding-left:3px">
			<input type=text name=emoney id="emoney" size=12 style="text-align:right" value=0 onblur="chk_emoney(this);" onkeyup="calcu_settle();" onkeydown="if (event.keyCode == 13) {return false;}"  > 원
			(보유적립금 : 0원)
			</td>
		</tr>
		</div>
		<tr>
			<td colspan=2 class="small red">
			<input type=hidden name=emoney_max value="0">
			</td>
		</tr>
		</table>

		</td>
	</tr>


	<tr>
		<th>총 결제금액</th>
		<td><span id=paper_settlement style="width:146px;text-align:right;font:bold 14px tahoma; color:FF6C68;">26,900</span> 원</td>
	</tr>
	</table>
<!-- 구매안전표시 start --><table  width=100% style='border:1px solid #DEDEDE' cellpadding=0 cellspacing=0>
						<tr><td style='padding-left:25px;padding-top:10px;' height=70 valign=middle>
							<div style='height:20px;'>* 고객님은 안전거래를 위해 현금 등으로 결제시 저희 쇼핑몰에서 가입한 <span class='red'><b>LG데이콤의 구매안전(에스크로)</b></span></div>
							<div style='height:20px;padding-left:10px;'><span class='red'><b>서비스</b></span>를 이용하실 수 있습니다.</div>
						</td></tr>
						</table><div style='font-size:0;height:5px'></div><!-- 구매안전표시 end -->
<!-- 04 결제수단 -->


	<input type=hidden name=escrow value="N">
<div class="sub_tit2">
<span class="tit">결제<span>수단</span></span></div>
<table width=100% class="order_list"  cellpadding=0 cellspacing=0>
	<col width=100><col>

	<tr>
		<th>일반결제</th>
		<td class=noline>
		<input type=radio name=settlekind value="c" onclick="input_escrow(this,'N')"> 무통장입금
		</td>
	</tr>



	<tr>
		<th></th>
		<td class="small red"><div id="coupon_typinfo" style="display:none">무통장입금에서만 사용가능한 쿠폰을 선택하였습니다. <br>다른 결제 수단을 선택하시려면 쿠폰을 제거 하여 주십시오.</div></td>
	</tr>
	</table>




<div style="padding:20px" align=center class="noline">
<input type="image" src="../images/btn_payment.jpg">
<img src="../images/btn_cancel.jpg" onclick="history.back()" style="cursor:pointer">
</div>

</form>

</div><!-- End indiv -->
<div id=dynamic></div>

</td>
 
<td width=0 id=pos_scroll valign=top> 
  
  <!-- 스크롤 배너 -->
  
  <div id=scroll style="position:absolute; margin:70px 10px 10px 30px;width:76px; display:none">

  
  </div>
  <!-- 스크롤 배너 활성화 --> 
  <script>scrollBanner();</script> 
</td>
</tr>
</table>
</td>
</tr>
<tr>
