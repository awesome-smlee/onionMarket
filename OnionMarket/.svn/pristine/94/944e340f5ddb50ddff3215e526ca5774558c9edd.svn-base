<%@page import="kr.or.ddit.vo.UsersVO"%>
<%@page import="kr.or.ddit.vo.ComRepVO"%>
<%@page import="kr.or.ddit.vo.ComJoinVO"%>
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
	
	<jsp:include page="${_resource}"/>
<%
List<ComJoinVO> cateList = (List<ComJoinVO>)request.getAttribute("cateList");
ComJoinVO comVo = (ComJoinVO)request.getAttribute("comVo");
List<ComRepVO> repList = (List<ComRepVO>)request.getAttribute("repList");
int repCount = (int)request.getAttribute("count");
int comId = (int)request.getAttribute("comId");
UsersVO vo = (UsersVO)session.getAttribute("loginUser");
String insId = (String)request.getAttribute("insId");
%>
<script type="text/javascript">
$(function() {
	$('#replyBtn').on('click', function() {
		var replyCont = $('#replyCont').val();
		var comId = <%=comId%>;
		$.ajax ({
			url : "<%=request.getContextPath()%>/comRep/comRepInsert.do",
			type : "post",
			data : { "replyCont" : replyCont, "comId" : comId },
			success : function(data) {
				location.reload();
			},
			error : function(xhr) {
				/* alert("오류 코드: " + xhr.status);*/
			}
		});
	});
	$('#updateBtn').on('click', function() {
		var comId = <%=comId%>;
		location.href = "<%=request.getContextPath()%>/com/comUpdateForm.do?comId=<%=comId%>";
	});
	$('#deleteBtn').on('click', function() {
		var chkMsg = confirm("정말로 삭제하시겠습니까? 삭제 후 게시글 복구가 불가합니다.");
		var comId = <%=comId%>;
		if(chkMsg) {
			location.href = "<%=request.getContextPath()%>/com/comDelete.do?comId=<%=comId%>";
		} else {
			alert("게시글 삭제를 취소합니다.");
		}
	});
	// 게시글 삭제랑 댓글 삭제 다른 방식으로 해보기
	$('.repDelBtn').on('click', function() {
		var chkMsg = confirm("정말로 삭제하시겠습니까? 삭제 후 댓글 복구가 불가합니다.");
		var repId = $(this).data("rep-id");
		if(chkMsg) {
			$.ajax ({
				url : "<%=request.getContextPath()%>/comRep/comRepDelete.do",
				type : "post",
				data : { "repId" : repId },
				success : function(data) {
					location.reload();
				},
				error : function(xhr) {
					alert("오류 코드: " + xhr.status);
				}
			});
		} else {
			alert("게시글 삭제를 취소합니다.");
		}
	});
});
</script>
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
		<main class="sub-page">

            <!-- sub-menu 시작 -->
            <div class="sub-menu">
                <a href="<%=request.getContextPath()%>/com/comList.do" class="active">동네 커뮤니티</a>
                <a href="<%=request.getContextPath()%>/comnews/comNewsList.do">동네 소식</a>
            </div>
            <!-- sub-menu 끝 -->

            <div class="inner">
                <aside class="left-menu">
                    <p class="menu-tit">필터<i class="xi-filter"></i></p>

                    <div class="category-box">
                        <p class="sub-tit">카테고리 선택</p>
                        <ul class="select-group">
                        <%
                        	for(ComJoinVO cate : cateList) {
                        %>
                            <li>
                                <input style="font-size: 18px; padding: 10px 0px; background: white;" type="button" value="<%=cate.getCate_nm() %>" class="cate">
                            </li>
                        <%
                        	}
                        %>
                        </ul>
                    </div>

                    <div class="category-box">
                        <p class="sub-tit">지역별</p>
                        <ul class="select-group">
                            <li>
                                <a href="javascript:void(0)">대덕구</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">유성구</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">중구</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">서구</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">동구</a>
                            </li>
                        </ul>
                    </div>

                    <div class="keyword-search-area">
                        <p class="sub-tit">키워드</p>
                        <div class="box-wrap">
                            <input type="text" placeholder="검색어 입력">
                            <a href="javascript:void(0)" class="search-btn"></a>
                        </div>
                    </div>

                </aside>

                <section class="content-area">
                    <h1 class="heading1">게시글 상세</h1>

                    <div class="board-view-area">
                        <p class="board-cate"><%=comVo.getCate_nm() %></p>
                        <div class="profile-area">
                            <div class="profile">
                                <!-- 프로필 등록시 아래 img태그 추가해주세요 -->
                                <!-- <img src="../img/example/img1.jpg(예시)"> -->
                            </div>
                            <p class="nikname"><%=comVo.getNick_nm() %></p>
                        </div>
                        <p class="board-tit"><%=comVo.getTit() %></p>
                        <hr class="hr">
                        <div class="board-util">
                            <a href="javascript:void(0)" class="police-btn">
                                <i class="xi-error-o"></i>신고하기
                            </a>
                        </div>
                        <p class="board-txt" style="height: 400px;"><%=comVo.getCont() %></p>

                        <div class="board-side">
                            <span>조회수 <%=comVo.getVw_cnt() %></span>
                            <span style="display: none;">좋아요 <%=comVo.getLk_cnt() %></span>
                        </div>

                        <div class="board-reply-area">
                            <p class="reply-state">댓글(<%=repCount %>)</p>
							<%
							for(ComRepVO repVo : repList) {
							%>
                            <div class="reply-box">
                                <div class="profile-area">
                                    <div class="profile">
                                        <!-- 프로필 등록시 아래 img태그 추가해주세요 -->
                                        <!-- <img src="../img/example/img1.jpg(예시)"> -->
                                    </div>
                                    <p class="nikname"><%=repVo.getNick_nm() %></p>
                                </div>
                                <p class="comment"><%=repVo.getCont() %></p>
                                <p class="date"><%=repVo.getIns_dt() %></p>
                            </div>
                            <%
                            if(vo.getNick_nm().equals(repVo.getNick_nm())) {
                            %>
                            <div class="btn-box">
                                <input type="button" value="수정" class="delete-btn, repUpdBtn" data-rep-id="<%=repVo.getRep_id() %>">
                                <input type="button" value="삭제" class="update-btn, repDelBtn" data-rep-id="<%=repVo.getRep_id() %>">
                            </div>
                            <%
                            	}
							}
							%>
                            <div class="reply-writer">
                                <div class="profile-area">
                                    <div class="profile">
                                        <!-- 프로필 등록시 아래 img태그 추가해주세요 -->
                                        <!-- <img src="../img/example/img1.jpg(예시)"> -->
                                    </div>
                                    <p class="nikname"><%=vo.getNick_nm() %></p>
                                </div>
                                  <textarea id="replyCont" placeholder="양파마켓이 더 훈훈해지는 댓글 부탁드립니다."></textarea>
                                <div class="btn-wrap">
                                    <input type="button" class="reply-btn" value="등록" id="replyBtn">
                                </div>
                            </div>

                        </div>
                    </div>
                    <%
                    if((vo.getUser_id()).equals(insId)) {
                    %>
                    <div class="btn-area">
                        <input type="button" value="수정하기" class="btn-style6" id="updateBtn">
                        <input type="button" value="삭제하기" class="btn-style5" id="deleteBtn">
                    </div>
                 	<%
                    }
                 	%>

                </section>
            </div>

        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>