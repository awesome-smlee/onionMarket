<%@page import="kr.or.ddit.vo.ComNewsVO"%>
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
List<ComNewsVO> newsList = (List<ComNewsVO>)request.getAttribute("newsList");
%>
<script type="text/javascript">
 function popupCenter(url, name, w, h, s) {
     var urlReal = url;
     var agt = navigator.userAgent.toLowerCase();

     if (agt.indexOf("trident") != -1) {
         //IE 
         urlReal = url.replace(/&/gi, '&amp;');
     }

     if (urlReal == null)
         return;
     _name = arguments[1] != null ? arguments[1] : "nWin";
     _w = "680";
     _h = "650";
     _x = (screen.width / 2) - (_w / 2);
     _y = (screen.height / 2) - (_h / 2);
     _s = "yes";
     var opt = ',menubar=no,status=no,resizable=no,directories=0,toolbar=0,location=0,';
     var p_win = window.open(urlReal, _name,
     'width=' + _w + ',height=' + _h + ',left=' + _x + ',top=' + _y + ',scrollbars=' + _s + opt);
     p_win.focus();
     this.name = 'cnedu';
     return p_win;
 }
 
function popupCenterNew(orgCd, no) {

    var url = "";

    switch (orgCd) {
    case "seogu":
        url = "http://eminwon.seogu.go.kr/";
        break;
    case "yuseonggu":
        url = "http://eminwon.yuseong.go.kr/";
        break;
    case "djjunggu":
        url = "http://eminwon.djjunggu.go.kr/";
        break;
    case "donggu":
        url = "http://eminwon.donggu.go.kr/";
        break;
    case "daedeokgu":
        url = "http://eminwon.daedeok.go.kr/";
        break;
    default:
        break;
    }

    url = url + "emwp/gov/mogaha/ntis/web/ofr/action/OfrAction.do?subCheck=Y&jndinm=OfrNotAncmtEJB&context=NTIS&method=selectOfrNotAncmt&methodnm=selectOfrNotAncmtRegst&not_ancmt_mgt_no=" + no;

    var popOpener = "popOpener";
    popupCenter(url, popOpener);


}
</script>
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
		<main class="sub-page">

            <!-- sub-menu 시작 -->
            <div class="sub-menu">
                <a href="<%=request.getContextPath()%>/com/comList.do">동네 커뮤니티</a>
                <a href="javascript:void(0)" class="active">동네 소식</a>
            </div>
            <!-- sub-menu 끝 -->

            <div class="inner">

                <section class="content-area">
                    <h1 class="heading1">동네 소식</h1>

                    <div class="news-area">
                        <div class="tab-wrap">
                            <div class="tab-type tab-type1">
                                <div class="tab-menu">
                                    <button data-tab="tab1" class="tab-btn active">동구</button>
                                    <button data-tab="tab2" class="tab-btn">중구</button>
                                    <button data-tab="tab3" class="tab-btn">서구</button>
                                    <button data-tab="tab4" class="tab-btn">대덕구</button>
                                    <button data-tab="tab5" class="tab-btn">유성구</button>
                                </div>

                                <div data-tab="tab1" class="tab-content active">
                                    <div class="tab-board-lst">
                                        <table class="board-table">
                                            <colgroup>
                                                <col style="width: 15%;">
                                                <col style="width: 20%;">
                                                <col style="width: 40%;">
                                                <col style="width: 15%;">
                                                <col style="width: 10%;">
                                            </colgroup>
                                            <thead>
                                                <tr>
                                                    <th>순번등록일</th>
                                                    <th>담당구청</th>
                                                    <th>제목</th>
                                                    <th>공고분류</th>
                                                    <th>날짜</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                            for(ComNewsVO newsVo : newsList) {
                                            	if(newsVo.getGu().equals("[동구]")) {
                                            %>
                                                <tr>
							                      <td class=""><%=newsVo.getNews_id() %></td>
							                      <td class=""><%=newsVo.getGu() %></td>
							                      <td class="">
							                        <a href="#" onclick="<%=newsVo.getFn()%>"><%=newsVo.getTit() %></a>
							                      </td>
							                      <td class=""><%=newsVo.getDivision() %></td>
							                      <td class=""><%=newsVo.getIns_dt() %></td>
							                    </tr>
                                            <%
                                            	}
                                            }
                                            %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div data-tab="tab2" class="tab-content">
                                    <div class="tab-board-lst">
										<table class="board-table">
                                            <colgroup>
                                                <col style="width: 15%;">
                                                <col style="width: 20%;">
                                                <col style="width: 40%;">
                                                <col style="width: 15%;">
                                                <col style="width: 10%;">
                                            </colgroup>
                                            <thead>
                                                <tr>
                                                    <th>순번등록일</th>
                                                    <th>담당구청</th>
                                                    <th>제목</th>
                                                    <th>공고분류</th>
                                                    <th>날짜</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                            for(ComNewsVO newsVo : newsList) {
                                            	if(newsVo.getGu().equals("[중구]")) {
                                            %>
                                                <tr>
							                      <td class=""><%=newsVo.getNews_id() %></td>
							                      <td class=""><%=newsVo.getGu() %></td>
							                      <td class="">
							                        <a href="#" onclick="<%=newsVo.getFn()%>"><%=newsVo.getTit() %></a>
							                      </td>
							                      <td class=""><%=newsVo.getDivision() %></td>
							                      <td class=""><%=newsVo.getIns_dt() %></td>
							                    </tr>
                                            <%
                                            	}
                                            }
                                            %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div data-tab="tab3" class="tab-content">
                                    <div class="tab-board-lst">
										<table class="board-table">
                                            <colgroup>
                                                <col style="width: 15%;">
                                                <col style="width: 20%;">
                                                <col style="width: 40%;">
                                                <col style="width: 15%;">
                                                <col style="width: 10%;">
                                            </colgroup>
                                            <thead>
                                                <tr>
                                                    <th>순번등록일</th>
                                                    <th>담당구청</th>
                                                    <th>제목</th>
                                                    <th>공고분류</th>
                                                    <th>날짜</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                            for(ComNewsVO newsVo : newsList) {
                                            	if(newsVo.getGu().equals("[서구]")) {
                                            %>
                                                <tr>
							                      <td class=""><%=newsVo.getNews_id() %></td>
							                      <td class=""><%=newsVo.getGu() %></td>
							                      <td class="">
							                        <a href="#" onclick="<%=newsVo.getFn()%>"><%=newsVo.getTit() %></a>
							                      </td>
							                      <td class=""><%=newsVo.getDivision() %></td>
							                      <td class=""><%=newsVo.getIns_dt() %></td>
							                    </tr>
                                            <%
                                            	}
                                            }
                                            %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div data-tab="tab4" class="tab-content">
                                    <div class="tab-board-lst">
										<table class="board-table">
                                            <colgroup>
                                                <col style="width: 15%;">
                                                <col style="width: 20%;">
                                                <col style="width: 40%;">
                                                <col style="width: 15%;">
                                                <col style="width: 10%;">
                                            </colgroup>
                                            <thead>
                                                <tr>
                                                    <th>순번등록일</th>
                                                    <th>담당구청</th>
                                                    <th>제목</th>
                                                    <th>공고분류</th>
                                                    <th>날짜</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                            for(ComNewsVO newsVo : newsList) {
                                            	if(newsVo.getGu().equals("[대덕구]")) {
                                            %>
                                                <tr>
							                      <td class=""><%=newsVo.getNews_id() %></td>
							                      <td class=""><%=newsVo.getGu() %></td>
							                      <td class="">
							                        <a href="#" onclick="<%=newsVo.getFn()%>"><%=newsVo.getTit() %></a>
							                      </td>
							                      <td class=""><%=newsVo.getDivision() %></td>
							                      <td class=""><%=newsVo.getIns_dt() %></td>
							                    </tr>
                                            <%
                                            	}
                                            }
                                            %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div data-tab="tab5" class="tab-content">
                                    <div class="tab-board-lst">
										<table class="board-table">
                                            <colgroup>
                                                <col style="width: 15%;">
                                                <col style="width: 20%;">
                                                <col style="width: 40%;">
                                                <col style="width: 15%;">
                                                <col style="width: 10%;">
                                            </colgroup>
                                            <thead>
                                                <tr>
                                                    <th>순번등록일</th>
                                                    <th>담당구청</th>
                                                    <th>제목</th>
                                                    <th>공고분류</th>
                                                    <th>날짜</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                            for(ComNewsVO newsVo : newsList) {
                                            	if(newsVo.getGu().equals("[유성구]")) {
                                            %>
                                                <tr>
							                      <td class=""><%=newsVo.getNews_id() %></td>
							                      <td class=""><%=newsVo.getGu() %></td>
							                      <td class="">
							                        <a href="#" onclick="<%=newsVo.getFn()%>"><%=newsVo.getTit() %></a>
							                      </td>
							                      <td class=""><%=newsVo.getDivision() %></td>
							                      <td class=""><%=newsVo.getIns_dt() %></td>
							                    </tr>
                                            <%
                                            	}
                                            }
                                            %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div>
                </section>
            </div>

        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>