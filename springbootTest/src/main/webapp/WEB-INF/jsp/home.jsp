<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style>
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:500px;}
#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px;}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}
#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default;color:#777;}
</style>

<title>Login Demo - Kakao JavaScript SDK</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
	
<script type="text/javascript">

function serachList()	{
	$.ajax({
		url: "serach",	 // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
		data: {keyword : $('#keyword').val()}, // HTTP 요청과 함께 서버로 보낼 데이터
		method: "GET",                                     // HTTP 요청 방식(GET, POST)
		//async: true,	//동기/비동기 방식 기본값 true
		//dataType: "json"                                   // 서버에서 보내줄 데이터의 타입
		contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		})
		.done(function(result) {	
			//alert("요청 성공");
			var item = "";
			var obj = result
			var pasobj=JSON.parse(obj);
			$("#listItem").empty();

			$.each(pasobj.documents, function(key,value) {					 			
				//가게이름
				item += "<tr>";
				item += "<td>";
				item += value.place_name;
				item += "</td>";
				//지번
				item += "<td>";
				item += value.address_name;
				item += "</td>";
				//신주소d
				item += "<td>";
				item += value.road_address_name;
				item += "</td>";
				//전화번호
				item += "<td>";
				item += value.phone;
				item += "</td>";
				item += "<input type='hidden' class='x' id = 'x' value ='"+value.x+"' >";
				item += "<input type='hidden' class='y' id = 'y' value ='"+value.y+"' >";
				item += "</tr>"; 
			})
			
 				$('#serchList').append(item);
			
				$('#serchList').html(item);

				$('#serchList').find('tr').click(function(){
					var xPosition = $(this).find('.x').val();
					var yPosition = $(this).find('.y').val();
					drawMap(xPosition, yPosition);
		       });

			$.each(pasobj.meta, function(key,value) {
				console.log("key : "+ key + " value : "+value );
	
				})
				 
			})
			.fail(function() {
				alert("요청 실패");
			})
	
}

$(document).ready(function() {
	
	$(".search").on("click", function() {
		serachList();
    });	
});
</script>
<body>

<!-- <div class="map_wrap">
		<div id="map" style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div> 지도
		<div id="menu_wrap" class="bg_white">
			<div class="option">
				<input type="text" value="" id="keyword" size="15">
				<button class="search" type="submit">검색하기</button>
			</div>
		</div>

			<ul id="placesList">
				<table id="serchList">
				</table>
			</ul>
</div>
 -->

<div class="map_wrap">
<div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white">
		<div class="option">
		    <input type="text" value="" id="keyword" size="15">
			<button class="search" type="submit">검색하기</button>
		</div>
		<hr>
        <ul id="placesList">
        	<table id="serchList">
 			</table>
        </ul>
        <div id="pagination"></div>
	</div>


</div>

<script type="text/javascript"	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a3e264ee681f0ca6bb7c3327986b38cd&libraries=services"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
	//기본 위치에대한 설정
	mapOption = {
		center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨
	};
	

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
	
	
	function drawMap (xPosition , yPosition){

		console.log("xPosition : "+ xPosition);
		console.log("yPosition : "+ yPosition);
		
		mapOption = {
				center : new kakao.maps.LatLng(yPosition, xPosition), // 지도의 중심좌표
				level : 3
			// 지도의 확대 레벨
			};

		var map = new kakao.maps.Map(mapContainer, mapOption);
	}
</script>

<!-- 	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a3e264ee681f0ca6bb7c3327986b38cd&libraries=services"></script>
	<script>
		// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
		var infowindow = new kakao.maps.InfoWindow({
			zIndex : 1
		});

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div
		//기본 위치에대한 설정
		mapOption = {
			center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 장소 검색 객체를 생성합니다
		var ps = new kakao.maps.services.Places();

		// 키워드 검색 완료 시 호출되는 콜백함수 입니다
		function placesSearchCB(y,  x) {
			alert ("지도 제성정 요청");
				// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
				// LatLngBounds 객체에 좌표를 추가합니다
			bounds.extend(new kakao.maps.LatLng(y, x));
			map.setBounds(bounds);
			
		}

	</script> -->
</body>
</body>


</html>