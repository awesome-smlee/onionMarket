<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<style>
	img {
	  width: 300px;
	  height: 150px;
	  object-fit: cover;
	}
</style>

<jsp:include page="${_resource}"/>

<h1>파일 이미지 뷰</h1>

<ul id="list">
</ul>




<script>
	let imageHTML = `
		<li>
			<img>
			<table>
			<tbody>
				<tr>
					<td>파일명</td>
					<td id="name"></td>
				</tr>
				<tr>
					<td>확장자</td>
					<td id="extension"></td>
				</tr>
				<tr>
					<td>파일크기</td>
					<td id="size"></td>
				</tr>
				<tr>
					<td>최근수정일</td>
					<td id="lastModified"></td>
				</tr>
				<tr>
					<td>버튼</td>
					<td>
						<button id="delete_btn">삭제</button>
					</td>
				</tr>
			</tbody>
			</table>
		</li>
	`;
	
	
	let data = _util.ajax(_ctx + '/fileList', {});
	data.forEach((e) => {
		console.log(e);
		
		let html = $(imageHTML);
		html = html.find('img').prop('src', _ctx + '/imageView?stored_nm=' + e.stored_nm).end();
		html = html.find('#name').text(e.upload_nm).end();
		html = html.find('#extension').text(e.extension).end();
		html = html.find('#size').text(e.file_size.toFileSizeString()).end();
		html = html.find('#lastModified').text(new Date(e.ins_dt).toDateString()).end();
		
		
		$('#list').append(html);	
		
	});
</script>