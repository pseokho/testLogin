<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title>Login Demo - Kakao JavaScript SDK</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
</head>
<body>
	<div class="map_wrap">
		<div id="map"
			style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

		<div id="menu_wrap" class="bg_white">
			<div class="option">
				<div>
					<form onsubmit="searchPlaces(); return false;">키워드 : 
						<input type="text" value="카카오뱅크" id="keyword" size="15">
						<button class="search" type="submit">검색하기</button>
					</form>
				</div>
			</div>
			<hr>
			<ul id="placesList"></ul>
			<div id="pagination"></div>
		</div>
	</div>
</body>
<script>
	$(function() {
		//검색 기능
		$(".search").click(function(){

			 alert($('#keyword').val());
 	         $.ajax({

	             url: "serach",
	             type: "get",
//	             contentType: "application/json;",
	             data: {keyword : $('#keyword').val()},
	             success: function(t){
	                     alert("성공");
	             },
	             error: function(){
		             alert("실패");
		         }
	             
	         }); 

		});

	});
</script>
</html>