<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

</tr>
<tr>
<td height=100%>

<table height=100% cellpadding=0 cellspacing=0 border=0 class="outline_both" style="width:1100px;margin:0 auto ; padding:30px 0;">
<tr>
<td valign=top width=100% height=100% bgcolor="" background="" class=outline_side>

<!-- ����̹��� || ������ġ -->
<div class="sub_tit">
  <div class="tit">ȸ������<span>/ JOIN US</span></div>
  <div class="local">Ȩ > ȸ������ > <span>�������ۼ�</span></div>
</div>


<div class="indiv" style="width:1100px; margin:0 auto;"><!-- Start indiv -->

<script src="js/godo.password_strength.js" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">

	function IdConfirm(join) {
    	var m_id = document.join.M_id.value;
    	var url = "idCheck.action?m_id="+m_id;
    	
    	if(m_id ==""){
       		alert("���̵� �Է����ּ���!")
       		document.join.M_id.focus();
    	}else{
    		open(url, "IdConfirm", "toolbar=no,location=no,status=no,menubar=no,"+
          	"scrollbars=no,resizable=no,width=400,height=600");

    		}
 }
   
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

                // �� �ּ��� ���� ��Ģ�� ���� �ּҸ� �����Ѵ�.
                // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
                var fullAddr = ''; // ���� �ּ� ����
                var extraAddr = ''; // ������ �ּ� ����

                // ����ڰ� ������ �ּ� Ÿ�Կ� ���� �ش� �ּ� ���� �����´�.
                if (data.userSelectedType === 'R') { // ����ڰ� ���θ� �ּҸ� �������� ���
                    fullAddr = data.roadAddress;

                } else { // ����ڰ� ���� �ּҸ� �������� ���(J)
                    fullAddr = data.jibunAddress;
                }

                // ����ڰ� ������ �ּҰ� ���θ� Ÿ���϶� �����Ѵ�.
                if(data.userSelectedType === 'R'){
                    //���������� ���� ��� �߰��Ѵ�.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // �ǹ����� ���� ��� �߰��Ѵ�.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // �������ּ��� ������ ���� ���ʿ� ��ȣ�� �߰��Ͽ� ���� �ּҸ� �����.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
                document.getElementById('sample6_postcode').value = data.zonecode; //5�ڸ� �������ȣ ���
                document.getElementById('sample6_address').value = fullAddr;

                // Ŀ���� ���ּ� �ʵ�� �̵��Ѵ�.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>



<style type="text/css">
div.passwordStrenth {background-color:#FFFFFF; border:1px #CCCCCC solid; padding:10px; width:263px;display:none; position:absolute;}

div.passwordStrenth p {margin:0;padding:5px 0 0 0; font-size:11px;color:#616161; }

div.passwordStrenth dl {margin:0;padding:0 6px 0 0;color:#373737; font-weight:bold;font-size:11px;  }
div.passwordStrenth dl dt,
div.passwordStrenth dl dd {display:inline;font-size:11px; margin:0;height:15px;line-height:15px;}

div.passwordStrenth dl dt {color:#363636; font-weight:bold; width:95px;}

div.passwordStrenth dl dd {text-indent:0px;font-size:12px; width:110px;background:url('images/password_level.gif') no-repeat top left;}
div.passwordStrenth dl dd.lv0 {color:#F52D00;background-position:20px 0;}
div.passwordStrenth dl dd.lv1 {color:#F52D00;background-position:20px -29px;}
div.passwordStrenth dl dd.lv2 {color:#F52D00;background-position:20px -44px;}
div.passwordStrenth dl dd.lv3 {color:#F52D00;background-position:20px -59px;}
div.passwordStrenth dl dd.lv4 {color:#F52D00;background-position:20px -59px;}

</style>

<style>
.memberCols1 {
width:80px;
text-align:right;
padding-right:15px;
color:#414141; font-weight:bold;
letter-spacing:-1;
}
.memberCols2 {
text-align:left;
}
.memberCols3 {
width:100px;
color:#5D5D5D;
letter-spacing:-1;
}
.scroll   {
scrollbar-face-color: #FFFFFF;
scrollbar-shadow-color: #AFAFAF;
scrollbar-highlight-color: #AFAFAF;
scrollbar-3dlight-color: #FFFFFF;
scrollbar-darkshadow-color: #FFFFFF;
scrollbar-track-color: #F7F7F7;
scrollbar-arrow-color: #838383;
}
#boxScroll{width:96%; height:130px; overflow: auto; BACKGROUND: #ffffff; COLOR: #585858; font:9pt;border:1px #dddddd solid; overflow-x:hidden;text-align:left; }

#pwdManual { border:2px solid #BFBFBF; display:none; position:absolute; width:410px; background:#ffffff;margin-top:10px; }
#pwdManual p { background:#F1F1F1 url('images/blt_tip_gr.gif') no-repeat 10px center;margin:0;padding:12px 10px 12px 50px;color:#373737;font-weight:bold;}
#pwdManual p.close { background:none;padding:0px 10px 5px 0;margin:0;text-align:right;}
#pwdManual ul {list-style:none;margin:0;padding:15px;}
#pwdManual ul li {color:#6E6E6E; font-size:11px; line-height:17px;letter-spacing:-1px;}

#ipinManual { border:2px solid #BFBFBF; display:none; position:absolute; width:560px; z-index:999; }
#ipinManual .ipinmTop { background-color:#F1F1F1; color:#373737; font-weight:bold; padding:7px; }
#ipinManual .ipinmBottom { background-color:#FFFFFF; padding:10px 0px; }
#ipinManual .ipinmBottom .ipinmbText { color:#6E6E6E; font-size:11px; line-height:17px; margin-left:20px; }
#ipinManual .ipinmBottom .ipinmbText a { color:#6E6E6E; font-size:11px; font-weight:bold; line-height:17px; }
#ipinManual .ipinmBottom .ipinmbDotted { border-top:1px dotted #C0C0C0; margin:10px 20px; }
#ipinManual .ipinmBottom .ipinmbSolid { border-top:1px solid #C0C0C0; margin:10px 20px; }
#ipinManual .ipinmBottom .ipinmbTerm { margin:10px 20px; }
#ipinManual .ipinmBottom .ipinmbButton { margin:15px 10px 5px 10px; text-align:center; }
</style>



<!-- ���̹�üũ�ƿ�(ȸ������) -->


<div class="sub_tit2">
<span class="tit">����ȸ��<span>����</span></span></div>

    <table width=100% cellpadding=0 cellspacing=0>
    <tr>
    <td style="padding:10px; border:1px solid #dedede; background-color:#fbfbfb;" align=center>
    
    
    
   <style>
    .jogin_infotbl caption{display:none;}
    .jogin_infotbl {border-collapse:collapse;border-spacing:0;width:100%;}
    .jogin_infotbl th{ border-bottom:#e7e7e7 solid 1px;height:39px;text-indent:20px; color:#414141; font-weight:bold;}
    .jogin_infotbl td{ border-bottom:#e7e7e7 solid 1px;height:39px;}
    .jogin_infotbl td input[type=text],.jogin_infotbl td input[type=password]{ min-width:50px;height:23px; line-height:23px; box-sizing:content-box; border:1px solid #dedede;}
    .jogin_infotbl td textarea { height:100px; line-height:18px;  box-sizing:content-box; border:1px solid #dedede;}
    </style>
 <form action="joinPro.action" method="post" enctype="multipart/form-data" name="join">
    <table width=97% cellpadding=5 cellspacing=0 border=0 class="jogin_infotbl">
    <tr>
        <td class=memberCols1><font color=FF6000>*</font> ���̵�</td>
        <td class=memberCols2>
        <input type=text name=M_id value="" style="background:#FFF" maxlength=16 required fld_esssential option=regId label="���̵�">
       <!--  <input type=hidden name=M_id required fld_esssential label="���̵��ߺ�üũ"> -->
       	<sapn onclick="javasript:IdConfirm(this.form)"><img src="images/join_btn_id.jpg" border=0 align=absmiddle/></sapn>
        <div class="description_wrap" style="font-size: 11px;color: #8d8d8d;">
               <div class="description">6~16���� ������, ��������</div>
               <div class="description wrong" id="id_description">���̵�� 6�� �̻����� �Է��� �ּ���</div>
            </div>
        </td>
    </tr>
    <tr>
        <td class=memberCols1><font color=FF6000>*</font> ��й�ȣ</td>
        <td class=memberCols2>
        <input type=password name=M_pass required fld_esssential option=regPass label="��й�ȣ" style="background:#FFF" >
       <div class="description" id="el-password-strength-indicator-msg"style="font-size: 11px;color: #8d8d8d;">10~16���� ������, ��������</div> 
        </td>
    </tr>
    

    
    <tr>
        <td class=memberCols1><font color=FF6000>*</font> �̸�</td>
        <td class=memberCols2>
        <input type=text name=M_name value="" required fld_esssential label="�̸�" style="background:#FFF">
        </td>
    </tr>
    
    <tr>
        <td class=memberCols1><font color=FF6000>*</font> ����</td>
        <td class=memberCols2><span class=noline>
        <input type=radio name=M_sex required fld_esssential label="����" value="m" checked> ����
        <input type=radio name=M_sex required fld_esssential label="����" value="w" > ����
        </span></td>
    </tr>
    
    <tr>
        <td class=memberCols1><font color=FF6000>*</font> �������</td>
        <td class=memberCols2>
        <input type=text name=M_year value="" required fld_esssential label="�������" style="background:#FFF" size=4 maxlength=4>��
        <input type=text name=M_month value="" required fld_esssential label="�������" style="background:#FFF" size=2 maxlength=2>��
        <input type=text name=M_date value="" required fld_esssential label="�������" style="background:#FFF" size=2 maxlength=2>��
    
    
        </td>
    </tr>
    
    
    
    
    <tr>
        <td class=memberCols1><font color=FF6000>*</font> �̸���</td>
        <td class=memberCols2>
        <input type=text name=M_email value="" size=30 required fld_esssential option=regEmail label="�̸���" style="background:#FFF">
      <input type=hidden name=chk_email required fld_esssential >        </a>
        <span class=noline style="padding-left:10px"></span>
       
        <div class="description "style="font-size: 11px;color: #8d8d8d;">
                  �� ���̵� / ��й�ȣ ã�⿡ Ȱ�� �ǹǷ� ��Ȯ�ϰ� �Է��� �ּ���.
               </div>
        </td>
    </tr>
    
    
    <tr>
        <td class=memberCols1><font color=FF6000>*</font> �ּ�</td>
   <td class="memberCols2">

   <table>
   <tr>
      <td>
      <input type="text" name="M_zipcode" id="sample6_postcode" placeholder="�����ȣ">
      <input type="button" onclick="sample6_execDaumPostcode()" value="�����ȣ ã��"><br>
      <input type="text" name="M_addr1" id="sample6_address" placeholder="�ּ�">
      <input type="text" name="M_addr2" size=30  id="sample6_address2" placeholder="���ּ�">
            </td>
        </tr>
        </table>
    
        </td>
    </tr>
    
    
    <tr>
        <td class=memberCols1><font color=FF6000>*</font> �ڵ���</td>
        <td class=memberCols2>
   <input type=text name=M_phone value="" size=12 maxlength=15 required fld_esssential option=regNum label="�ڵ���" >
   <span class=noline style="padding-left:10px"></span>
   </td>
</tr>
    




</table>

</td>
</tr>
</table>

<table width=100% cellpadding=0 cellspacing=0 border=0>
<tr>
<td id=avoidDbl align=center height=100>
<div style="width:100%" class=noline>
    <input type=image src="images/btn_join.jpg" >
    <img src="images/btn_prev.jpg" border=0 onClick="history.back()" style="cursor:pointer;">
</div>
</td>
</tr>
</table>

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