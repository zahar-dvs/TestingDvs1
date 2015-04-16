<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="result" align="center">
	<table border="1">
		<tr>
			<th>Вопросы</th>
			<th>Ваши ответы</th>
			<th>Правильные ответы</th>
		</tr>
		<tr>
			<td>
				<c:forEach items="${questions}" var="questions">
					${questions}
					<br>
				</c:forEach>
			</td>
			<td>
				<c:forEach items="${currAnswers}" var="currAnswers">
					${currAnswers}
					<br>
				</c:forEach>
			</td>
			<td>
				<c:forEach items="${correctAnswers}" var="correctAnswers">
					${correctAnswers}
					<br>
				</c:forEach>
			</td>
		</tr>
	</table>
	Вы правильно ответили на ${result} вопросов, и набрали ${result} очков!!!

