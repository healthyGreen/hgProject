<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
	function noticecheck(noticeWrite) {
		if (!document.noticeWrite.n_name.value) {
			alert("�ۼ��ڸ� �Է��ϼ���");
			document.boardWrite.n_name.focus();
			return false;
		}
		if (!document.noticeWrite.n_title.value) {
			alert("������ �Է��ϼ���");
			document.boardWrite.n_title.focus();
			return false;
		}
		if (!document.noticeWrite.n_content.value) {
			alert("������ �Է��ϼ���");
			document.boardWrite.n_content.focus();
			return false;
		}
		
	}
	</script>
	
	
<div class="sub_tit" style="width:1100px;margin:0 auto ; padding:30px 0;">
	  <div class="tit">��������<span>/ NOTICE</span></div>
	  <div class="local">Ȩ > <span>��������</span></div>
	</div>

<s:if test="resultClass.getN_number() != null">
	<form name="noticeWrite" method="post" enctype="multipart/form-data" onsubmit="return noticecheck()" 
	action="noticeModifyPro.action?n_number=<s:property value="resultClass.getN_number()"/>&
	currentPage=<s:property value="resultClass.getCurrentPage()"/>">
		<table width="100%" class="board-type03" style="width:1100px;margin:0 auto ;">
					<colgroup>
						<col width="" />
						<col width="" />
					</colgroup>
					<tbody>
						
						<tr class="first">
							<th scope="row">
								����
							</th>
							<td>
								<div><input type="text" class="input1 write-box" name="n_title"  value="<s:property value="resultClass.n_title"/>"/></div>
							</td>
						</tr>
						<tr class="">
							<th scope="row">
								�ۼ���
							</th>
							<td>
								<div><s:property value="resultClass.n_name"/></div>
							</td>
						</tr>
						
						<tr>
							<th scope="row" class="vertical-t">
								��������
							</th>
							<td>
								<div class="input3">
									<textarea name="n_content" cols="30" rows="10" width="100%; "><s:property value="resultClass.n_content" /></textarea>
								</div>
							</td>
						</tr>
						
					</tbody>
				</table>
				<div class="wBtn clear" ><input type="submit" value="�����Ϸ�" /></div>
			</form>
		</s:if>	
		<s:else>
			<form name="noticeWrite" method="post" enctype="multipart/form-data" action="noticePro.action" onsubmit="return noticecheck()">
				<table width="100%" class="board-type03" style="width:1100px;margin:0 auto ;">
					<colgroup>
						<col width="" />
						<col width="" />
					</colgroup>
					<tbody>
						
						<tr class="first">
							<th scope="row">
								����
							</th>
							<td>
								<div><input type="text" class="input1 write-box" name="n_title" /></div>
							</td>
						</tr>
						<tr class="">
							<th scope="row">
								�ۼ���
							</th>
							<td>
								<div><input type="text" class="input1 write-box" name="n_name" /></div>
							</td>
						</tr>
						
						<tr>
							<th scope="row" class="vertical-t">
								��������
							</th>
							<td>
								<div class="input3">
									<textarea name="n_content" id="" cols="30" rows="10" width="100%;" ></textarea>
								</div>
							</td>
						</tr>
						
					</tbody>
				</table>	
				<div class="wBtn clear" ><input type="submit" value="�������" class="wBtn"/></div>
			</form>
		</s:else>	
				
			

 
						

</td>
 
</tr>
</table>
</td>
</tr>
<tr>
  <td> 