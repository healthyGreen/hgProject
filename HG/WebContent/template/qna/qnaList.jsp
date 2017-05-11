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
	<meta name="description" content="띵동! 건강함이 문 앞에, 맛있게 재미있게 즐기는 푸드 서비스! 헬시그린">
	<meta name="keywords" content="헬시그린, 주스키트, 하루슈퍼푸드, 하루과일칩, 리프레시워터, 착즙주스, 스무디, 슈퍼푸드, 과일칩, 건강간식">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />

	<title>Healthy Life Curation, 헬시그린</title>

	<script src="../../js/common.js"></script>
	<script src="../../js/cart_tab/godo.cart_tab.js"></script>
	<link rel="styleSheet" href="../../css/cart_tab/style.css">
	<link rel="styleSheet" href="../../css/style.css">
	<script src="../../js/jquery-1.10.2.min.js"></script>
	 
	<!--// 튜닝 -->  
	<link rel="stylesheet" href="../../css/fonts/nanumsquare.css" />
	<link rel="stylesheet" href="../../css/style_dp.css" />

	<!--// 다산메디칼 css 차용 -->
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
                  	<li><a href="/HG/logout.action">로그아웃</a></li>
               		<li><a href="/HG/myPage.action">마이헬시</a></li>
               		<li><a href="/HG/qnacustom.action">고객센터</a></li>
               		<li><a href="/HG/basketList.action">장바구니</a></li>
               	 </c:if>
             	<c:if test="${session.session_id == null }">
                   	<li><a href="/HG/logInForm.action">로그인</a></li>
               		<li><a href="/HG/joinCheck.action">회원가입</a></li>
               		<li><a href="/HG/qnacustom.action">고객센터</a></li>
               		<li><a href="/HG/template/basket/BasketLoginError.jsp">장바구니</a></li>
               	</c:if>
            </ul>
         </div><!--// area -->
		</div><!--// top -->
		<div class="mid">
			<div class="search">
				<!-- 검색 시작----------------------------------->
				<form action="" onsubmit="return chkForm(this)" style="margin:0; padding:0; border:none;">
					<table cellpadding="0" cellspacing="0" border="0">
						<colgroup>
							<col />
							<col width=40/>
						</colgroup>
						<tr>
							<td><input name="" type="text" id="" class="search_input" onkeyup="" onclick="" value="" required label="검색어"></td>
							<td class="btnTd"><input type=image src="../../images/btn_search.jpg"></td>
						</tr>
					</table>
				</form>
				<!-- 검색 끝-------------------------------------->		
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
							<p><a href="/HG/goodsList.action?g_category=<%=chacJeb %>" class="cate2">착즙주스키트</a>
							</p>
							<p><a href="/HG/goodsList.action?g_category=<%=smoothy %>" class="cate2">스무디키트</a>
							</p>
							<p><a href="/HG/goodsList.action?g_category=<%=salad %>" class="cate2">샐러드</a>
							</p>
						</div>
					</li>
					<%-- <li style="width:16.6%">
						<a href="" class="cate1">SNACK</a>
						<div class="two">
							<p><a href="/HG/goodsList.action?g_category=<%=superFood %>" class="cate2">하루슈퍼푸드</a>
							</p>
							<p><a href="/HG/goodsList.action?g_category=<%=fruit %>" class="cate2">하루과일칩</a>
							</p>
							<p><a href="/HG/goodsList.action?g_category=<%=giftSet %>" class="cate2">선물 세트</a>
							</p>
						</div>
					</li>
					<li style="width:16.6%">
						<a href="/HG/goodsList.action?g_category=<%=water %>" class="cate1">REFRESH WATER</a>
					</li> --%>
					<li><a href="/HG/noticeList.action">NOTICE</a></li>
					<li><a href="/HG/reviewList.action">상품후기</a></li>
					<li><a href="">ABOUT</a></li>
				</ul>

			</div><!--// area -->

			

		</div><!--// bot -->

	</div><!--// header -->
<script language="javascript">
var preContent;

function view_content(obj)
{
	var div = obj.parentNode;

	for (var i=1, m=div.childNodes.length;i<m;i++) {
		if (div.childNodes[i].nodeType != 1) continue;	// text node.
		else if (obj == div.childNodes[ i ]) continue;

		obj = div.childNodes[ i ];
		break;
	}

	if (preContent && obj!=preContent){
		obj.style.display = "block";
		preContent.style.display = "none";
	}
	else if (preContent && obj==preContent) preContent.style.display = ( preContent.style.display == "none" ? "block" : "none" );
	else if (preContent == null ) obj.style.display = "block";

	preContent = obj;
}

{ // 초기출력
	var no = "faq_48";
	if ( document.getElementById( no ) ) view_content( document.getElementById( no ) );
}
</script>


</tr>
<tr>
<td >

<table  cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
<tr>

<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>
<!-- 상단이미지 || 현재위치 -->
<div class="sub_tit">
<div class="tit">자주하는질문<span>/ FAQ</span></div>
<div class="local">홈 > 고객센터 > <span>FAQ</span></div>
</div>


<div class="indiv"><!-- Start indiv -->

<!-- 검색 : Start -->
<form name=frmList id="form">
<style>
.faqbox{border:1px solid #d0d0d0; background-color:#eeeeee; margin-bottom:20px;}
.faqbox .faq_sc{width:444px; height:35px; margin:17px auto 0 auto;}
.faqbox .faq_sc .scform{ float:left; border:1px solid #d0d0d0; background-color:#fff !important;width:348px; height:33px; line-height:33px; text-align:center; font-size:15px;}
.faqbox .faq_sc .scbtn{float:right;}
.faqbox .faq_txt{width:100%; text-align:center; height:15px; line-height:15px; margin:15px 0;}
.faqbox .faq_txt li{display:inline;}
.faqbox .faq_txt li a{color:#717171;}
</style>

</form>

<!-- 검색 : End -->



<table width=100% cellpadding=0 cellspacing=0 border=0  class="tlist">
<tr>
	<th width=50 class="input_txt">번호</th>
	<th class="input_txt">제목</th>
</tr>
</table>

<div>
<table width=100% cellpadding=0 cellspacing=0 border=0 class="tlist2_in" onclick="view_content(this)" id="faq_48">
<tr height=27 >
	<td width=50 align="center">1</td>
	<td class="l"><font color="#007FC8">[결제/배송]</font> 가상  계좌로 결제할 경우 주문 후 얼마 만에 입금을 해야 하나요?</td>
</tr>
</table>
<div style="display:none;padding:10;border-bottom-style:solid;border-bottom-color:#E6E6E6;border-bottom-width:1;">
	<table cellpadding=0 cellspacing=0 border=0>
	<tr valign="top">
		<th style="color:#0000bf;width:40; padding-top:1"></th>
		<td style="line-height:20px;"><br />
가상 계좌의 경우 주문 후 가상 계좌 번호를 문자로 보내드립니다.<br />
문자를 받으신 후 24시간 이내로 입금해주시면 정상적으로 주문이 됩니다.<br />
<br />
24시간이 지나면 결제 계좌로 입금을 할 수 없으며  주문은 자동 취소됩니다.<br />
</td>
	</tr>
	</table>
</div>

<br><br>

</div><!-- End indiv -->




</td>
 
<td width=0 id=pos_scroll valign=top> 
  
  <!-- 스크롤 배너 -->
  
  <div id=scroll style="position:absolute; margin:70px 10px 10px 30px;width:76px; display:none">

  
  </div>
  
</td>
</tr>
</table>
</td>
</tr>
<tr>

  <jsp:include page="/template/footer.jsp" /> 
