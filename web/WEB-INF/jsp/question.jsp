<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="question" align="center">
Вопрос: <br>
<textarea cols="100" rows="5">
${question.question}
</textarea>
<br>
<c:forEach items="${answ}" var="answ">
		<input type="radio" name="answer" value="${answ.id}">${answ.answer}
		<br>
</c:forEach>
	</div>