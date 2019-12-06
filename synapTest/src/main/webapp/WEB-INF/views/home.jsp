<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page session="false"%>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style>
table {
    border-collapse: collapse;
    text-align: center;
    line-height: 1.5;
    margin : 20px 10px;
    width : 50%;
    height : 50%;
}

.btn btn-outline-secondary btn-lg {
    width : 100%;
    height : 100%;
}
</style>
	<title>사이냅소프트 테스트 페이지</title>
	<% String context = request.getContextPath(); %>
</head>
<body>

<div class="jumbotron">
	<div class="container">
	<h1 class="display-3">지원자 박상인입니다.</h1>
	<h4>결과값 : ${String}</h4>
	</div>
</div>

<div class='container'>

	<div id='panel'>
		<div class="col-sm-12 text-center">
			<input type="button" id="7" name="7" value="7" onclick='enterText(7)' class="btn btn-lg btn-outline-secondary">
			<input type="button" id="8" name="8" value="8" onclick='enterText(8)' class="btn btn-lg btn-outline-secondary">
			<input type="button" id="9" name="9" value="9" onclick='enterText(9)' class="btn btn-lg btn-outline-secondary">
		</div>
		<div class="col-sm-12 text-center">
			<input type="button" id="4" name="4" value="4" onclick='enterText(4)' class="btn btn-lg btn-outline-secondary">
			<input type="button" id="5" name="5" value="5" onclick='enterText(5)' class="btn btn-lg btn-outline-secondary">
			<input type="button" id="6" name="6" value="6" onclick='enterText(6)' class="btn btn-lg btn-outline-secondary">
		</div>
		<div class="col-sm-12 text-center">
			<input type="button" id="1" name="1" value="1" onclick='enterText(1)' class="btn btn-lg btn-outline-secondary">
			<input type="button" id="2" name="2" value="2" onclick='enterText(2)' class="btn btn-lg btn-outline-secondary">
			<input type="button" id="3" name="3" value="3" onclick='enterText(3)' class="btn btn-lg btn-outline-secondary">
		</div>
		<div class="col-sm-12 text-center">
			<input type="button" id="0" name="0" value="0" onclick='enterText(0)' class="btn btn-lg btn-outline-secondary">
		</div>
	</div>
	
	<div>
		<p></p>
	</div>
	
	<div class="col-sm-12 text-center">
		<form id='getForm' action="<%=context%>/calculate?result=" method="get">
			<input id='result' name='result' value='원' style="text-align:right;">
			<input type='button' onclick='clearText()' value='초기화' class="btn btn-lg btn-secondary">
			<input type='button' onclick='deleteText()' value='지우기' class="btn btn-lg btn-secondary">
			<input type="submit" value='제출' class="btn btn-lg btn-primary">
		</form>
	</div>
</div>

<a href="15.165.80.111:8090/project/"><label>포트폴리오 사이트 링크</label></a>
<a href="15.165.80.111:8090/project/"><label>이력서 다운로드 링크()</label></a>

</body>
<script type="text/javascript">
	function clearText(){
	    document.getElementById("result").value = ' ';
	}
	
	function enterText(num){
	    var str = document.getElementById("result").value;
	    str = str.substring(0, str.length-1) + num;
	    noComm = str.replace(/,/gi, "");
	    console.log(noComm);
		result = parseInt(noComm).toLocaleString('en');
		
		document.getElementById("result").value = result+'원';	    	
	}
	
	function commaFormat(input) {
		var str = input;
		   return str.toString().toLocaleString();
	}
	
	function deleteText(){
	    var str = document.getElementById("result").value;
	    str = str.substring(0, str.length-2);
	    noComm = str.replace(/,/gi, "");
	    console.log(noComm);
		result = parseInt(noComm).toLocaleString('en');
	    document.getElementById("result").value = result+'원';
	}
	
	function submit(){
	    var str = document.getElementById("result").value;
	    location.href="/test/calculate?result="+ str;
	}	
</script>
</html>
