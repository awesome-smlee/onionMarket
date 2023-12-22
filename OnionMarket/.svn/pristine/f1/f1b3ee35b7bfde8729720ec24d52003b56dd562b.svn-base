<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" sizes="32x32" href="${_ctx}/favicon.png">
    <title>양파마켓</title>
<script type="text/javascript">
    function confirmSave() {
 
         	window.location.href = "<%=request.getContextPath()%>/que/QueList";
        }
        return shouldSave;
    }

    function cancelAndGoBack() {
        document.getElementById('que_tit').value = ''; // 제목 입력 필드 초기화
        document.getElementById('cont').value = ''; // 내용 입력 필드 초기화
        history.back(); // 이전 페이지로 돌아가기
    }
</script>

    <jsp:include page="${_resource}" />
</head>

<body>
    <div>
        <jsp:include page="${_header}" />

        <!-- sub-page 시작 -->
        <main class="sub-page">
            <div class="sub-menu">
                <a href="javascript:void(0)" class="active">1:1문의</a> <a href="javascript:void(0)">신고하기</a>
            </div>

            <div class="inner">
                <section class="content-area">
                    <h1 class="heading1">1:1 문의하기</h1>

                    <!-- queIns.jsp -->
                    
                    <form action="${pageContext.request.contextPath}/que/QueIns.do" method="post" onsubmit="return confirmSave()">
                        <div class="board-lst">
                            <ul>
                                <li class="input-group">
                                    <label for="que_tit">제목</label>
                                    <input type="text" name="que_tit" id="que_tit" placeholder="제목을 입력해주세요">
                                </li>
                                <li class="input-group">
                                    <label for="cont">내용</label>
                                    <textarea name="cont" id="cont" cols="30" rows="10" placeholder="내용을 입력해주세요"></textarea>
                                </li>
                            </ul>
                        </div>

                        <div class="btn-area">
                            <input type="button" value="취소하기" class="btn-style5" onclick="cancelAndGoBack()" />
                            <input type="submit" value="저장하기" class="btn-style4">
                        </div>
                    </form>
                </section>
            </div>
        </main>
        <!-- sub-page 끝 -->

        <jsp:include page="${_footer}" />
    </div>
</body>
</html>
