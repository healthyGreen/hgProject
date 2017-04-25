<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
	function boardcheck() {
		if (!document.boardWrite.n_name.value) {
			alert("작성자를 입력하세요");
			document.boardWrite.n_name.focus();
			return false;
		}
		if (!document.boardWrite.n_title.value) {
			alert("제목을 입력하세요");
			document.boardWrite.n_title.focus();
			return false;
		}
		if (!document.boardWrite.n_content.value) {
			alert("내용을 입력하세요");
			document.boardWrite.n_content.focus();
			return false;
		}
		
	}
	</script>
	
	
<div class="sub_tit" style="width:1100px;margin:0 auto ; padding:30px 0;">
	  <div class="tit">공지사항<span>/ NOTICE</span></div>
	  <div class="local">홈 > <span>공지사항</span></div>
	</div>


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
							<div><input type="text" class="input1 write-box" id="" /></div>
						</td>
					</tr>
					<tr class="">
						<th scope="row">
							작성자
						</th>
						<td>
							<div><input type="text" class="input1 write-box" id="" /></div>
						</td>
					</tr>
					
					<tr>
						<th scope="row" class="vertical-t">
							공지내용
						</th>
						<td>
							<div class="input3">
								<textarea name="" id="" cols="30" rows="10" width="100%; "></textarea>
							</div>
						</td>
					</tr>
					<tr class="">
						<th scope="row">
							첨부파일
						</th>
						<td>
							<div><input type="text" class="input1 write-box" id="" /></div>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="wBtn clear" ><span>공지등록</span></div>

 
						

</td>
 
</tr>
</table>
</td>
</tr>
<tr>
  <td> 