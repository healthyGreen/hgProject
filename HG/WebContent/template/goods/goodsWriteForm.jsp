<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<script language="javascript" type="text/javascript" src="js/index.js">

</script>
<script language="javascript" type="text/javascript"
	src="js/jquery-1.6.4.js"></script>
<script type="text/javascript">
function validation(){
	var frm=document.goodsWrite;
	
	if(frm.g_name.value==""){
		alert("상품명을 입력해주세요.");
		return false;
	}
	else if(frm.g_price.value==""){
		alert("가격을 입력해주세요.");
		return false;
	}
	
	else if(frm.g_size.value==""){
		alert("크기를 입력해주세요.");
		return false;
	}
	else if(frm.g_amount.value==""){
		alert("수량을 입력해주세요.");
		return false;
	}
	else if(frm.g_content.value==""){
		alert("내용을 입력해주세요.");
		return false;
	}
}
</script>


<title>Insert title here</title>
</head>
<body>
	<form action="goodsWritePro.action" method="post" encType="multipart/form-data">
		<table width="100%" class="board-type03"
			style="width: 1100px; margin: 0 auto;">
			<colgroup>
				<col width="" />
				<col width="" />
			</colgroup>
			<tbody>

				<tr class="first">
					<th scope="row">상품이름</th>
					<td>
						<div>
							<input type="text" class="input1 write-box" name="g_name" />
						</div>
					</td>
				</tr>
				<tr class="">
					<th scope="row">상품가격</th>
					<td>
						<div>
							<input type="text" class="input1 write-box" name="g_price" />
						</div>
					</td>
				</tr>
				<tr class="">
					<th scope="row">상품카테고리</th>
					<td>
						<div>
							<select name="g_category">
								<option value="chacJeb">착즙주스키트</option>
								<option value="smoothy">스무디키트</option>
								<option value="salad">샐러드</option>
								<option value="superFood">슈퍼푸드</option>
								<option value="fruit">하루과일칩</option>
								<option value="giftSet">선물세트</option>
								<option value="water">REFRESH WATER</option>
							</select>
						</div>
					</td>
				</tr>
				<tr class="">
					<th scope="row">상품정보</th>
					<td>
						<div>
							<input type="text" class="input1 write-box" name="g_info" />
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="vertical-t">상품내용</th>
					<td>
						<div class="input3">
							<textarea name="g_content" cols="30" rows="10" width="100%; "></textarea>
						</div>
					</td>
				</tr>
				<tr class="">
					<th scope="row">상품재료</th>
					<td>
						<div>
							<input type="text" class="input1 write-box" name="g_ingr" />
						</div>
					</td>
				</tr>
				<tr class="">
					<th scope="row">상품재고량</th>
					<td>
						<div>
							<input type="text" class="input1 write-box" name="g_jaegoAmount" />
						</div>
					</td>
				</tr>
				<tr class="">
					<th scope="row">상품이미지</th>
					<td>
						<div>
							<input type="file" class="input1 write-box" name="upload" /> &nbsp;
							<input type="file" class="input1 write-box" name="upload" />
						</div>
					</td>
				</tr> 
			


				<!-- <div id="main_content">

					<table width="600" align="center">
						<tr>
							<td align="center">상품 등록</td>
						</tr> -->
					</table>

				 	<%-- <s:if test="goods_resultClass == null">
						<form name="goodswrite" action="goodsWrite.action" method="post"
							enctype="multipart/form-data" onsubmit="return validation()">
							<s:hidden name="currentPage" value="%{currentPage}" />
							<s:hidden name="old_file"
								value="%{goods_resultClass.goods_sav_image}" />
					</s:if>

					<s:else>
						<form name="goodswrite" action="goodsDelete.action" method="post"
							enctype="multipart/form-data" onsubmit="return validation()">
							<s:hidden name="goods_num" value="%{goods_resultClass.goods_num}" />
							<s:hidden name="currentPage" value="%{currentPage}" />
							<s:hidden name="old_file"
								value="%{goods_resultClass.goods_sav_image}" />
					</s:else>  --%>

					<%-- <table align="center" width="600">
						<tr>
							<td align="right" colspan="2"><font color="#FF0000">*</font>는
								필수 입력 사항입니다.</td>
						</tr>

						<tr bgcolor="#777777">
							<td height="1" colspan="2"></td>
						</tr>

						<tr>
							<td width="100" bgcolor="#F4F4F4"><font color="#FF0000">*</font>category</td>
							<td width="500" bgcolor="#FFFFFF"><select
								name="goods_category" size="1" />
								<option value="outer">겉옷</option>
								<option value="top">상의</option>
								<option value="blouse">브라우스</option>
								<option value="pants">바지</option>
								<option value="skirts">치마</option>
								<option value="bag">가방</option>
								<option value="shoes">신발</option> </select></td>
						</tr>

						<tr>
							<td width="100" bgcolor="#F4F4F4"><font color="#FF0000">*</font>상품명</td>
							<td width="500" bgcolor="#FFFFFF"><input class="input"
								type="text" name="g_name"
								value="<s:property value="goods_resultClass.g_name"/>" size="20"
								maxlength="50" /></td>
						</tr>
						<tr>
							<td bgcolor="#F4F4F4" width="100"><font color="#FF0000">*</font>판매가</td>
							<td bgcolor="#FFFFFF" width="500"><input class="input"
								type="text" name="g_price"
								value="<s:property value="goods_resultClass.g_price"/>"
								size="15" maxlength="15" style="ime-mode: Disabled;"
								onKeyPress="checknum()" /></td>
						</tr>


						<tr>
							<td bgcolor="F4F4F4" width="100"><font color="#FF0000">*</font>수량</td>
							<td bgcolor="#FFFFFF" width="500"><input class="input"
								type="text" name="g_amount"
								value="<s:property value="goods_resultClass.g_amount"/>"
								size="15" maxlength="15" style="ime-mode: Disabled;"
								onKeyPress="checknum()" /></td>
						</tr>



						<tr>
							<td bgcolor="F4F4F4" width="100"><font color="#FF0000">*</font>내용</td>
							<td bgcolor="#FFFFFF" width="500"><textarea name="g_content"
									cols="50" rows="10"><s:property
										value="goods_resultClass.g_content" /></textarea></td>
						</tr>

						<tr>
							<td bgcolor="#F4F4F4" width="100">첨부파일(main)</td>
							<td bgcolor="#FFFFFF" width="500"><s:file name="upload"
									theme="simple" /> <s:if
									test="goods_resultClass.g_sav_image != null">
					&nbsp;*<s:property value="goods_resultClass.g_sav_image" />파일이 등록되어 있습니다.
				</s:if></td>
						</tr>
						<tr>
							<td bgcolor="#F4F4F4" width="100">첨부파일(detail1)</td>
							<td bgcolor="#FFFFFF" width="500"><s:file name="upload"
									theme="simple" /></td>
						</tr>

						<tr>
							<td bgcolor="#F4F4F4" width="100">첨부파일(detail2)</td>
							<td bgcolor="#FFFFFF" width="500"><s:file name="upload"
									theme="simple" /></td>
						</tr>


						<tr>
							<td align="right" colspan="2"><input name="submit"
								type="submit" value="" class="write"> <input name="list"
								type="button" value="" class="list"
								onClick="javascript:location.href='goodsWrite.action?currentPage=<s:property value="currentPage"/>'">
								</input></td>
						</tr>
					</table> --%>
				</div>

				<div id="sub_content"></div>

				<%-- <div id="footer">
					<jsp:include page="/template/footer.jsp" />
				</div> --%>

				
				<input type=submit value="등록">


			</tbody>
		</table>
		</form>
</body>
</html>