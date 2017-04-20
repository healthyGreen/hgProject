<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</tr>
<tr>
<td >

<table cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
<tr>

<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>

<script language="javascript">
function goIDCheckIpin()
{
	var fm ;
	fm = document.getElementById("form");
	var popupWindow = window.open( "", "popupCertKey", "width=450, height=550, top=100, left=100, fullscreen=no, menubar=no, status=no, toolbar=no, titlebar=yes, location=no, scrollbar=no" );
	return;
}

function gohpauthDream(){ //휴대폰본인인증
	var protocol = location.protocol;
	var callbackUrl = "https://www.wondergreen.kr:14035/shop/member/hpauthDream/hpauthDream_Result.php";
	ifrmHpauth.location.href=protocol+"//hpauthdream.godo.co.kr/module/NEW_hpauthDream_Main.php?callType=findid&shopUrl="+callbackUrl+"&cpid=godowond";
	return;
}
</script>

<!-- 상단이미지 || 현재위치 -->
<div class="sub_tit">
  <div class="tit">ID 찾기<span>/ FIND ID</span></div>
  <div class="local">홈 > 마이페이지 > <span>ID찾기</span></div>
</div>

<style>
.findbox{width:450px; margin:10px auto;}
.findbox ul{ float:left;width:450px; margin:0; padding:0;}
.findbox ul li{display:list-item; list-style:none; text-align:center; width:100%; line-height:40px; margin-bottom:9px;}
.findbox ul li.txt{text-align:center; line-height:20px !important; padding:30px 0; font-size:15px; font-weight:bold;}
.findbox ul li.txt span{height:100px; line-height:100px;}
.findbox ul li span{ float:left;width:60px;  text-align:right; height:40px; line-height:40px; color:#9b9b9b; padding-right:10px;}
.findbox ul li input.fm{ width:328px; height:38px;line-height:38px; border:1px solid #d6d6d6 !important; color:#4c4c4c; background-color:#fff !important;}
.findbox ul li a{ margin-right:7px;}
.findbox .btn{ position:absolute; right:0; top:0; width:130px; height:90px; border:none !important;}  
</style>

<div class="indiv"><!-- Start indiv -->


<form method=post name=fm action="" >


<div class="findbox">
          <ul>
            <li><span>이름</span>
              <input name="srch_name" type="text" size="29" required label="이름" tabindex=2 class="fm">
            </li>
            <li><span>이메일</span>
              <input name="srch_mail" type="text" size="29" required label="메일주소" tabindex=5 class="fm">
            </li>
            <li><span></span>
              <input type=image src="../../images/find_scbtn.jpg" tabindex=6>
            </li>
       
          </ul>
          
    </div>

	

  
  
</form>

		<div class="findbox">
          <ul>
            <li><span></span>
              <a href="/shop/member/find_pwd.php?&"><img src="../../images/find_pw.jpg"></a>
				<a href="/shop/member/login.php?&"><img src="../../images/find_login.jpg"></a>
            </li>
          </ul>
          
    </div>


</div><!-- End indiv -->

</td>
 
<td width=0 id=pos_scroll valign=top> 
  

</td>
 
</tr>
</table>
</td>
</tr>
<tr>
  <td> 