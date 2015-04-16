<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="content" align="center">
	Привет, ${username}, выбери тест:
	<br><br>
<div id="content" align="left" margin = 40>
	<c:forEach items="${tests}" var="tests">
		<input type="radio" name="test" value="${tests.id}"> ${tests.name}
		<br/>
	</c:forEach>

</div>
	<br>
	<input type="button" value="Начать тест" id="begtest">
	<br>
	<br>
	<input type="button" value="Мои результаты" id="myresults">
	<br>
	<br>
	<input type="button" value="Редактировать" id="edit">
</div>

<br>
<br>
<div id="userResults" align="center">
</div>
<script type="text/javascript">
	var testid;

	<c:set var="ur" value="${userrole}"/>
	<c:set var="ur1" value="admin"/>

	<c:if test="${ur == ur1}">
		$("#edit").click(function(){
			$.ajax({
				type: "POST",
				url: "admin.action",
				data: {},
				success: function (html) {
					$("#content").html(html);
				}
			});
		});
		</c:if>

	<c:if test="${ur != ur1}">
		$("input[id=edit]").css({visibility: "hidden", display: " "});
	</c:if>


	$(document).ready(function(){

		$("#begtest").click(function(){
			testid = $("input[type=radio]:checked").val();
			$.ajax({
				type: "POST",
				url: "test.action",
				data: {testid : testid},
				success: function(html){
					$("#content").html(html);
				}
			});
		});

		$("#myresults").click(function(){
			$.ajax({
				type: "POST",
				url: "userResults.action",
				data: {},
				success: function(html){
					$("#content").html(html);
				}
			});
		});
	});


</script>