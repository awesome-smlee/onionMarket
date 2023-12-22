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

