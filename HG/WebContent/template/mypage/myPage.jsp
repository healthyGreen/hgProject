<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String session_id=(String)session.getAttribute("session_id"); %>

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
      .btnBox input{ width: 24%; }
      
   </style>
   <div class="mypage" style="width: 1100px; margin: 0 auto;">
      <div class="box1 clear">
         <div class="grade">
         <a href="/HG/myInfoView.action"><img src="../../images/grade.png" alt="" /><span>회원정보보기</span></div></a>
         <div class="myCont">
            <ul>
               <li><span>hg1212</span></li>
               <li><span>장바구니(1)</span></li>
               <li><span>홍길동</span></li>
               <li><span>적립금(1000)</span></li>
            </ul>
         </div>
         <div class="btnBox">
            <input type="button" onclick="location.href='basketList.action?session_id='+<%=session_id %>" value="장바구니">
            <input type="button" onclick="" value="내가 쓴 글">
            <input type="button" onclick="" value="나의 주문 내역">
            <input type="button" onclick="location.href='myInfoView.action?session_id='+<%=session_id %>" value="개인 정보 보기">
         </div>
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