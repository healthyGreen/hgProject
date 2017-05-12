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
<html>
<head>

	<meta name="naver-site-verification" content="f8bc1ade69dafcf14734ea514ed34dbc2d07d6bc"/>	
	<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
	<meta name="description" content="��! �ǰ����� �� �տ�, ���ְ� ����ְ� ���� Ǫ�� ����! ��ñ׸�">
	<meta name="keywords" content="��ñ׸�, �ֽ�ŰƮ, �Ϸ罴��Ǫ��, �Ϸ����Ĩ, �������ÿ���, �����ֽ�, ������, ����Ǫ��, ����Ĩ, �ǰ�����">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />

	<title>Healthy Life Curation, ��ñ׸�</title>

	<script src="../../js/common.js"></script>
	<script src="../../js/cart_tab/godo.cart_tab.js"></script>
	<link rel="styleSheet" href="../../css/cart_tab/style.css">
	<link rel="styleSheet" href="../../css/style.css">
	<script src="../../js/jquery-1.10.2.min.js"></script>
	 
	<!--// Ʃ�� -->  
	<link rel="stylesheet" href="../../css/fonts/nanumsquare.css" />
	<link rel="stylesheet" href="../../css/style_dp.css" />

	<!--// �ٻ�޵�Į css ���� -->
	<link rel="styleSheet" href="../../css/dsm/all.css">
	<link rel="styleSheet" href="../../css/dsm/layout.css">
	<link rel="styleSheet" href="../../css/dsm/sub.css">
	<link rel="styleSheet" href="../../css/dsm/goods.css">

				

</head>


<body bgcolor="" background="" >
	<div id="header">
		<div class="top">
			<div class="area">
        
            <ul class="clear">
                  <c:if test="${session.session_id != null }">
                  	<li><a href="/HG/logout.action">�α׾ƿ�</a></li>
               		<li><a href="/HG/myPage.action">�������</a></li>
               		<li><a href="/HG/qnacustom.action">������</a></li>
               		<li><a href="/HG/basketList.action">��ٱ���</a></li>
               	 </c:if>
             	<c:if test="${session.session_id == null }">
                   	<li><a href="/HG/logInForm.action">�α���</a></li>
               		<li><a href="/HG/joinCheck.action">ȸ������</a></li>
               		<li><a href="/HG/qnacustom.action">������</a></li>
               		<li><a href="/HG/template/basket/BasketLoginError.jsp">��ٱ���</a></li>
               	</c:if>
            </ul>
         </div><!--// area -->
		</div><!--// top -->
		<div class="mid">
			<div class="search">
				<!-- �˻� ����----------------------------------->
				<form action="" onsubmit="return chkForm(this)" style="margin:0; padding:0; border:none;">
					<table cellpadding="0" cellspacing="0" border="0">
						<colgroup>
							<col />
							<col width=40/>
						</colgroup>
						<tr>
							<td><input name="" type="text" id="" class="search_input" onkeyup="" onclick="" value="" required label="�˻���"></td>
							<td class="btnTd"><input type=image src="../../images/btn_search.jpg"></td>
						</tr>
					</table>
				</form>
				<!-- �˻� ��-------------------------------------->		
			</div><!--// search -->

			<h1>
				<a href="/HG/main.action"><img src="../../images/logo.jpg" alt="" /></a>
			</h1><!--// logo -->


			<div class="social">
				<a href="" target="new" class="social01"></a>
				<a href="" target="new" class="social02"></a>
				<a href="" target="new" class="social03"></a>
			</div><!--// social -->

		</div><!--// mid -->

		<div class="bot">
			<div class="area">
				<ul class="gnb clear">
					<li style="width:16.6%">
						<a href="" class="cate1">FRESH KIT</a>
						<div class="two">
							<p><a href="/HG/goodsList.action?g_category=<%=chacJeb %>" class="cate2">�����ֽ�ŰƮ</a>
							</p>
							<p><a href="/HG/goodsList.action?g_category=<%=smoothy %>" class="cate2">������ŰƮ</a>
							</p>
							<p><a href="/HG/goodsList.action?g_category=<%=salad %>" class="cate2">������</a>
							</p>
						</div>
					</li>
					<%-- <li style="width:16.6%">
						<a href="" class="cate1">SNACK</a>
						<div class="two">
							<p><a href="/HG/goodsList.action?g_category=<%=superFood %>" class="cate2">�Ϸ罴��Ǫ��</a>
							</p>
							<p><a href="/HG/goodsList.action?g_category=<%=fruit %>" class="cate2">�Ϸ����Ĩ</a>
							</p>
							<p><a href="/HG/goodsList.action?g_category=<%=giftSet %>" class="cate2">���� ��Ʈ</a>
							</p>
						</div>
					</li>
					<li style="width:16.6%">
						<a href="/HG/goodsList.action?g_category=<%=water %>" class="cate1">REFRESH WATER</a>
					</li> --%>
					<li><a href="/HG/noticeList.action">NOTICE</a></li>
					<li><a href="/HG/reviewList.action">��ǰ�ı�</a></li>
					<li><a href="">ABOUT</a></li>
				</ul>

			</div><!--// area -->

			

		</div><!--// bot -->

	</div><!--// header -->


</tr>
<tr>
<td height=100%>

<table height=100% cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
<tr>
<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>

<!-- ����̹��� || ������ġ -->
<div class="sub_tit">
  <div class="tit">ȸ��Ұ�<span>/ ABOUT COMPANY</span></div>
  <div class="local">Ȩ > <span>ȸ��Ұ�</span></div>
</div>


<div class="indiv"><!-- Start indiv -->

<br>

	<img src="../../images/company.png">



 

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
  <td> 
  
  <jsp:include page="/template/footer.jsp" /> 