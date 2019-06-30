<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Demo - Kakao JavaScript SDK</title>

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
	
<script type="text/javascript">
	$(document).ready(function() {
		//검색 기능
		$(".search").click(function(){

			 alert($('#keyword').val());
 	         $.ajax({
	             url: "serach",
	             type: "get",
	             contentType: "application/json;",
	             data: {keyword : $('#keyword').val()},
	             success: function(data){
	            	 alert("hi")
	             },
	             error: function(){
		             alert("실패");
		         },timeout: 3000
	             
	         }); 

		});

	});
</script>
</body>


</html>