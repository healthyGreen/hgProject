<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

	<meta name="naver-site-verification" content="f8bc1ade69dafcf14734ea514ed34dbc2d07d6bc"/>	
	<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
	<meta name="description" content="��! �ǰ����� �� �տ�, ���ְ� ����ְ� ���� Ǫ�� ����! ��ñ׸�">
	<meta name="keywords" content="��ñ׸�, �ֽ�ŰƮ, �Ϸ罴��Ǫ��, �Ϸ����Ĩ, �������ÿ���, �����ֽ�, ������, ����Ǫ��, ����Ĩ, �ǰ�����">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />

	<title>Healthy Life Curation, ��ñ׸�</title>

	<script src="css/common.js"></script>
	<script src="js/cart_tab/godo.cart_tab.js"></script>
	<link rel="styleSheet" href="css/cart_tab/style.css">
	<link rel="styleSheet" href="css/style.css">
	<script src="js/jquery-1.10.2.min.js"></script>
	 
	<!--// Ʃ�� -->  
	<link rel="stylesheet" href="css/fonts/nanumsquare.css" />
	<link rel="stylesheet" href="css/style_dp.css" />

	<!--// �ٻ�޵�Į css ���� -->
	<link rel="styleSheet" href="css/dsm/all.css">
	<link rel="styleSheet" href="css/dsm/layout.css">
	<link rel="styleSheet" href="css/dsm/sub.css">
	<link rel="styleSheet" href="css/dsm/goods.css">

				

</head>


<body bgcolor="" background="" >
	<div id="header">
		<div class="top">
			<div class="area">
        
            <ul class="clear">
                  <c:if test="${session.session_id != null }">
                  	<li><a href="logout.action">�α׾ƿ�</a></li>
               		<li><a href="">�������</a></li>
               		<li><a href="">������</a></li>
               		<li><a href="">��ٱ���</a></li>
               	 </c:if>
             	<c:if test="${session.session_id == null }">
                   	<li><a href="/HG/logInForm.action">�α���</a></li>
               		<li><a href="/HG/joinCheck.action">ȸ������</a></li>
               		<li><a href="">������</a></li>
               		<li><a href="">��ٱ���</a></li>
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
							<td class="btnTd"><input type=image src="images/btn_search.jpg"></td>
						</tr>
					</table>
				</form>
				<!-- �˻� ��-------------------------------------->		
			</div><!--// search -->

			<h1>
				<a href="main.action"><img src="images/logo.jpg" alt="" /></a>
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
							<p><a href="" class="cate2">�����ֽ�ŰƮ</a>
							</p>
							<p><a href="" class="cate2">������ŰƮ</a>
							</p>
							<p><a href="" class="cate2">������</a>
							</p>
						</div>
					</li>
					<li style="width:16.6%">
						<a href="" class="cate1">SNACK</a>
						<div class="two">
							<p><a href="" class="cate2">�Ϸ罴��Ǫ��</a>
							</p>
							<p><a href="" class="cate2">�Ϸ����Ĩ</a>
							</p>
							<p><a href="" class="cate2">���� ��Ʈ</a>
							</p>
						</div>
					</li>
					<li style="width:16.6%">
						<a href="" class="cate1">REFRESH WATER</a>
					</li>
					<li><a href="noticeList.action">NOTICE</a></li>
					<li><a href="">��ǰ�ı�</a></li>
					<li><a href="">ABOUT</a></li>
				</ul>

			</div><!--// area -->

			

		</div><!--// bot -->

	</div><!--// header -->