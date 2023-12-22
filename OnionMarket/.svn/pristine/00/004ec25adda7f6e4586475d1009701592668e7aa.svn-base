기록남기기<%-- <%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.UsersVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery-3.7.0.min.js"></script>
<script src="../js/admin.js"></script>
<title>관리자</title>
</head>

<body>
<%
	List<UsersVO> usersList = (List<UsersVO>)request.getAttribute("usersList");
%>
	<div class="admin-page">
		<aside>
			<ul class="menu">
				<li><a href="javascript:void(0)">회원관리</a></li>
				<li><a href="javascript:void(0)">공지사항</a></li>
				<li><a href="javascript:void(0)">신고관리</a></li>
				<li><a href="javascript:void(0)">문의관리</a></li>
			</ul>

			<a href="javascript:void(0)" class="link"> 양파마켓 메인<i
				class="xi-external-link"></i></a>
		</aside>
		<div class="wrap">
			<header>
				<h1 class="logo">양파마켓 관리자</h1>
				<a href="javascript:void(0)" class="user">로그인</a>
			</header>
			<main>
				<h1 class="heading1">회원목록</h1>

				<div class="search-info">
					<div class="total">
						전체 <span>100</span>건
					</div>
					<div class="form-area">
						<div class="search-form">
							<select name="" id="">
								<option value="">전체</option>
								<option value="">아이디</option>
								<option value="">이름</option>
								<option value="">아이디+이름</option>
							</select>
						</div>
						<div class="input-form">
							<input type="text" placeholder="검색할 내용을 입력하세요">
						</div>
						<a href="javascript:void(0)" class="search-btn"> <i
							class="xi-search"></i>
						</a>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>회원유형</th>
							<th>아이디</th>
							<th>이름</th>
							<th>닉네임</th>
							<th>휴대폰번호</th>
							<th>이메일</th>
							<th>가입일자</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<!--  <td>
                                <select name="" id="">
                                    <option selected>회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td> -->
							<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
						<tr>
							<td><%=usersvo.getUser_tp() %></td>
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						</tr>
						<%
                            	}
                        %>


					</tbody>
				</table>

				<!-- pager 시작 -->
				<div class="pager">
					<a href="javascript:void(0);" class="arr prev"></a> 
					<strong class="active">1</strong> <a href="javascript:void(0);">2</a> 
					<a href="javascript:void(0);">3</a> <a href="javascript:void(0);">4</a>
					<a href="javascript:void(0);">5</a> <a href="javascript:void(0);">6</a>
					<a href="javascript:void(0);">7</a> <a href="javascript:void(0);">8</a>
					<a href="javascript:void(0);" class="arr next"></a>
				</div>
				<!-- pager 끝 -->
			</main>
		</div>
	</div>
</body>

</html> --%>
<%@page import="kr.or.ddit.vo.UsersVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" sizes="32x32" href="${_ctx}/favicon.png">
	<title>양파마켓</title>
	
	<jsp:include page="${_resource_admin}"/>
</head>

<body>

<%
	List<UsersVO> usersList = (List<UsersVO>)request.getAttribute("usersList");
%>
	<div class="admin-page">
		
		<jsp:include page="${_footer_admin}"/>
		
		<div class="wrap">
			
			<jsp:include page="${_header_admin}"/>
			
			<main>
                <h1 class="heading1">회원목록</h1>

                <div class="search-info">
                    <div class="total">전체 <span>100</span>건</div>
                    <div class="form-area">
                        <div class="search-form">
                            <select name="" id="">
                                <option value="">전체</option>
                                <option value="">아이디</option>
                                <option value="">이름</option>
                                <option value="">아이디+이름</option>
                            </select>
                        </div>
                        <div class="input-form">
                            <input type="text" placeholder="검색할 내용을 입력하세요">
                        </div>
                        <a href="javascript:void(0)" class="search-btn">
                            <i class="xi-search"></i>
                        </a>
                    </div>
                </div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>회원유형</th>
                            <th>아이디</th>
                            <th>이름</th>
                            <th>닉네임</th>
                            <th>휴대폰번호</th>
                            <th>이메일</th>
                            <th>가입일자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                            
                     
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                           
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                           
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                            
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                          
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                        
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                          
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        
                         <tr>
                            <td>11</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        
                         <tr>
                            <td>12</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        
                         <tr>
                            <td>13</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                         <tr>
                            <td>14</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                         <tr>
                            <td>15</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                         <tr>
                            <td>16</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                         <tr>
                            <td>17</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        
                         <tr>
                            <td>18</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        
                         <tr>
                            <td>19</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                        
                         <tr>
                            <td>20</td>
                            <td>
                                <select name="" id="">
                                    <option selected="">회원유형선택</option>
                                    <option value="">일반회원</option>
                                    <option value="">정지회원</option>
                                    <option value="">휴면회원</option>
                                    <option value="">탈퇴회원</option>
                                    <option value="">관리자</option>
                                </select>
                            </td>
                         
                           	<%
                            	for(UsersVO usersvo : usersList){
                            %>
						
							<td><%=usersvo.getUser_id() %></td>
							<td><%=usersvo.getUser_nm() %></td>
							<td><%=usersvo.getNick_nm() %></td>
							<td><%=usersvo.getTel() %></td>
							<td><%=usersvo.getEmail() %></td>
							<td><%=usersvo.getIns_dt() %></td>
						
						<%
                            	}
                        %>
                        </tr>
                    </tbody>
                </table>

                <!-- pager 시작 -->
                <div class="pager">
                    <a href="javascript:void(0);" class="arr prev"></a>
                    <strong class="active">1</strong>
                    <a href="javascript:void(0);">2</a>
                    <a href="javascript:void(0);">3</a>
                    <a href="javascript:void(0);">4</a>
                    <a href="javascript:void(0);">5</a>
                    <a href="javascript:void(0);">6</a>
                    <a href="javascript:void(0);">7</a>
                    <a href="javascript:void(0);">8</a>
                    <a href="javascript:void(0);" class="arr next"></a>
                </div>
                <!-- pager 끝 -->
            </main>
			
		</div>
		
	</div>

</body>
</html>