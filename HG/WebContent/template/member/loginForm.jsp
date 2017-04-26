<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</tr>
<tr>
<td>

<table cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
<tr>
<td valign=top width=100% bgcolor="" background="" class=outline_side>

<script>
window.onload = function(){ document.form.m_id.focus(); }
</script>

<!-- 상단이미지 || 현재위치 -->
<div class="sub_tit">
  <div class="tit">로그인<span>/ MEMBER LOGIN</span></div>
  <div class="local">홈 > <span>로그인</span></div>
</div>
<style>
.loginbox{float:left; width:100%; margin:29px 0  }
.loginbox input , .nomembox input { margin:0 !important;background-color:transparent !important;}
/*로그인폼*/
.loginbox .box{float:left; width:470px; height:198px; padding:0 25PX; margin:0 4px 15px 11px;border:1PX solid #e5e5e5; }
.loginbox .boxbg{background-color:#f5f5f5;}
.loginbox .box .tit{ width:100%; height:20px; text-align:left; margin:31PX 0 24px 0;}
.loginbox .box .form{float:left; width:466px; height:89px; position:relative;}
.loginbox .box .form ul{ float:left;width:330px; margin:0; padding:0;}
.loginbox .box .form ul li{display:list-item; list-style:none; width:100%; height:40px; margin-bottom:9px;}
.loginbox .box .form ul li span{ float:left;width:60px;  text-align:right;height:40px; line-height:40px; color:#9b9b9b; padding-right:10px;}
.loginbox .box .form ul li input{ width:258px; height:38px;line-height:38px; border:1px solid #d6d6d6 !important; color:#4c4c4c; background-color:#fff !important;}
.loginbox .box .form .btn{ position:absolute; right:0; top:0; width:130px; height:90px; border:none !important;}  
/*회원가입등 기타*/
.loginbox .box .txt{ float:left; width:335px; height:100px;}
.loginbox .box .txt img{margin-top:10px;}
.loginbox .box .gobtn{float:left; width:130px; height:100px; cursor:pointer;}
/*사이드박스*/
.sidebox{width:250px; height:18px; float:left; margin:7px 0 0 74px;}
.sidebox .acc{float:left;line-height:18px;height:18px;}
.sidebox .acc img{ margin-top:4px;}
.sidebox .side{ float:right; margin:0;}
.sidebox .side li{display:inline; float:left; padding-left:8px; margin-left:16px; height:18px; line-height:18px; background:url(/shop/data/skin/standard_C/dsm/img/all/dot2.jpg) left center no-repeat;}
.sidebox .side li a{color:#4c4c4c; text-decoration:none;}

</style>
<div class="indiv"> 
  <!-- Start indiv -->
  <div class="loginbox"> 
    <!--로그인폼시작-->
    <div class="box boxbg">
      <div class="tit"><img src="../../images/login_1_tit.jpg"></div>
     <form action="logInPro.action" method="post" enctype="multipart/form-data">
        <input type=hidden name=returnUrl value="http://www.wondergreen.kr/shop/main/index.php?&">
        <div class="form">
          <ul>
            <li><span>아이디</span>
              <input type=text name=M_id size=20 tabindex=1>
            </li>
            <li style="margin:0;"><span>비밀번호</span>
              <input type=password name=M_pass size=20 tabindex=2>
            </li>
          </ul>
          <input type=image src="../../images/login_1_btn.jpg" class="btn">
        </div>
      </form>
      <div class="sidebox"> 
        <div class="acc"><img src="../../images/login_1_icon.jpg"></div>
        <ul class="side">
          <li><a HREF="/shop/member/find_id.php?&" onFocus="blur()">아이디 찾기</a></li>
          <li><a HREF="/shop/member/find_pwd.php?&" onFocus="blur()">비밀번호 찾기</a></li>
        </ul>
      </div>
    </div>
    <!--로그인폼끝--> 
    
    <!--가입폼시작-->
   
   
   
   
   
    <div class="box">
      <div class="tit"><img src="../../images/login_2_tit.jpg"></div>
      <div class="txt"><img src="../../images/login_2_txt.jpg"></div>
      <div class="gobtn"><a href="/shop/member/join.php?&"><img src="../../images/login_2_btn.jpg"></a></div>
    </div>
    <!--가입폼끝--> 
    
 
 
   
 
    

		
	
	
</div>
<!-- End indiv --> 

</td>
 
<td width=0 id=pos_scroll valign=top> 
  
  <!-- 스크롤 배너 -->
  
 

 


</td>
 
</tr>
</table>
</td>
</tr>
<tr>
  <td> 