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
	$(document).ready(function() {
		//검색 기능

		$(function() {
			$(".search").on("click", function() {
				$.ajax({
					url: "serach",	 // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
				    data: {keyword : $('#keyword').val()},  	                        // HTTP 요청과 함께 서버로 보낼 데이터
				    method: "GET",                                     // HTTP 요청 방식(GET, POST)
				    async: false,
				    //dataType: "json"                                   // 서버에서 보내줄 데이터의 타입
				    contentType: "application/x-www-form-urlencoded; charset=UTF-8"

				})
				.done(function(result) {
					//alert("요청 성공");
					var obj = result
					var pasobj=JSON.parse(obj);
					$.each(pasobj, function(key,value) {
						console.log(value);
						   var item = "";
				            item += "<tr onclick>";
				            // value.x;  value.y; 지도값에 사용
				              //가게이름
				              item += "<td>";
				              item += value.place_name;
				              item += "</td>";

				              //지번
				              item += "<td>";
				              item += value.address_name;
				              item += "</td>";
				              //신주소
				              item += "<td>";
				              item += value.road_address_name;
				              item += "</td>";
				              //전화번호
				              item += "<td>";
				              item += value.phone;
				              item += "</td>";   
				         item += "</tr>";
				         $('#placesList').append(item);
					});
				})
				.fail(function() {
					alert("요청 실패");
				})
			});
		});

	});
</script>
<body>
	<div class="map_wrap">
	<input type="text" value="" id="keyword" size="15">
	<button class="search" type="submit">검색하기</button>
<%-- 		<div id="map"
			style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

		<div id="menu_wrap" class="bg_white">
			<div class="option">
				<div>
					<form>키워드 : 
						
						<button class="search" type="submit">검색하기</button>
					</form>
				</div>
			</div>
			<hr>
			<ul class ="placesList" id="placesList"></ul>
			<div id="pagination"></div>
		</div> --%>
		<ul class ="placesList" id="placesList"></ul>
		<table id ="listItem">
			<tr><td></td></tr>
		</table>
	</div>
</body>


</html>