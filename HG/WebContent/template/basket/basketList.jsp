<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
    <%
    	String session_id = (String)session.getAttribute("session_id");
    %>
<%-- <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %> --%>
<script type="text/javascript">
	function alldelBas(basketlist) {
		if(confirm("삭제하시겠습니까?")){
			window.location.href='basketDeleteAll.action?b_m_id=${b_m_id}';
		}else return;
	}
</script>

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

<form name="basketlist">
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
	<s:iterator value="basketList" status="sta">
	<s:hidden name="b_number" value="b_number"/>
	<tr>

		<td>${b_g_number}</td>
		<td>${b_g_name} </td>
		<td>${b_g_price }원</td>
		<td>${b_g_amount } &nbsp;
			<select name='b_g_amount' id='aaa<s:property value="%{#sta.index}" />'>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
			</select>&nbsp;<input type="button" value="변경" onclick="javascript:location.href='basketModify.action?b_g_number=${b_g_number}&b_number=${b_number}&b_g_price=${b_g_price}&b_m_id=${b_m_id}&b_g_amount='+document.getElementById('aaa<s:property value="%{#sta.index}" />').value">
			&nbsp;<input type="button" value="삭제" onclick="javascript:location.href='basketDelete.action?b_number=${b_number}'"/>
		</td>
		<td>${b_allPrice }원</td>
	</tr><br>
		</s:iterator>
</tr>
	
</tbody>

<tfoot id="orderitem_total">
<tr>
	<td colspan=10>

	<table style="display:block;float:right;">
	<tr>
		<td align=right width=80 nowrap style="padding-top:5px; padding-bottom:5px;">상품합계금액</td>
		<td align=right style="font-weight:bold;padding-left:25px; padding-top:5px; padding-bottom:5px;"><span id="el-orderitem-total-price">${allTotalPrice }</span>원&nbsp;</td>
	</tr>
	</table>

	</td>
</tr>
</tfoot>
</table>


<div class="btnbox">
<div class="left">
<!-- <a href="javascript:history.back();"onFocus="blur()"><img src="images/btn_prev.jpg" border=0></a> -->
<a href="goodsView.action?g_number=${b_g_number}"><img src="images/btn_shopping.jpg" border=0></a>
</div>

<div class="rig">
<!-- <a href=""><img src="images/btn_back2.gif" border=0></a>&nbsp; -->
<a onclick="return alldelBas(this.form)" ><img src="images/btn_empty2.gif" border=0></a>&nbsp;
<!-- <a href=""><img src="images/btn_continue2.gif" border=0></a> -->
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
</form>
</td>
</tr>
<tr>
