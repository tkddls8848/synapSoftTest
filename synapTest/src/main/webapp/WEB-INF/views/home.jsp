<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page session="false"%>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style>
table {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    margin : 20px 10px;
}
</style>
	<title>사이냅소프트 테스트 페이지</title>
</head>
<body>
  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">지원자 박상인입니다.</h1>
			
      <p>결과값을 띄울 예정 가능하면 AJAX로 실시간 입력값에 대한 한글표기도 해볼까?</p>
    </div>
  </div>

<form action="/test/calculate" method="get">
	<table id="table">
		<tr>
			<td><input type="button" id="7" name="7" value="7" onclick='enterText(7)' class="btn btn-outline-secondary"></td>
			<td><input type="button" id="8" name="8" value="8" onclick='enterText(8)' class="btn btn-outline-secondary"></td>
			<td><input type="button" id="9" name="9" value="9" onclick='enterText(9)' class="btn btn-outline-secondary"></td>
		</tr>
		<tr>
			<td><input type="button" id="4" name="4" value="4" onclick='enterText(4)' class="btn btn-outline-secondary"></td>
			<td><input type="button" id="5" name="5" value="5" onclick='enterText(5)' class="btn btn-outline-secondary"></td>
			<td><input type="button" id="6" name="6" value="6" onclick='enterText(6)' class="btn btn-outline-secondary"></td>
		</tr>
		<tr>
			<td><input type="button" id="1" name="1" value="1" onclick='enterText(1)' class="btn btn-outline-secondary"></td>
			<td><input type="button" id="2" name="2" value="2" onclick='enterText(2)' class="btn btn-outline-secondary"></td>
			<td><input type="button" id="3" name="3" value="3" onclick='enterText(3)' class="btn btn-outline-secondary"></td>
		</tr>
	</table>
	
	<input type='text' id='result' value=''>
	<input type='button' onclick='clearText()' value='clear'>
	<input type='button' onclick='deleteText()' value='지우기'>
	<input type="submit" value='제출'>
</form>
</body>
<script type="text/javascript">

	function clearText(){
	    document.getElementById("result").value = ' ';
	}
	
	function enterText(num){
	    var str = document.getElementById("result").value;
	    str = str + num;
	    
	    if(num > 10000000000000){
	    	alert("백조 이상의 수");
	    	clearText();	
	    } else {
		    document.getElementById("result").value = str;	    	
	    }

	}
	
	function deleteText(){
	    var str = document.getElementById("result").value;
	    str = str.slice(0, -1);
	    document.getElementById("result").value = str;
	}
	
</script>
</html>
