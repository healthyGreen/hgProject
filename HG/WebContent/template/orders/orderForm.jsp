<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
       <%@ taglib prefix="s" uri="/struts-tags" %>
       <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
       <script type="text/javascript">
       function sample6_execDaumPostcode() {
           new daum.Postcode({
               oncomplete: function(data) {
                   // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                   // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                   // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                   var fullAddr = ''; // 최종 주소 변수
                   var extraAddr = ''; // 조합형 주소 변수

                   // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                   if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                       fullAddr = data.roadAddress;

                   } else { // 사용자가 지번 주소를 선택했을 경우(J)
                       fullAddr = data.jibunAddress;
                   }

                   // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                   if(data.userSelectedType === 'R'){
                       //법정동명이 있을 경우 추가한다.
                       if(data.bname !== ''){
                           extraAddr += data.bname;
                       }
                       // 건물명이 있을 경우 추가한다.
                       if(data.buildingName !== ''){
                           extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                       }
                       // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                       fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                   }

                   // 우편번호와 주소 정보를 해당 필드에 넣는다.
                   document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                   document.getElementById('sample6_address').value = fullAddr;

                   // 커서를 상세주소 필드로 이동한다.
                   document.getElementById('sample6_address2').focus();
               }
           }).open();
       }
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</tr>
<tr>
<td height=100%>
<form action="orderForPro.action">
<s:hidden name="m_id" value="%{member.m_id}"/>
<s:hidden name="ttotalPrice" value="%{ttotalPrice}"/>
<s:hidden name="orderType" value="%{orderType}"/>
<s:if test="%{orderType=='goods'}">
<s:hidden name="g_number" value="%{orderInfo.get(0)}"/>
<s:hidden name="g_name" value="%{orderInfo.get(1)}"/>
<s:hidden name="amount" value="%{orderInfo.get(2)}"/>
<s:hidden name="bottle" value="%{orderInfo.get(3)}"/>
<s:hidden name="price" value="%{orderInfo.get(4)}"/>
<s:hidden name="totalPrice" value="%{totalPrice}"/>
</s:if>
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
   <th class="input_txt">배송비(50,000원 이상시 3000원)</th>
   <th class="input_txt">상품합계금액</th>
</tr>
</thead>
<tbody>
<s:if test="%{orderType=='goods'}">

   <!-- WIDERPLANET CART SCRIPT START 2017.1.9 --><%-- 
<span style="display: none;" name="wp_detection" tag="i">28</span> --%>
<%-- <script type='text/javascript'>var wp_page_type = 'Cart';</script> --%>
<!-- // WIDERPLANET CART SCRIPT END 2017.1.9 -->
<tr>
   <!-- <input type="hidden" name="strprice[]" value="">
   <input type="hidden" name="adultpro[]" value="0"> -->
   <td height=60 align=center>
   <a href="" class="oi_img"><img src='../images/1481460887917s0.jpg' width=56 /></a> 
   </td>
   <td>
   <div><s:property value="%{orderInfo.get(1) }"/></div>
   <div style="margin:5px 0 5px 0;overflow:hidden;height:1px;background:url(/shop/data/skin/standard_C/img/common/line2.gif) repeat-x top left;"></div>
   </td>
   <%-- <s:iterator value="orderInfo" status="sta"> --%>
    <td align=center style="display:none;">0원</td> 
   <td align=right style="padding-right:10"><s:property value="%{orderInfo.get(4) }"/>원</td>
   <td align=center>
      <s:property value="%{orderInfo.get(2) }"/>
   </td>
   <td align=center rowspan="1">
      <div id="el-default-delivery">
      <s:property value="%{baesongPrice }"/>원
      </div>
   </td>
   <%-- </s:iterator> --%>
   <td align=right style="padding-right:10"><s:property value="%{ttotalPrice }"/>원</td>
</tr>

</s:if>

   <s:if test="%{orderType=='basket'}">
<s:iterator id="basketList" status="stat">
<tr>
   
   <td height=60 align=center>
  	goods Name
   </td>
   <td>
   <div><a href=""><s:property value="b_g_name "/></a></div>
   
   </td>
  
   <td align=right style="padding-right:10"><s:property value="b_g_price "/>원</td>
   <td align=center>
     <s:property value="b_g_amount  "/>
   </td>
   <td align=center rowspan="1">
      <div id="el-default-delivery">
      ${baesongPrice }원
      </div>
   </td>
   
   <td align=right style="padding-right:10">${ttotalPrice }원</td>
</tr>
</s:iterator>



</s:if>
</tbody>

<tfoot id="orderitem_total">
<tr>
   <td colspan=10>

   <table style="display:block;float:right;">
   <tr>
      <td align=right width=80 nowrap style="padding-top:5px; padding-bottom:5px;">상품합계금액</td>
      <td align=right style="font-weight:bold;padding-left:25px; padding-top:5px; padding-bottom:5px;"><span id="el-orderitem-total-price"><s:property value="%{ttotalPrice }"/></span>원&nbsp;</td>
   </tr>
   </table>

   </td>
</tr>
</tfoot>
</table>



<!-- <form id=form name=frmOrder action="/shop/order/settle.php" method=post onsubmit="return chkForm2(this)"> -->
<!-- <input type=hidden name=ordno value="1492400558889">
<input type=hidden name=item_apply_coupon[]> -->

<div id=apply_coupon></div>



<!-- 01 주문자정보 -->
<div class="sub_tit2">
<span class="tit">주문자<span>정보</span></span></div>
<table width=100% class="order_list"  cellpadding=0 cellspacing=0>
   <col width=100><col>
   <tr>
      <th>주문하시는분</th>
      <td><s:property value="%{member.m_name}"/></td>
   </tr>
   <tr>
      <th>주소</th>
      <td>
         <s:property value="%{member.m_zipcode}"/>&nbsp;<s:property value="%{member.m_addr1}"/>&nbsp;<s:property value="%{member.m_addr2}"/>
<div style="padding-top:5px;font:12px dotum;color:#999;"><s:property value="%{member.m_zipcode}"/>&nbsp;<s:property value="%{member.m_addr1}"/>&nbsp;<s:property value="%{member.m_addr2}"/></div></td>
   </tr>
   <tr>
      <th>전화번호</th>
      <td>
      <s:property value="%{member.m_phone}"/>
      </td>
   </tr>
   
   <tr>
      <th>이메일</th>
      <td><s:property value="%{member.m_email}"/></td>
   </tr>
   </table>

<!-- 02 배송정보 -->
<div class="sub_tit2">
<span class="tit">배송<span>정보</span></span></div>
<table width=100% class="order_list" cellpadding=0 cellspacing=0>
   <col width=100><col>
   
   <tr>
      <th>받으실분</th>
      <td><input type="text" name="o_name"></td>
   </tr>
   <tr>
      <th>받으실곳</th>
      <td>
      <input type="text" name="o_zipcode" id="sample6_postcode" placeholder="우편번호">
      <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
      <input type="text" name="o_addr1" id="sample6_address" placeholder="주소">
      <input type="text" name="o_addr2" size=30  id="sample6_address2" placeholder="상세주소">
      </td>
   </tr>
   <!-- <tr>
      <td></td>
      <td><input type=text name=address id="address" class=lineBig readonly value="경기도 가평군 청평면 청평리 306 청평 경남아너스빌" required></td>
   </tr> -->
   <tr>
      <td></td>
      <td>
      <!-- <input type=text name=address_sub id="address_sub" class=lineBig value="경남아너스빌 103동 902호" onkeyup="SameAddressSub(this)" oninput="SameAddressSub(this)" label="세부주소" readonlyCheck> -->
      <!-- <input type="hidden" name="road_address" id="road_address" style="width:100%" value="경기도 가평군 청평면 골안길 7-28 (청평 경남아너스빌)" class="line"> -->
<!--       <div style="padding:5px 5px 0 1px;font:12px dotum;color:#999;" id="div_road_address">경기도 가평군 청평면 골안길 7-28 (청평 경남아너스빌)</div>
      <div style="padding:5px 0 0 1px;font:12px dotum;color:#999;" id="div_road_address_sub">경남아너스빌 103동 902호</div> -->
      </td>
   </tr>
   <tr>
      <th>전화번호</th>
      <td>
      <input type=text name=o_rphone size=3 maxlength=3 option=regNum required label="수령자 전화번호" readonlyCheck>
      </td>
   </tr>
   <tr>
      <th>남기실 말씀</th>
      <td><input type=text name=o_comment style="width:100%"></td>
   </tr>
<!--    <tr id="delivery_check" style="display:none;">
      <td>&nbsp;</td>
      <td>
         <input type="checkbox" name="delivery_add" id="delivery_add" value="y" onclick="deliveryAddCheck('delivery_add', this);" /><label for="delivery_add">배송지 목록에 추가</label>
         <input type="checkbox" name="delivery_default" id="delivery_default" value="y" onclick="deliveryAddCheck('delivery_default', this);" /><label for="delivery_default">기본 배송지로 선택</label>
      </td>
   </tr> -->
   <tr><td colspan=2>&nbsp;</td></tr>
   <tr id="paper_delivery_menu">
      <th>결제수단</th>
      <td class="noline">
<div style='float:left'><input type="radio" name="o_pay" value="noTongJang" checked="checked"> 무통장 입금</div>
      <div style='float:left'><input type="radio" name="o_pay" value="card"> 카드 결제</div> 
      <!-- <div style='float:left'><input type="radio" name="o_pay" value="noTongJang" checked onclick="getDelivery()" onblur="chk_emoney(document.frmOrder.emoney)"> 무통장 입금</div>
      <div style='float:left'><input type="radio" name="o_pay" value="card" checked onclick="getDelivery()" onblur="chk_emoney(document.frmOrder.emoney)"> 카드 결제</div> -->
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
      <td><p id="paper_goodsprice" style="width:146px;text-align:right;font-weight:bold;float:left;margin:0">${totalPrice }</p> 원</td>
   </tr>

   <tr style="display:none;">
      <th valign=top style="padding-top:4px">적립금 적용</th>
      <td>

      <table cellpadding=0 cellspacing=0>
      <!-- <div style="display:none;">
      <tr>
         <td width=60 align=right>적립금 :</td>
         <td style="padding-left:3px">
         <input type=text name=emoney id="emoney" size=12 style="text-align:right" value=0 onblur="chk_emoney(this);" onkeyup="calcu_settle();" onkeydown="if (event.keyCode == 13) {return false;}"  > 원
         (보유적립금 : 0원)
         </td>
      </tr>
      </div> -->
      <!-- <tr>
         <td colspan=2 class="small red">
         <input type=hidden name=emoney_max value="0">
         </td>
      </tr> -->
      </table>

      </td>
   </tr>


   <tr>
      <th>총 결제금액</th>
      <td><span id=paper_settlement style="width:146px;text-align:right;font:bold 14px tahoma; color:FF6C68;">${ttotalPrice }</span> 원</td>
   </tr>
   </table>
<!-- 구매안전표시 start --><table  width=100% style='border:1px solid #DEDEDE' cellpadding=0 cellspacing=0>
                  <tr><td style='padding-left:25px;padding-top:10px;' height=70 valign=middle>
                     <div style='height:20px;'>* 고객님은 안전거래를 위해 현금 등으로 결제시 저희 쇼핑몰에서 가입한 <span class='red'><b>LG데이콤의 구매안전(에스크로)</b></span></div>
                     <div style='height:20px;padding-left:10px;'><span class='red'><b>서비스</b></span>를 이용하실 수 있습니다.</div>
                  </td></tr>
                  </table><div style='font-size:0;height:5px'></div><!-- 구매안전표시 end -->
<!-- 04 결제수단 -->


   <%-- <input type=hidden name=escrow value="N">
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
   </table> --%>




<div style="padding:20px" align=center class="noline">
<input type="image" src="../images/btn_payment.jpg">
<img src="../images/btn_cancel.jpg" onclick="history.back()" style="cursor:pointer">
</div>

<!-- </form> -->

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
</form>
</td>
</tr>
<tr>