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

<!-- ����̹��� || ������ġ -->
<div class="sub_tit">
<div class="tit">�ֹ��ϱ�<span>/ ORDER</span></div>
<div class="local">Ȩ > <span>�ֹ��ϱ�</span></div>
</div>


<div class="indiv"><!-- Start indiv -->

<div class="sub_tit2">
<span class="tit">�ֹ���<span>����</span></span></div>
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
	<th colspan=2 class="input_txt" width=200>��ǰ����</th>
	<th class="input_txt" style="display:none;">������</th>
	<th class="input_txt">�ǸŰ�</th>
	<th class="input_txt">����</th>
	<th class="input_txt">��ۺ�</th>
	<th class="input_txt">��ǰ�հ�ݾ�</th>
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
	<div>�Ϸ罴��Ǫ�� 2BOX(28��)</div>
	<div style="margin:5px 0 5px 0;overflow:hidden;height:1px;background:url(/shop/data/skin/standard_C/img/common/line2.gif) repeat-x top left;"></div>
	</td>
	<td align=center style="display:none;">0��</td>
	<td align=right style="padding-right:10">23,900��</td>
	<td align=center>
		1��
	</td>
	<td align=center rowspan="1">
		<div id="el-default-delivery">
		�⺻���
		</div>
	</td>

	<td align=right style="padding-right:10">23,900��</td>
</tr>
</tbody>

<tfoot id="orderitem_total">
<tr>
	<td colspan=10>

	<table style="display:block;float:right;">
	<tr>
		<td align=right width=80 nowrap style="padding-top:5px; padding-bottom:5px;">��ǰ�հ�ݾ�</td>
		<td align=right style="font-weight:bold;padding-left:25px; padding-top:5px; padding-bottom:5px;"><span id="el-orderitem-total-price">23,900</span>��&nbsp;</td>
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



<!-- 01 �ֹ������� -->
<div class="sub_tit2">
<span class="tit">�ֹ���<span>����</span></span></div>
<table width=100% class="order_list"  cellpadding=0 cellspacing=0>
	<col width=100><col>
	<tr>
		<th>�ֹ��Ͻôº�</th>
		<td><input type=text name=nameOrder value="������" style="font-weight:bold" readonly style='border:0' required msgR="�ֹ��Ͻôº��� �̸��� �����ּ���"></td>
	</tr>
	<tr>
		<th>�ּ�</th>
		<td>
			��⵵ ���� û��� û�� 306 û�� �泲�Ƴʽ��� �泲�Ƴʽ��� 103�� 902ȣ
<div style="padding-top:5px;font:12px dotum;color:#999;">��⵵ ���� û��� ��ȱ� 7-28 (û�� �泲�Ƴʽ���) �泲�Ƴʽ��� 103�� 902ȣ</div>		</td>
	</tr>
	<tr>
		<th>��ȭ��ȣ</th>
		<td>
		<input type=text name=phoneOrder[] value="" size=3 maxlength=3 option=regNum required label="�ֹ��� ��ȭ��ȣ"> -
		<input type=text name=phoneOrder[] value="" size=4 maxlength=4 option=regNum required label="�ֹ��� ��ȭ��ȣ"> -
		<input type=text name=phoneOrder[] value="" size=4 maxlength=4 option=regNum required label="�ֹ��� ��ȭ��ȣ">
		</td>
	</tr>
	<tr>
		<th>�ڵ�����ȣ</th>
		<td>
		<input type=text name=mobileOrder[] value="010" size=3 maxlength=3 option=regNum required label="�ֹ��� �ڵ�����ȣ"> -
		<input type=text name=mobileOrder[] value="4158" size=4 maxlength=4 option=regNum required label="�ֹ��� �ڵ�����ȣ"> -
		<input type=text name=mobileOrder[] value="2290" size=4 maxlength=4 option=regNum required label="�ֹ��� �ڵ�����ȣ">
		</td>
	</tr>
	<tr>
		<th>�̸���</th>
		<td><input type=text name=email value="ktlovegh@naver.com" required option=regEmail></td>
	</tr>
	</table>

<!-- 02 ������� -->
<div class="sub_tit2">
<span class="tit">���<span>����</span></span></div>
<table width=100% class="order_list"  cellpadding=0 cellspacing=0>
	<col width=100><col>
	
	<tr>
		<th>�����Ǻ�</th>
		<td><input type=text name=nameReceiver value="������" required></td>
	</tr>
	<tr>
		<th>�����ǰ�</th>
		<td>
		<input type=text name="zonecode" id="zonecode" size="5" class="line" readonly value="12451" readonlyCheck />
		( <input type=text name=zipcode[] id="zipcode0" size=3 class=line readonly value="477" required readonlyCheck> -
		<input type=text name=zipcode[] id="zipcode1" size=3 class=line readonly value="815" required readonlyCheck> )
		<a href="javascript:popup('../proc/popup_address.php',500,432);" id="addressSearch" style="display:none;"><img src="/shop/data/skin/standard_C/img/common/btn_zipcode.gif" align=absmiddle></a>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type=text name=address id="address" class=lineBig readonly value="��⵵ ���� û��� û�� 306 û�� �泲�Ƴʽ���" required></td>
	</tr>
	<tr>
		<td></td>
		<td>
		<input type=text name=address_sub id="address_sub" class=lineBig value="�泲�Ƴʽ��� 103�� 902ȣ" onkeyup="SameAddressSub(this)" oninput="SameAddressSub(this)" label="�����ּ�" readonlyCheck>
		<input type="hidden" name="road_address" id="road_address" style="width:100%" value="��⵵ ���� û��� ��ȱ� 7-28 (û�� �泲�Ƴʽ���)" class="line">
		<div style="padding:5px 5px 0 1px;font:12px dotum;color:#999;" id="div_road_address">��⵵ ���� û��� ��ȱ� 7-28 (û�� �泲�Ƴʽ���)</div>
		<div style="padding:5px 0 0 1px;font:12px dotum;color:#999;" id="div_road_address_sub">�泲�Ƴʽ��� 103�� 902ȣ</div>
		</td>
	</tr>
	<tr>
		<th>��ȭ��ȣ</th>
		<td>
		<input type=text name=phoneReceiver[] value="" size=3 maxlength=3 option=regNum required label="������ ��ȭ��ȣ" readonlyCheck> -
		<input type=text name=phoneReceiver[] value="" size=4 maxlength=4 option=regNum required label="������ ��ȭ��ȣ" readonlyCheck> -
		<input type=text name=phoneReceiver[] value="" size=4 maxlength=4 option=regNum required label="������ ��ȭ��ȣ" readonlyCheck>
		</td>
	</tr>
	<tr>
		<th>�ڵ�����ȣ</th>
		<td>
		<input type=text name=mobileReceiver[] value="010" size=3 maxlength=3 option=regNum required label="������ �ڵ�����ȣ" readonlyCheck> -
		<input type=text name=mobileReceiver[] value="4158" size=4 maxlength=4 option=regNum required label="������ �ڵ�����ȣ" readonlyCheck> -
		<input type=text name=mobileReceiver[] value="2290" size=4 maxlength=4 option=regNum required label="������ �ڵ�����ȣ" readonlyCheck>
		</td>
	</tr>
	<tr>
		<th>����� ����</th>
		<td><input type=text name=memo style="width:100%"></td>
	</tr>
	<tr id="delivery_check" style="display:none;">
		<td>&nbsp;</td>
		<td>
			<input type="checkbox" name="delivery_add" id="delivery_add" value="y" onclick="deliveryAddCheck('delivery_add', this);" /><label for="delivery_add">����� ��Ͽ� �߰�</label>
			<input type="checkbox" name="delivery_default" id="delivery_default" value="y" onclick="deliveryAddCheck('delivery_default', this);" /><label for="delivery_default">�⺻ ������� ����</label>
		</td>
	</tr>
	<tr><td colspan=2>&nbsp;</td></tr>
	<tr id="paper_delivery_menu">
		<th>��ۼ���</th>
		<td class="noline">

		<div style='float:left'><input type="radio" name="deliPoli" value="0" checked onclick="getDelivery()" onblur="chk_emoney(document.frmOrder.emoney)"> �⺻���</div>
		</td>
	</tr>
	</table>

<!-- 03 �����ݾ� -->
<div class="sub_tit2">
<span class="tit">����<span>�ݾ�</span></span></div>
<table width=100% class="order_list"  cellpadding=0 cellspacing=0>
	<col width=100><col>
    	<tr>
		<th>��ǰ�հ�ݾ�</th>
		<td><p id="paper_goodsprice" style="width:146px;text-align:right;font-weight:bold;float:left;margin:0">23,900</p> ��</td>
	</tr>

	<tr style="display:none;">
		<th valign=top style="padding-top:4px">������ ����</th>
		<td>

		<table cellpadding=0 cellspacing=0>
		<div style="display:none;">
		<tr>
			<td width=60 align=right>������ :</td>
			<td style="padding-left:3px">
			<input type=text name=emoney id="emoney" size=12 style="text-align:right" value=0 onblur="chk_emoney(this);" onkeyup="calcu_settle();" onkeydown="if (event.keyCode == 13) {return false;}"  > ��
			(���������� : 0��)
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
		<th>�� �����ݾ�</th>
		<td><span id=paper_settlement style="width:146px;text-align:right;font:bold 14px tahoma; color:FF6C68;">26,900</span> ��</td>
	</tr>
	</table>
<!-- ���ž���ǥ�� start --><table  width=100% style='border:1px solid #DEDEDE' cellpadding=0 cellspacing=0>
						<tr><td style='padding-left:25px;padding-top:10px;' height=70 valign=middle>
							<div style='height:20px;'>* ������ �����ŷ��� ���� ���� ������ ������ ���� ���θ����� ������ <span class='red'><b>LG�������� ���ž���(����ũ��)</b></span></div>
							<div style='height:20px;padding-left:10px;'><span class='red'><b>����</b></span>�� �̿��Ͻ� �� �ֽ��ϴ�.</div>
						</td></tr>
						</table><div style='font-size:0;height:5px'></div><!-- ���ž���ǥ�� end -->
<!-- 04 �������� -->


	<input type=hidden name=escrow value="N">
<div class="sub_tit2">
<span class="tit">����<span>����</span></span></div>
<table width=100% class="order_list"  cellpadding=0 cellspacing=0>
	<col width=100><col>

	<tr>
		<th>�Ϲݰ���</th>
		<td class=noline>
		<input type=radio name=settlekind value="c" onclick="input_escrow(this,'N')"> �������Ա�
		</td>
	</tr>



	<tr>
		<th></th>
		<td class="small red"><div id="coupon_typinfo" style="display:none">�������Աݿ����� ��밡���� ������ �����Ͽ����ϴ�. <br>�ٸ� ���� ������ �����Ͻ÷��� ������ ���� �Ͽ� �ֽʽÿ�.</div></td>
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
  
  <!-- ��ũ�� ��� -->
  
  <div id=scroll style="position:absolute; margin:70px 10px 10px 30px;width:76px; display:none">

  
  </div>
  <!-- ��ũ�� ��� Ȱ��ȭ --> 
  <script>scrollBanner();</script> 
</td>
</tr>
</table>
</td>
</tr>
<tr>
