<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
</tr>
<tr>
<td height=100%>

<table height=100% cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
<tr>
<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>


<!-- 상단이미지 || 현재위치 -->
<div class="sub_tit">
<div class="tit">장바구니<span>/ CART</span></div>
<div class="local">홈 > <span>장바구니</span></div>
</div>


<div class="indiv"><!-- Start indiv -->

<form name=frmCart method=post>
<input type=hidden name=mode value=modItem>
<br>
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
  <col width=60>
  <col>
  <col width=100  class="b_r">
  <col width=100  class="b_r">
  <col width=100  class="b_r2">
  <col width=100  class="b_r2">
<thead>
<tr>
	<th class="input_txt">번호</th>
	<th class="input_txt">상품명</th>
	<th class="input_txt">판매가</th>
	<th class="input_txt">수량</th>
	<th class="input_txt">상품합계금액</th>
</tr>
</thead>
<tbody>
	<tr>
		<td>1</td>
		<td>상품명입니다.</td>
		<td>23,000원</td>
		<td>
			<select>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
				<option>9</option>
			</select>
		</td>
		<td>상품합계금액</td>
		
	</tr>
</tr>
	
</tbody>

<tfoot id="orderitem_total">
<tr>
	<td colspan=10>

	<table style="display:block;float:right;">
	<tr>
		<td align=right width=80 nowrap style="padding-top:5px; padding-bottom:5px;">상품합계금액</td>
		<td align=right style="font-weight:bold;padding-left:25px; padding-top:5px; padding-bottom:5px;"><span id="el-orderitem-total-price">0</span>원&nbsp;</td>
	</tr>
	</table>

	</td>
</tr>
</tfoot>
</table>
</form>

<div class="btnbox">
<div class="left">
<a href="javascript:history.back();"onFocus="blur()"><img src="images/btn_prev.jpg" border=0></a>
<a href="" onFocus="blur()"><img src="images/btn_shopping.jpg" border=0></a>
</div>
<div class="rig">
<a href=""><img src="images/btn_back2.gif" border=0></a>&nbsp;
<a href="" ><img src="images/btn_empty2.gif" border=0></a>&nbsp;
<a href=""><img src="images/btn_continue2.gif" border=0></a>
</div>
</div>

<div align="center"></div>
<div align="center"></div>

</div><!-- End indiv -->

</td>
 
<td width=0 id=pos_scroll valign=top> 
 
 
</td>
</tr>
</table>
</td>
</tr>
<tr>
