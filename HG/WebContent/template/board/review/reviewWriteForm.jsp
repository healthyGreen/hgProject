<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
	function reviewcheck(reviewWrite) {
		if (!document.reviewWrite.rv_name.value) {
			alert("작성자를 입력하세요");
			document.reviewWrite.rv_name.focus();
			return false;
		}
		if (!document.reviewWrite.rv_title.value) {
			alert("제목을 입력하세요");
			document.reviewWrite.rv_title.focus();
			return false;
		}
		if (!document.reviewWrite.rv_content.value) {
			alert("후기내용을 입력하세요");
			document.reviewWrite.rv_content.focus();
			return false;
		}
		
		if (!document.reviewWrite.rv_pass.value) {
			alert("비밀번호를 입력하세요");
			document.reviewWrite.rv_pass.focus();
			return false;
		}
		
	}
	</script>
<div class="sub_tit" style="width:1100px;margin:0 auto ; padding:30px 0;">
	  <div class="tit">후기<span>/ PRODUCT REVIEW</span></div>
	  <div class="local">홈 > <span>상품후기</span></div>
	</div>

	<s:if test="resultClass.getRv_number() != null">
		<form name="reviewWrite" method="post" enctype="multipart/form-data" onsubmit="return reviewcheck()" action="reviewModifyPro.action?rv_number=<s:property value="resultClass.getRv_number()"/>&currentPage=<s:property value="currentPage"/>">
		<table width="100%" class="board-type03" style="width:1100px;margin:0 auto ;">
					<colgroup>
						<col width="" />
						<col width="" />
					</colgroup>
					<tbody>
						
						<tr class="first">
							<th scope="row">
								제목
							</th>
							<td>
								<div><input type="text" class="input1 write-box" name="rv_title"  value="<s:property value="resultClass.rv_title"/>"/></div>
							</td>
						</tr>
						<tr class="">
							<th scope="row">
								작성자
							</th>
							<td>
								<div><input type="text" class="input1 write-box" name="rv_name" value="<s:property value="resultClass.rv_name"/>"/></div>
							</td>
						</tr>
						<tr class="">
							<th scope="row">
								비밀번호
							</th>
							<td>
								<div><input type="text" class="input1 write-box"  name="rv_pass" value="<s:property value="resultClass.rv_pass"/>"/></div>
							</td>
						</tr>
						<tr>
							<th scope="row" class="vertical-t">
								후기내용
							</th>
							<td>
								<div class="input3">
									<textarea id="" cols="30" rows="10" width="100%; " name="rv_content"><s:property value="resultClass.rv_content" /></textarea>
								</div>
							</td>
						</tr>
						<tr class="">
							<th scope="row">
								첨부파일
							</th>
							<td>
								<input type="hidden" name="rv_old_file" value="<s:property value="resultClass.rv_sav_image" />" />
								<input class="filename" type="file" name="upload">
								<s:if test="resultClass.rv_sav_image != null">
								&nbsp;*<s:property value="resultClass.rv_sav_image" /><br>&nbsp;&nbsp;변경시 기존의 파일은 삭제됩니다
								</s:if>
								<s:else>
								&nbsp;&nbsp;파일 크기는 3Mb로 제한됩니다
								</s:else>	
							</td>
						</tr>
					</tbody>
				</table>
				<div class="wBtn clear" ><input type="submit" value="수정완료" /></div>
			</form>
		</s:if>	
		<s:else>
			<form name="reviewWrite" method="post" enctype="multipart/form-data" action="reviewWritePro.action" onsubmit="return reviewcheck()">
				<table width="100%" class="board-type03" style="width:1100px;margin:0 auto ;">
					<colgroup>
						<col width="" />
						<col width="" />
					</colgroup>
					<tbody>
						
						<tr class="first">
							<th scope="row">
								제목
							</th>
							<td>
								<div><input type="text" class="input1 write-box" id="" name="rv_title" /></div>
							</td>
						</tr>
						<tr class="">
							<th scope="row">
								작성자
							</th>
							<td>
								<div><input type="text" class="input1 write-box" id="" name="rv_name"/></div>
							</td>
						</tr>
						<tr class="">
							<th scope="row">
								비밀번호
							</th>
							<td>
								<div><input type="text" class="input1 write-box" id="" name="rv_pass"/></div>
							</td>
						</tr>
						<tr>
							<th scope="row" class="vertical-t">
								후기내용
							</th>
							<td>
								<div class="input3">
									<textarea name="rv_content" id="" cols="30" rows="10" width="100%; "></textarea>
								</div>
							</td>
						</tr>
						<tr class="">
							<th scope="row">
								첨부파일
							</th>
							<td>
								<div><input class="filename" type="file" name="upload">&nbsp;&nbsp;파일 크기는 3Mb로 제한됩니다</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="wBtn clear" ><input type="submit" value="공지등록" class="wBtn"/></div>
			 </form>
		</s:else>	
				
						

</td>
 
</tr>
</table>
</td>
</tr>
<tr>
  <td> 