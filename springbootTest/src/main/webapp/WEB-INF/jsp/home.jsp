<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Demo - Kakao JavaScript SDK</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
	
<script type="text/javascript">
	$(document).ready(function() {
		//검색 기능

/* 		$(".search").click(function(){
			 alert($('#keyword').val());
			   $.ajax({
				     type: "get",
				     url: "serach",
				     contentType: "application/json;",
				     data: {keyword : $('#keyword').val()},
		             error: function(){
		                 alert("SMS 재전송 실패입니다. 관리자에게 문의바랍니다.");
		             },
		             success: function(result){
		                 if(result == "success") {
		                     alert("SMS 재전송 성공입니다.");
		                 }else{
		                     alert("SMS 재전송 실패입니다. 관리자에게 문의바랍니다.");
		                 }
		             }
		         });
			}); */

		$(function() {
			$(".search").on("click", function() {
				$.ajax({
					url: "serach",	 // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
				    data: {keyword : $('#keyword').val()},  	                        // HTTP 요청과 함께 서버로 보낼 데이터
				    method: "GET",                                     // HTTP 요청 방식(GET, POST)
				    async: false,
				    dataType: "json"                                   // 서버에서 보내줄 데이터의 타입

				})
				//왜갑자기안댐 이게 secruty 때 매 뭐오류나면 저지랄남
				.done(function(result) {
					//gogobb 저건뭐지 신기하네
					alert("요청 성공");
					//걍string 찍어서 보내셈
					//var tmp= result.json;rr
					var obj = JSON.stringify(result);
					console.log(obj);
					
					/* for ( var k in obj ){
						console.log(obj[k]);	
					} */
					//var fiestKey = obj.documents; //< < undefind 뜸
					//console.log(fiestKey); //찍어보셈
					//잠시 물좀먹고왔음ㅇㅇ 이거만찍어봄

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
			<ul class ="placesList" id="placesList"></ul>
			<div id="pagination"></div>
		</div>
	</div>
</body>


</html>