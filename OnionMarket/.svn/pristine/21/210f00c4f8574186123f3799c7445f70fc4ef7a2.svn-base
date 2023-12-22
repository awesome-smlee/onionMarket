<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" sizes="32x32" href="${_ctx}/favicon.png">
	<title>양파마켓</title>
	<style>
    .map-area {position:relative;width:100%;height:350px;}
    .title {font-weight:bold;display:block;}
    .hAddr {position:absolute;left:10px;top:10px;border-radius: 2px;background:#fff;background:rgba(255,255,255,0.8);z-index:1;padding:5px;}
    #centerAddr {display:block;margin-top:2px;font-weight: normal;}
    .bAddr {padding:5px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
	</style>
	
	<jsp:include page="${_resource}"/>
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
		<main class="sub-page">

            <div class="inner">
                <aside class="left-menu border-r">
                    <p class="menu-tit">마이페이지</p>

                    <ul class="mypage-menu">
                        <li>
                            <div class="profile-area">
                                <div class="profile">
                                    <!-- 프로필 등록시 아래 img태그 추가해주세요 -->
                                    <!-- <img src="../img/example/img1.jpg(예시)"> -->
                                </div>

                                <a href="javascript:void(0)">프로필 설정</a>
                            </div>
                        </li>
                        <li>
                            <p class="tit">나의 거래</p>
                            <a href="/my/sellListMy.do">판매내역</a>
                            <a href="/my/buyListMy.do">구매내역</a>
                            <a href="/my/wishlistMy.do">위시리스트</a>
                            <a href="/my/locationMy.do" class="active">내 동네 설정</a>
                            <a href="/my/keywordMy.do">알림 키워드 설정</a>
                        </li>
                        <li>
                            <p class="tit">내 동네 활동</p>
                            <a href="/com/comList.do">커뮤니티</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)">회원정보 탈퇴</a>
                        </li>
                    </ul>
                </aside>

                <section class="content-area">
                    <div class="mypage-list">
                        <h1 class="heading2">내 동네 설정</h1>

                        <div class="choice-area" id="town">
                            <ul>
                                <li id = "donggu" class="active">동구</li>
                                <li id = "junggu">중구</li>
                                <li id = "seogu">서구</li>
                                <li id = "daedeok">대덕구</li>
                                <li id = "yuseong">유성구</li>
                            </ul>
                            <div class="map-area"> 
                            <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;">
                            </div></div>
                        </div>

                        <div class="btn-area">
                            <input type="button" value="저장하기" class="btn-style4">
                        </div>
                    </div>

                </section>
            </div>
        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=245955c2a1a7889af6bf2e4369f4bef4&libraries=services"></script>

<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
        center: new kakao.maps.LatLng(36.325158, 127.408784), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };  

    // 지도를 생성합니다    
    var map = new kakao.maps.Map(mapContainer, mapOption); 

    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();

    var marker = new kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
        infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다


    $('.active li').on('click', function(){
        var id = $(this).attr('id');    //클릭한 버튼 id 가져오기

        switch(id){
            case 'donggu': 
                map.setCenter(new kakao.maps.LatLng(36.350297, 127.436747));
                break;
            case 'junggu': 
                map.setCenter(new kakao.maps.LatLng(36.325158,  127.408782));
                break;
            case 'seogu': 
                map.setCenter(new kakao.maps.LatLng(36.351799, 127.378190));
                break;
            case 'daedeok': 
                map.setCenter(new kakao.maps.LatLng(36.365609, 127.441880));
                break;
            case 'yuseong': 
                map.setCenter(new kakao.maps.LatLng(36.375233, 127.381323));
                break;
                }           
        })

    // 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
    kakao.maps.event.addListener(map, 'click', function(mouseEvent) {

        
        // 대전 시내 경계 좌표 대략 끝과 끝 찍어놓는거
        var bounds = new kakao.maps.LatLngBounds(
            new kakao.maps.LatLng(36.2566, 127.2933), // 남서쪽 좌표
            new kakao.maps.LatLng(36.4560, 127.5142)  // 동북쪽 좌표
            
        );
        
        // 클릭한 좌표가 대전 시내 경계 안에 있는지 확인
        if (bounds.contain(mouseEvent.latLng)) {     
            searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
                if (status === kakao.maps.services.Status.OK) {

                    //지번
                    var jibun = result[0].address.address_name
                    var detailAddr = '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
                
                    var content = '<div class="bAddr">' + '<span class="title">주소정보</span>'
                        + detailAddr + '</div>'; 

                    // 마커를 클릭한 위치에 표시합니다 
                    marker.setPosition(mouseEvent.latLng);
                    marker.setMap(map);

                    // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                    infowindow.setContent(content);
                    infowindow.open(map, marker);
                    
                    //클릭한곳 위도 경도 가져오기
                    var latlng = mouseEvent.latLng; 
                    
                    // 시/도, 구/군, 동/읍/면을 나누기
                    var parts = jibun.split(' ');
                    var si = parts[0]; // 시/도
                    var gu = parts[1]; // 구/군
                    var dong = parts[2]; // 동/읍/면
                    var bunji = parts[3]; //지번
                    } 
                });

                }else{
                     alert("대전안에서 선택해주세요")
                }
                });

        function searchDetailAddrFromCoords(coords, callback) {
        // 좌표로 법정동 상세 주소 정보를 요청
        geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
             $('#save').on('click', function(){           
             alert('내 동네가 설정되었습니다');
             window.location.href = 'd_마이페이지_프로필설정.html';
         })
        
        }

    
        

        
    

</script>
</html>
