<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 메인팝업창 -->

	<script language="JavaScript"><!--
	//--></script>
	<script type="text/javascript" src="js/rolling.js"></script>
	<script type="text/javascript">
	$(function(){ 
		$('#visual').rolling({ 
			autoPlay : true, 
			autoPlayDelayTime :4000,
			opacity : 1 , 	
			click : true ,
		});


	});
	</script>

	<div id="visual" >

		<ul>
			<li class="slider01">
				<div><a href=""><!-- 메인 이미지 배너 (배너관리에서 수정가능) -->
					<a href="" target="">
						<img src="images/W_main_21.jpg" align="absmiddle">
					</a>
				</a></div>
			</li>
			<li class="slider03">
				<div><a href=""><!-- 메인 이미지 배너 (배너관리에서 수정가능) -->
					<a href="" target="">
						<img src="images/W_main_17-1.jpg" align="absmiddle">
					</a></a></div></li>
			<li class="slider11">
			
			<div><iframe width="1100" height="470" src="https://www.youtube.com/embed/oqNOssGdGxQ?&autoplay=1" frameborder="0" allowfullscreen></iframe></div></li>

		</ul><!--// slider -->

		<div class="navi">
			<ol class="clear">
				<li><a href=""></a></li>
				<li><a href=""></a></li>           
				<li><a href=""></a></li>
			</ol>
		</div><!--// navi -->
		
		<div class="button">
			<div class="prev"><img src="images/btn_prev.png" alt="" /></div>
			<div class="next"><img src="images/btn_next.png" alt="" /></div>
		</div><!--// button -->

	</div><!--// visual -->


	<div id="cont">

		<div class="area">

			<h4><img src="images/main_title_01.jpg" alt="" /></h4>

			<!-- 상품 리스트 #1 -->
			<div class="mt20"></div>

			
			
			
			
			
			 
	<!-- 상품 리스트 -->
	<table width=100% border=0 cellpadding=0 cellspacing=0 class="tpl01Best">
		<tr>
			<td height=10></td>
		</tr>
		<tr>
			<td align=center valign=top width="33.3333333333%">

				<div class="goodsImg">
					<div class="img" style="   width: 290px;    margin: 0 auto; text-align: center;">
						<a href=""><img src='images/1491531422792i0.jpg' width=290 class="" /></a>
					</div>
					<div class="goodsNm"><a href="" >샐러드7팩X샐러드볼X무료배송</a></div>
					<div class="shortdesc">언제, 어디서나 괜찮은 원더그린 만능샐러드</div>
				<div>
				<span><a href="" class="pprice" style="display:inline-block;"><b>15,900원</b></a></span> 	
			</td>
			<td align=center valign=top width="33.3333333333%">

				<div class="goodsImg">
					<div class="img" style="   width: 290px;    margin: 0 auto; text-align: center;">
						<a href=""><img src='images/1491830021450i0.jpg' width=290 class="" /></a>
					</div>
					<div class="goodsNm"><a href="" >샐러드7팩X샐러드볼X무료배송</a></div>
					<div class="shortdesc">언제, 어디서나 괜찮은 원더그린 만능샐러드</div>
				<div>
				<span><a href="" class="pprice" style="display:inline-block;"><b>15,900원</b></a></span> 
			</td>
			<td align=center valign=top width="33.3333333333%">

				<div class="goodsImg">
					<div class="img" style="   width: 290px;    margin: 0 auto; text-align: center;">
						<a href=""><img src='images/1484201984638i0.jpg' width=290 class="" /></a>
					</div>
					<div class="goodsNm"><a href="" >샐러드7팩X샐러드볼X무료배송</a></div>
					<div class="shortdesc">언제, 어디서나 괜찮은 원더그린 만능샐러드</div>
				<div>
				<span><a href="" class="pprice" style="display:inline-block;"><b>15,900원</b></a></span> 
			</td>
		</tr>
		<tr><td height=10></td></tr>
	</table>	
	<div class="banner01">
		 <ul>
			<li><!-- 메인 이미지 배너 (배너관리에서 수정가능) --><a href="" target=""><img src="images/two_delivery.jpg" align="absmiddle"></a></li>
			<li><!-- 메인 이미지 배너 (배너관리에서 수정가능) --><a href="" target=""><img src="images/W_two_kakao.jpg" align="absmiddle"></a></li>
		 </ul>
	</div>
	<h4><img src="images/main_title_02.jpg" alt=""style="margin-bottom: 16px;"></h4>		
			
	<link rel="stylesheet" href="css/owl/owl.carousel.css" />
	<link rel="stylesheet" href="css/owl/owl.theme.css" />
	<script type="text/javascript" src="js/owl/owl.carousel.js"></script>
	<style>
	.circle{
	width:225px;
	height:225px;
	position:absolute;
	top:0;
	left:71px;
	}
	</style>
	<script type="text/javascript">
	$(function(){ 


		$(".owlArea .owl").owlCarousel({
			items : 3, 
			autoPlay :4000 ,
			stopOnHover : true ,
			paginationSpeed : 600,
		});
		var owl = $(".owlArea .owl").data('owlCarousel');
		$(".owlArea .prev").click(function(){
			owl.prev();
		});
		$(".owlArea .next").click(function(){
			owl.next();
		});
		

	});
	</script>
	<div class="owlArea  carousel">
		<div class="tpl01Best owl">
			<div class="item">
				<div class="goodsImg">
					<a href="">
						<img src='images/1482220235731l0.jpg' width=225 class=""/>
					</a>
					<div class="circle"><img src="images/circle.png"></div>
				</div>
				<div class="goodsNm"><a href="" >스키니앨리스(green) SET(5팩)</a></div>
				<div class="shortdesc">47kcal의 포만감</div>
				<div>
					<span><a href="" class="pprice" style="display:inline-block;"><b>21,900원</b></a></span>
				</div>
			</div><!--// item -->
			<div class="item">
				<div class="goodsImg">
					<a href="">
						<img src='images/1482220214119l0.jpg' width=225 class="" />
					</a>
					<div class="circle"><img src="images/circle.png"></div>
				</div>
				<div class="goodsNm"><a href="" >타임리스(red) SET (5팩)</a></div>
				<div class="shortdesc">멈춰진 노화의 시간</div>
				<div>
					<span><a href="" class="pprice" style="display:inline-block;"><b>21,900원</b></a></span>
				</div>
			</div><!--// item -->
			<div class="item">
				<div class="goodsImg">
					<a href="">
						<img src='images/1482220164995l0.jpg' width=225 class=""  />
					</a>
					<div class="circle"><img src="images/circle.png"></div>
				</div>
				<div class="goodsNm"><a href="" >뷰티퀸(orange) SET (5팩)</a></div>
				<div class="shortdesc">뷰티 비타민 충전</div>
				<div>
					<span><a href="" class="pprice" style="display:inline-block;"><b>21,900원</b></a></span>
				</div>
			</div><!--// item -->
			<div class="item">
				<div class="goodsImg">
					<a href="">
						<img src='images/1482224978491l0.jpg' width=225 class="" />
					</a>
					<div class="circle"><img src="images/circle.png"></div>
				</div>
				<div class="goodsNm"><a href="" >하트비트(red) 1L 기준</a></div>
				<div class="shortdesc">몸 속까지 깨끗하게</div>
				<div>
					<span><a href="" class="pprice" style="display:inline-block;"><b>19,800원</b></a></span>
				</div>
			</div><!--// item -->
			<div class="item">
				<div class="goodsImg">
					<a href="">
						<img src='images/1482224956268l0.jpg' width=225 class=""/>
					</a>
					<div class="circle"><img src="images/circle.png"></div>
				</div>
				<div class="goodsNm"><a href="" >댄싱래빗(orange) 1L 기준</a></div>
				<div class="shortdesc">에너지 부스터</div>
				<div>
					<span><a href="" class="pprice" style="display:inline-block;"><b>17,900원</b></a></span>
				</div>
			</div><!--// item -->
			<div class="item">
				<div class="goodsImg">
					<a href="">
						<img src='images/1481465365625l0.jpg' width=225 class=""  />
					</a>
				<div class="circle"><img src="images/circle.png"></div>
				</div>
				<div class="goodsNm"><a href="" >MIX SET (5팩) 골라담기</a></div>
				<div class="shortdesc">5가지 맛 골라담기</div>
				<div>
					<span><a href="" class="pprice" style="display:inline-block;"><b>21,900원</b></a></span>
				</div>
			</div><!--// item -->
		</div><!--// owl -->
		<div class="button prev"><img src="images/btn_carousel_prev.jpg" alt="" /></div>
		<div class="button next"><img src="images/btn_carousel_next.jpg" alt="" /></div>
	</div><!--// owlArea -->

	<div class="area">
		<h4><img src="images/main_title_03.jpg" alt="" /></h4>		 
	<!-- 상품 리스트 -->
		<table width=100% border=0 cellpadding=0 cellspacing=0 class="tpl01Best">
			<tr><td height=10></td></tr>
			<tr>
				<td align=center valign=top width="33.3333333333%">
					<div class="goodsImg">
						<div class="img" style="   width: 290px;    margin: 0 auto;text-align: center;"><a href=""><img src='images/1481460820415i0.jpg' width=290 class=""/></a></div>
						<div style="padding:3px"><img src="images/good_icon_soldout.gif"></div>
						<div class="goodsNm"><a href="" >하루과일칩 MIX (3팩)</a></div>
						<div class="shortdesc">설탕 No, 첨가물 No! 자연 그대로의 과일 칩</div>
					<div>
		 
					
					<span><a href="" class="pprice" style="display:inline-block;"><b>15,900원</b></a></span> 			
				</td>
				<td align=center valign=top width="33.3333333333%">
					<div class="goodsImg">
						<div class="img" style="   width: 290px;    margin: 0 auto;text-align: center;"><a href=""><img src='images/1481460887408i0.jpg' width=290 class=""  /></a>
							<div class="percent"><span >20%</span></div>
						</div>
						<div class="goodsNm"><a href="" >하루슈퍼푸드 2BOX(28팩)</a></div>
						<div class="shortdesc">세계적인 건강 트렌드인 슈퍼푸드를 간편하게 섭취하세요</div>
					<div>
					<span style="font-size: 12px;color: #989898;margin-right: 10px;text-decoration: line-through;">29,900원</span> 
					<span><a href="" class="pprice" style="display:inline-block;"><b>23,900원</b></a></span> 			
				</td>
			</tr>
			<tr><td height=10></td></tr>
		</table>
			<!-- 상품 리스트 #4 -->
		<h4 style="margin-top:40px"><img src="images/main_title_04.jpg" alt="" /></h4>





	 
		<!-- 상품 리스트 -->
		<table width=100% border=0 cellpadding=0 cellspacing=0 class="tpl01Best">
			<tr><td height=10></td></tr>
			<tr>
				<td align=center valign=top width="33.3333333333%">
					<div class="goodsImg">
						<div class="img" style="   width: 290px;    margin: 0 auto; text-align: center;"><a href=""><img src='images/1481460743432l0.jpg' width=290 class=""  /></a>
					</div>
					<div class="goodsNm"><a href="" >버라이어티 28팩</a></div>
					<div class="shortdesc">7종 전제품이 골고루 담긴 선물용 세트</div>
					<div>
						<span><a href="" class="pprice" style="display:inline-block;"><b>58,800원</b></a></span> 			
					</div>
				</td>
				<td align=center valign=top width="33.3333333333%">
					<div class="goodsImg">
						<div class="img" style="   width: 290px;    margin: 0 auto; text-align: center;"><a href=""><img src='images/1481460293777s0.jpg' width=290 class="" /></a>
					</div>
					<div class="goodsNm"><a href="" >ONE FINE DAY 28팩</a></div>
					<div class="shortdesc">향기로운 하모니</div>
					<div>
						<span><a href="" class="pprice" style="display:inline-block;"><b>64,800원</b></a></span> 			
					</div>
				</td>
				<td align=center valign=top width="33.3333333333%">
					<div class="goodsImg">
						<div class="img" style="   width: 290px;    margin: 0 auto;text-align: center;"><a href=""><img src='images/1481460117629s0.jpg' width=290 class="" /></a>
					</div>
					<div class="goodsNm"><a href="" >SUNSHINE 28팩</a></div>
					<div class="shortdesc">햇빛 머금은 시트러스</div>
					<div>
						<span><a href="." class="pprice" style="display:inline-block;"><b>52,800원</b></a></span> 			
					</div>
				</td>
			</tr>
			<tr><td height=10></td></tr>
			<tr><td height=10></td></tr>
			<tr>
				<td align=center valign=top width="33.3333333333%">
					<div class="goodsImg">
						<div class="img" style="width: 290px;    margin: 0 auto;text-align: center;"><a href=""><img src='images/1481460036360s0.jpg' width=290 class=""  /></a>
					</div>
				    <div class="goodsNm"><a href="" >CHEER UP 28팩</a></div>
					<div class="shortdesc">다이어트 응원가</div>
					<div>
						<span><a href="" class="pprice" style="display:inline-block;"><b>58,800원</b></a></span> 			
					</div>
				</td>
				<td align=center valign=top width="33.3333333333%">
					<div class="goodsImg">
						<div class="img" style="   width: 290px;    margin: 0 auto;text-align: center;"><a href=""><img src='images/1481459952336s0.jpg' width=290 class="" /></a>
					</div>
					<div class="goodsNm"><a href="" >LEMON TREE 28팩</a></div>
					<div class="shortdesc">상큼하게 레몬 디톡스</div>
					<div>
						<span><a href="" class="pprice" style="display:inline-block;"><b>48,800원</b></a></span> 	
					</div>
				</td>
				<td align=center valign=top width="33.3333333333%">

					<div class="goodsImg">
						<div class="img" style="   width: 290px;    margin: 0 auto;text-align: center;"><a href=""><img src='images/1481460769874l0.jpg' width=290 class="" /></a>
					</div>
					<div class="goodsNm"><a href="" >스타트팩</a></div>
					<div class="shortdesc">리프레시워터를 처음 접하는 당신을 위해</div>
					<div>
						<span><a href="" class="pprice" style="display:inline-block;"><b>19,900원</b></a></span> 		
					</div>
				</td>
			</tr>
			<tr><td height=10></td></tr>
		</table>
	</div><!--// area -->

	</div><!--// cont -->









</td>
 
</tr>
</table>
</td>
</tr>
<tr>
  <td> 
 </div>