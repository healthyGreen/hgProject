<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     <%
        String session_id = (String)session.getAttribute("session_id");
        /* String b_g_bottle = "��";
        int b_g_amount = 3; */
     %>
     <script type="text/javascript">
   function cartAdde(goodsForm) {
      var b_g_amount = document.goodsForm.b_g_amount.value;
      window.location.href='basketInput.action?m_id=<%= session_id%>&g_number=${g_number}&b_g_name=${goodsResult.g_name}&b_g_price=${goodsResult.g_price}&what=notHeader&b_g_amount='+b_g_amount;
   }
   function buyIt(goodsForm) {
      var b_g_amount = document.goodsForm.b_g_amount.value;
      var b_g_bottle = document.goodsForm.b_g_bottle.value;
      window.location.href='orderForm.action?m_id=<%=session_id%>&g_number=${g_number}&g_name=${goodsResult.g_name}&price=${goodsResult.g_price}&amount='+b_g_amount+'&bottle='+b_g_bottle+'&orderType=goods';
   } 
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<style>
		.replyTable th{border-bottom: 1px solid #999; padding: 10px 0px; vertical-align: middle;}
		.replyTable td{border-bottom: 1px solid #ddd; padding: 10px 0px; vertical-align: middle;}
		.replyTable input{border: 1px solid #ddd; padding: 5px 10px; cursor: pointer; }
		.replyTable2 {width: 1100px; margin: 0 auto; }
		.replyTable2 input{border: 1px solid #ddd;height: 32px;  margin-left: 10px; }
		.replyTable2 textarea{border: 1px solid #ddd !important ; background: #f0f0f0;     height: 75px;    width: 800px;  }
		.replyTable2 .inputb{background: #484647; border: none !important; color: #fff; font-weight: 600; width: 100px; height:75px; }
	</style>
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
         &b_g_price=<s:property value="goodsResult.g_price"/>">��ٱ���</a> --%>
         
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
                                    <img src="./template/goods/upload/${goodsResult.g_sav_image}" id=objImg />
                                    
                                 </span>
                              </div>
                           </div>
                           <div id=goods_spec class="view_info"> 
                              <div class="info_name"> <span class="tit">${goodsResult.g_name }</span> <span class="txt">${goodsResult.g_info }</span> </div>
                              <table border=0 cellpadding=0 cellspacing=0 class=top>
                                 <tr class="info_price">
                                    <th>�ǸŰ��� </th>
                                    <td>
                                    <b><span id=price><s:property value="goodsResult.g_price"/></span>��</b>
                                    </td>
                                 </tr>
                              </table>
                              <table border=0 cellpadding=0 cellspacing=0>
                                 <tr>
                                    <th>���� </th>
                                    <td>${goodsResult.g_ingr }</td>
                                 </tr>
                                 <tr>
                                    <th>�뷮 </th>
                                    <td>1,615g</td>
                                 </tr>
                                 <tr>
                                    <th>���  </th>
                                    <td>��ۺ�3,000��</td>
                                 </tr>
                                 <tr>
                                    <th>��� 1 </th>
                                    <td>*3���� �̻� ���Ž� ���� ���</td>
                                 </tr>
                                 <tr>
                                    <th>��� 2 </th>
                                    <td>*�ֽ�ŰƮ�� �ٸ� ��ǰ(�Ϸ罴��Ǫ��, �Ϸ����Ĩ, �������ÿ���)�� '������ ���'�˴ϴ�.</td>
                                 </tr>
                                 <tr>
                                    <th class=count >���ż��� </th>
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
            <option value="medium">500 mL</option>
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
                              <%-- <div class="info_total">�� ��ǰ�ݾ� :  <span class="feb" id="el-multi-option-total-price">19,800 ��</span></div> --%>
                             </div>
 
                             <div class="view_btn">
                             <c:if test="${session.session_id != null }">                
                              <a href="javascript:act('../order/order')" onclick="return buyIt(this.form)"><img src="images/buy_now.png"></a>
                              </c:if>
                              <c:if test="${session.session_id == null }">
                              <a href="/HG/template/basket/BasketLoginError.jsp" onclick="return buyIt(this.form)"><img src="images/buy_now.png"></a>
                              </c:if>
                              <a href="javascript:cartAdd(this.form)" onclick="return cartAdde(this.form)"><img src="images/cart.png" /></a> 
                              <!-- <input type="button" value="��ٱ���" onclick="return cartAdde(this.form)">
                              <style>.view_btn a{margin-left:20px} </style>
                             </div><br><input type="button" value="��ǰ����" onclick="return buyIt(this.form)"> -->
                           
                          </div>
                        </div>
                       </div>

                       
  
                  <div class="view_con"> 
                     <a name="viewtab1"></a> 
                     <div class="prdc_tab">
                        <div>
                           <ul class="cfix">
                                 <li class="selected"><a  href="#viewtab1">��ǰ������</a></li>
                                 <li><a href="#viewtab2">��۾ȳ�</a></li>
                                 <li><a href="#viewtab3">��ǰ����</a></li>
                           </ul>
                        </div>
                     </div> 
                     <!-- �� ����s -->
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
                           <div style="text-align: center;"><img src="images/dcafc160271722dd.gif"><br></div>
                           <div style="text-align: center;"><br></div>
                           <div style="text-align: center;"><img src="images/9e5b43b9086cea67.jpg"><br></div>
                           <div style="text-align: center;"><br></div>
                           <div style="text-align: center;"><br></div>
                           <div style="text-align: center;"><br></div>
                           <div style="text-align: center;"><img src="images/c1d520c053ed3b49.jpg"><br></div>
                           <div style="text-align: center;"><br></div>
                           <div style="text-align: center;"><br></div>
                           <div style="text-align: center;"><br></div>
                           <div style="text-align: center;"><br></div>
                          </td>
                        </tr>
                       </table>
                     </div>
                     <!-- �� ����e --> 


                     <a name="viewtab2"></a> 
                     <div class="prdc_tab">
                              <div>
                                 <ul class="cfix">
                                       <li><a  href="#viewtab1">��ǰ������</a></li>
                                       <li class="selected"><a href="#viewtab2">��۾ȳ�</a></li>
                                       <li><a href="#viewtab3">��ǰ����</a></li>
                                 </ul>
                              </div>
                     </div>
                        <!-- ��۾ȳ�s -->
                          <div class="con111">
                           <ul>
                              <Font Size=2 color=#323130 line-height:-8px;>   
                              <img src="images/delivery_page.jpg"><br>
                                 <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<��ۺ�></b><br>
                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��۷�: 3,000��<br> 
                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���� ���: 30,000�� �̻� ���� �� ���� ���(*����,�갣,���� �Ϻ������� ��ۺ� �߰��� �� �ֽ��ϴ�)<br>
                           <br>
                           <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<�ֹ� ���� �� ��� ���></b><br>
                              <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* �ֽ�ŰƮ</b><br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- �ù�� : �����ù�(1588-9988)<br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- �ֹ�����: ����3�� (3�� ���� �ֹ����� �����ֹ����� ó��)<br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- ���ϻ���&���-�������� �������� �ֹ��Ϸκ��� ��� 3���Դϴ�.<br>
                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- �̸� ����� ������ �ƴ� �ֹ��� ���ÿ� ��Ḧ �ֹ��ϴ� ����̱⿡ <b><u>�����ž��ϴ� ��¥&#160;'3��'���� �ֹ���Ź�帳�ϴ�.</u></b>
                              <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ex) ������ֹ�(����3������)-�ݿ�������&�߼�-����� Ȥ�� ȭ���� ����<br>
                              <br>
                              <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* �������ÿ���/����(�Ϸ罴��Ǫ��,�Ϸ����Ĩ)</b><br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- �ù��:�������(1588-1255)<br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- �ֹ������� ����1��.(1������ �ֹ����� �����ֹ����� ó��)<br>
                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- �������� �ֹ��Ϸκ��� ���2���Դϴ�.(������ ���� ����3�� �ɸ� �� �ֽ��ϴ�.) ex) �ݿ����ֹ�(����1������)-�������-����� Ȥ�� �����ϼ���<br></Font>
                              </ul>
                          </div>
                        <!-- ��۾ȳ�e -->

                        <a name="viewtab3"></a> 
                        <div class="prdc_tab">
                           <div>
                              <ul class="cfix">
                                    <li><a  href="#viewtab1">��ǰ������</a></li>
                                    <li><a href="#viewtab2">��۾ȳ�</a></li>
                                    <li class="selected"><a href="#viewtab3">��ǰ����</a></li>
                              </ul>
                           </div>
                        </div>
                       

     
      <tr>
      	<td colspan="2">
        	<table width="100%;" class="replyTable">
      		<colspan>
      			<col width="50">
                <col>
                <col width="110">
                <col width="85">
      		</colspan>
      		<tr>
      			<th width="50px;">��ȣ</th>
		        <th>����</th>
		        <th>�ۼ���</th>
		        <c:if test="${session.session_admin == 1 }"> 
		        <th>�����ڹ�ư</th>
		        </c:if>
      		</tr>
      		<s:iterator value="replylist" status="stat">
	      <tr>
	         <td height="10" width="130" align="center"><s:property value="rp_number"/><br></td>
	         <td><s:property value="rp_content"/></td>	
	         <td><s:property value="rp_date"/></td>
	         <%-- <c:if test="${session.session_admin == 1 }"> --%> 
	         <td>
	         <%-- <s:property value="rp_content"/>
	         <a href="javascript:open_win_noresizable('replyDeletePro.action?g_number=<s:property value="g_number"/>&originno=<s:property value=""/>&currentPage=<s:property value="currentPage"/>','rp_delete')">x</a>
	       <!-- <a href="replyDeleteForm.action" onclick="location.href='replyDeleteForm.action'">x</a> --> --%>
			 	<input type="button" value="x" onclick="javascript:location.href='replyDeletePro.action?g_number=${g_number}&currentPage=${currentPage}&rp_number=${rp_number}'"/>
			 	<input type="button" value="�亯" onclick="javascript:location.href='template/goods/replyWriteForm.jsp?g_number=${g_number}&rp_ref=${rp_ref}&currentPage=${currentPage}'"/>
	         </td>
	         <%-- </c:if> --%>
	     </tr>
		    </s:iterator>
		 <s:if test="replylist.size() <= 0">
	     <tr>
	         <td colspan="2" height="10">           
	            	��۾��� 
	         </td>
	      </tr>
	       </s:if>
      	</table>
        </td>
      </tr>

      <tr>
		 <s:url id="deleteURL" action="replyDeletePro.action">
         <s:param name="no">
         <s:property value="no"/>
         </s:param>
         </s:url>
     </tr>
                           <!-- ��ǰ����e--> 

                  </td>
 

 
               </tr>
            </table>
            </form>
         <form action="replyWrite.action" method="post">
         <table class="replyTable2">
         	 <s:hidden name="originno" value="%{resultClass.no}"/>
	         <s:hidden name="no" value="%{resultClass.no}"/>
	         <s:hidden name="currentPage" value="%{currentPage}"/>
	         <s:hidden name="g_number" value="%{goodsResult.g_number}"/>
	         <s:hidden name="checked" value="1"/>
            <tr>
	             <td width="170">
	            	<table>
	            		<tr>
	            			<td>�̸�</td>
	            			<td><s:textfield name="name" theme="simple" value="" cssStyle="width:100px" maxlength="20" /></td>
	            		</tr>
	            		<tr>
	            			<td height="10" colspan="2"></td>
	            		</tr>
	            		<tr>
	            			<td>��й�ȣ</td>
	            			<td> <s:textfield name="password" theme="simple" value="" cssStyle="width:100px" maxlength="20" /></td>
	            		</tr>
	            	</table>
		         </td>
		         <td>
		         	<s:textarea name="content" theme="simple" value="" cols="60" rows="3"/>
		         </td>
		         <td colspan="2" >
	            	<input name="submit" type="submit" value="�ۼ��Ϸ�" class="inputb">
	             </td>
         	</tr>
        
             
   
         </table>
         </form>
         </td>
      </tr>
<tr>
  <td> 
  
   <c:if test="${session.session_admin == 1 }"> 
       <div style="width: 1100px; margin: 0 auto; ">    
            <input name="list" type="button" value="��ǰ ����" class="inputb" 
      onclick="javascript:location.href='goodsDelete.action?g_number=${g_number}'" style="margin-top: 50px; float: right; background: red; cursor: pointer;  border: none !important; color: #fff; font-weight: 600; width: 100px; height:20px;"/>
   
  	  </div>

   </c:if>   
  
  