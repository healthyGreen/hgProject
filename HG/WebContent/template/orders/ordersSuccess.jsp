<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

</tr>
<tr>
<td height=100%>

<table height=100% cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
<tr>
<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>

<!-- ����̹��� || ������ġ -->
<div class="sub_tit">
<div class="tit">�ֹ��Ϸ�<span>/ COMPLETE</span></div>
<div class="local">Ȩ > <span>�ֹ��Ϸ�</span></div>
</div>


<div class="indiv" style="width:700px; margin:0 auto;"><!-- Start indiv -->
<div class="oe_tit"><img src="images/complete_txt.jpg"></div>
 <div class="oe_box">
      <div class="tit"><img src="images/complete_tit1.jpg"></div>
      
  </div>

 <table width=100% cellpadding=0 cellspacing=0 class="oe_list">
<tr>
<!--���ʸ���Ʈ����-->
<td valign="top"  width="60%">


<table>
   <tr>
      <th>�������</th>
      <td>���� 79012761211895 healthy Green</td>
   </tr>
   <tr>
      <th>�����ݾ�</th>
      <td><b>${ttotalPrice }��</b></td>
   </tr>
   <s:if test="%{totalPrice }>50000"> ��
   <tr>
      <th>��ۺ�</th>
      <td>3,000��</td>
   </tr>
   </s:if>
   
   </table>
    </td> 
    <!--���ʸ���Ʈ��-->
    <!--�����ʸ���Ʈ����-->
    <td valign="top" width="50%">
    <table>
    <tr>
      <th>�ֹ���ȣ</th>
      <td>${g_number} ����</td>
   </tr>
   <tr>
      <th>�ֹ��ڸ�</th>
      <td>${o_name }</td>
   </tr>
   <tr>
      <th>�ֹ�����</th>
      <td>${o_date }</td>
   </tr>
   <tr>
      <th>�ֹ��ݾ�</th>
      <td>${totalPrice }��</td>
   </tr>
    </table>
    </td>
     <!--�����ʸ���Ʈ��-->
    </tr>
    </table>
   
   


<div style="width:100%; text-align:center; padding:10"><a HREF="main.action"><img src="images/complete_ok.jpg" border=0></a></div>

</div><!-- End indiv -->



<!-- WIDERPLANET PURCHASE SCRIPT START 2017.1.9 -->
<span style="display: none;" name="wp_detection" tag="i">1494477421320</span>
<span style="display: none;" name="wp_detection" tag="t">�ֹ��Ϸ�</span>
<span style="display: none;" name="wp_detection" tag="p">13900</span>
<span style="display: none;" name="wp_detection" tag="u">1494477421320</span>
<script type='text/javascript'>var wp_page_type = 'PurchaseComplete';</script>
<!-- // WIDERPLANET PURCHASE SCRIPT END 2017.1.9 -->



</td>
 
<td width=0 id=pos_scroll valign=top> 
  
  <!-- ��ũ�� ��� -->
  
  <div id=scroll style="position:absolute; margin:70px 10px 10px 30px;width:76px; display:none">

  
  </div>

</td>
</tr>
</table>
</td>
</tr>
<tr>
  <td>