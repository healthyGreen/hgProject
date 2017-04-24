<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 상단이미지 || 현재위치 -->
	<td height=100%>

	<table height=100% cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
	<tr>
	<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>
	<div class="sub_tit">
	  <div class="tit">마이페이지<span>/ MYPAGE</span></div>
	  <div class="local">홈 > <span>MYPAGE</span></div>
	</div>
	<style>
		.box1{width: 600px; margin: 0 auto; }
		.grade{float: left; width: 150px; }
		.grade img{display: block;}
		.grade span{width: 108px; height: 30px; text-align: center; display: block; background: #cadb3d; color: #f0f0f0; font-weight: bold;padding-top: 5px; box-sizing: border-box;  cursor: pointer;}
		.myCont{float: left; width: 450px;     margin-top: 23px;}
		.myCont ul li{width:50%; float: left; text-align: center;   font-size: 17px; font-weight: 600; color: #666;  padding: 0px 10px; box-sizing: border-box;  }
		.myCont ul li span{ border-bottom: 1px solid #ccc; width: 100%;     display: block;    padding-bottom: 5px; margin-bottom: 20px; }
		.ordment .b_cate{ font-size: 13px; font-weight: 600; float: left; margin-right: 5px; }
		.ordment .mpsubtit{ font-size: 11px;  float: left;}
		.mplist table.ordlatelytbl caption {    display: none;}
		.mplist table.ordlatelytbl {    width: 100%;    margin-top: 15px;    border-top: 2px solid #303030;}
		.mplist table.ordlatelytbl th {    background: #f0f0f0;    color: #363636;    height: 31px;    border-left: none;}
		.mplist table.ordlatelytbl td {    color: #555;    border-bottom: 1px solid #e5e5e5;    height: 32px;    text-align: center;    font-size: 12px;}
		.mplist{margin-top: 50px; margin-bottom: 10px; }
		
	</style>
	<div class="mypage" style="width: 1100px; margin: 0 auto;">
		<div class="box1 clear">
			<div class="grade"><img src="../../images/grade.png" alt="" /><span>회원정보변경</span></div>
			<div class="myCont">
				<ul>
					<li><span>hg1212</span></li>
					<li><span>장바구니(1)</span></li>
					<li><span>홍길동</span></li>
					<li><span>적립금(1000)</span></li>
				</ul>
			</div>
		</div>
		<div class="mplist">
		<div class="ordtitle clear">
			<span class="ordment"><span class="b_cate">최근 주문 정보</span><span class="mpsubtit"> | 최근 주문 </span></span>
		</div>
		<div class="ordlistdiv ">
			<form name="frmOrderList" method="post">
				<input type="hidden" name="mode">
				<input type="hidden" name="ordno">
				<table class="ordlatelytbl" cellpadding="0" cellspacing="0" summary="최근 3건의 주문 정보">
					<caption>최근 3건의 주문 정보</caption>
					<colgroup>
						<col width="*">
						<col width="20%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
					</colgroup>
					<tbody><tr>
						<th scope="col">주문일시</th>
						<th scope="col">주문번호</th>
						<th scope="col">결제방법</th>
						<th scope="col">주문금액</th>
						<th scope="col">취소금액</th>
						<th scope="col">주문상태</th>
						<th scope="col">수령확인</th>
						<th scope="col">상세보기</th>
					</tr>
						<tr>
							<td colspan="8" class="nodata">최근 주문 정보가 없습니다.</td>
						</tr>
				</tbody></table>
			</form>
		</div>
		<div class="mplist ">
		<div class="ordtitle clear">
			<span class="ordment"><span class="b_cate">나의게시글</span><span class="mpsubtit"> | 상품후기 </span></span>
		</div>
		<div class="ordlistdiv ">
			<form name="frmOrderList" method="post">
				<input type="hidden" name="mode">
				<input type="hidden" name="ordno">
				<table class="ordlatelytbl" cellpadding="0" cellspacing="0" summary="나의게시글">
					<caption>나의 게시글</caption>
					<colgroup>
						<col width="10%">
						<col width="20%">
						<col width="10%">
						<col width="*">
						<col width="10%">
						<col width="10%">
					</colgroup>
					<tbody><tr>
						<th scope="col">번호</th>
						<th scope="col">이미지</th>
						<th scope="col">상품명</th>
						<th scope="col">후기</th>
						<th scope="col">작성일</th>
						<th scope="col">평점</th>
					</tr>
						<tr>
							<td colspan="6" class="nodata">최근 주문 정보가 없습니다.</td>
						</tr>
				</tbody></table>
			</form>
		</div>
	</div>
	</div>


	

 


</td>
 
</tr>
</table>
</td>
</tr>
<tr>
  <td> 