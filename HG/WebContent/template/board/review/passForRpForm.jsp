<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</tr>
<tr>
<td >

<table cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
<tr>

<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>



<!-- 상단이미지 || 현재위치 -->
<div class="sub_tit">
  <div class="tit">ID 찾기<span>/ FIND ID</span></div>
  <div class="local">홈 > 마이페이지 > 회원정보수정> <span>ID찾기</span></div>
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

<script type="text/javascript">
function modifyPass(fm){
   var rv_pass = document.fm.rv_pass.value;
   var url = "reviewModifyForm.action?rv_pass="+rv_pass;
}

</script>
<div class="indiv"><!-- Start indiv -->


<form method=post name=fm action="reviewModifyForm.action" enctype="multipart/form-data">


<div class="findbox">
          <ul>
            <li><span>현재 비밀번호</span>
              <input name="rv_pass" type="text" size="29" required label="비밀번호" tabindex=2 class="fm">
            </li>
            <li><span></span>
            <sapn onclick="javasript:modifyPass(this.form)">
              <input type=image src="images/find_scbtn.jpg" tabindex=6></sapn>
            </li>
       
          </ul>
          
    </div>

   

  
  
</form>

    

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