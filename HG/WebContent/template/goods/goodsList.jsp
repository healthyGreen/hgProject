<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
	String salad = "salad";
	String chacJeb = "chacJeb";
	String smoothy = "smoothy";
	String superFood= "superFood";
	String fruit = "fruit";
	String giftSet = "giftSet";
	String water = "water";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 메인팝업창 -->

	<script language="JavaScript"><!--
	//--></script>
	<script type="text/javascript" src="js/rolling.js"></script>
	<%-- <script type="text/javascript">
	function goodsdelete(g_number,currentPage){
		document.goodsform.action="goodsDelete.action?G_NUMBER="+G_NUMBER+"&currentPage="+currentPage;
		document.goodsform.submit();
	}
	$(function(){ 
		$('#visual').rolling({ 
			autoPlay : true, 
			autoPlayDelayTime :4000,
			opacity : 1 , 	
			click : true ,
		});


	});
	</script> --%>

	<table height=100% cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
		<tr>
			<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>
				<div class="subimg">
					<img src="images/b31ec21d972e1833.jpg">		
				</div>

				<!-- 상단 카테고리 메뉴시작 -->
				<div class="subtab">
				  <ul>
					<li  class="on"><a href="goodsList.action?g_category=<%=chacJeb %>&currentPage=<s:property value="currentPage"/>">착즙주스키트</a>	
					</li>
				 
					<li><a href="goodsList.action?g_category=<%=smoothy %>&currentPage=<s:property value="currentPage"/>">스무디키트</a>
					</li>
				 
					<li><a href="goodsList.action?g_category=<%=salad %>&currentPage=<s:property value="currentPage"/>">샐러드</a>
					</li>
				  </ul>
				</div>
		<!-- 상단 카테고리 메뉴끝 -->
		<!--현재위치시작-->
		<!--현재위치끝-->

	<!--제품리스트상단시작-->

	<div class="indiv"><!-- Start indiv -->
  
		

    
		<table width=100% border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td>      
			   <style>
				.goodsbox{ clear:both; width:100%; height:auto;}
				.goodsbox li{ width:25%; display:inline; float:left; }
				.goodsbox .goods { width:262px; margin:29px auto 0 auto;}
				.goodsbox .goods .img{ cursor:pointer;width:262px; display:block; height:262px; overflow:hidden; text-align:center;position: relative;}
				.goodsbox .goods .img a{width:260px; display:block; height:260px;border:1px solid #dddddd;}
				.goodsbox .goods .img img{ max-width:100%; }
				.goodsbox .goods .name a{display:block; text-align:center; height:30px; line-height:30px; color:#717171; margin-bottom:3px; font-size:14px;}
				.goodsbox .goods .txt{ display:block;text-align: center; line-height:16px; color:#bbbbbb; margin-bottom:5px;}
				.goodsbox .goods .price{display:block;text-align:center;  margin:3px 0; color:#e04141; width:100%; height:33px; line-height:33px; border-bottom:1px solid #dddddd; border-top:1px solid #dddddd; }
				.goodsbox .goods .price .s_p {font-size: 11px; text-decoration: line-through; text-align:left; display:inline;color:#696969;}
				.goodsbox .goods .price .b_p {font-size: 12px; font-weight: bold;  text-align:center;  display:inline;line-height:33px;}
				.goodsbox .goods .price .b_p2 {font-size: 12px;height:51px; line-height:51px; font-weight: bold;  text-align:left;  display:block;}
				.goodsbox .goods .price .sale{font-size:10px; color:#999;display:none;}
				.goodsbox .goods .icon{ display:inline; clear:both; height:15px; line-height:15px; text-align:center;}
				.goodsbox .goods .icon img{ display:inline;padding-right:5px; vertical-align:middle;}
				.percent { position:absolute; left:0px; top:0; }
				.percent:before { position:absolute; content:''; border-left:70px solid red; border-bottom:70px solid transparent; z-index:1; }
				.percent span { position:relative; color:#fff; font-size:18px; top:5px; left:5px; font-weight:bold; z-index:2; }
				</style>
				<ul class="goodsbox">
					<s:iterator value="list" status="stat">
                        <li>
                        	<div class="goods">
                        		 <div class="img" onclick="location.href='goodsView.action?g_number=<s:property value="g_number"/>&currentPage=<s:property value="currentPage"/>'"><img src="./template/goods/upload/${ g_sav_image}"></div>
		                         <span class=" name fb"><a href="goodsView.action?g_number=<s:property value="g_number"/>&currentPage=<s:property value="currentPage"/>">&nbsp;&nbsp;&nbsp;<s:property value="g_name" /></a></span>
		                         <span class="txt"><s:property value="g_info"/></span>
                        	</div>
                           
                        </li>
                     </s:iterator>
                </ul>
			</td>
		  </tr>
		  <tr>
			<!-- <td align=center height=50> <b></b> </td> -->
			
		  </tr>
		  
		  	  <c:if test="${session.session_admin == 1 }"> 
		  	 <tr align="right"><td colspan="4" >
		  	 <input name="list" type="button" style="background:#484647;cursor: pointer; border: none; color: #Fff;     padding: 11px 25px;font-size: 15px;" value="글쓰기" class="inputb" 
		onClick="javascript:location.href='goodsWrite.action?'"/>
		
		
		
		  

		  </c:if>   
	
	
	
		</table>
		<br>
	
		<div align="center"><s:property value="pagingHtml" escape="false"/></div>
	</div>

</td>
 


</td>
 
</tr>
</table>
</td>
</tr>
<tr>
  <td> 