<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>


<jsp:include page="${_resource}"/>

<h1>파일 선택 시 파일 바로 보여 주기 (서버저장 없이, 대체로 등록화면에서 사용)</h1>



<input id="a" type="file" accept=".jpg,.jpeg,.png" multiple="multiple">




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
			</tbody>
			</table>
		</li>
	`;
	
	
	$('#a').changeFile(function(files) {
		
		
		files.forEach((file) => {
			let html = $(imageHTML);
			
			
			html = html.find('img').prop('src', file.url).end();
			html = html.find('#name').text(file.name).end();
			html = html.find('#extension').text(file.extension).end();
			html = html.find('#size').text(file.size).end();
			html = html.find('#lastModified').text(new Date(file.lastModified).toDateString()).end();
			
			
			$('#list').append(html);	
		});
		
	});

</script>