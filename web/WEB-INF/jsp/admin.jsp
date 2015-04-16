<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Добавление вопросов</title>
</head>
<body>

<div id="content" align="center" margin = 40>
    <c:forEach items="${tests}" var="tests">
    <input type="radio" name="test" value="${tests.id}"> ${tests.name}
    <br/>
    </c:forEach>

        <br>
        <input type="button" value="Добавить вопрос" id="addquestion">
        <br>
        <br>
        <input type="button" value="Вернуться" id="return">
        <br>
        
</div>
        <script type="text/javascript">

            $(document).ready(function(){

                $("#addquestion").click(function(){
                    testid = $("input[type=radio]:checked").val();
                        $.ajax({
                            type: "POST",
                            url: "addquestion.action",
                            data: {testid : testid},
                            success: function(html){
                                $("#content").html(html);
                            }
                        });
                  });
                $("#return").click(function(){
                    $.ajax({
                        type: "POST",
                        url: "showtest.action",
                        data: {},
                        success: function(html){
                            $("#content").html(html);
                        }
                    });
                });
            });

        </script>


















<%--<c:forEach items="${users}" var="users">--%>
    <%--${users}--%>
    <%--<br>--%>
<%--</c:forEach>--%>
<%--<c:if test="${!empty users}">--%>
    <%--<table class="data">--%>
        <%--<tr>--%>
            <%--<th>Пользователь</th>--%>
            <%--<th>&nbsp;</th>--%>
        <%--</tr>--%>
        <%--<c:forEach items="${users}" var="user">--%>
            <%--<tr>--%>
                <%--<td>${user.username}</td>--%>
                <%--<td><input type="button" value="Редактировать" id="edit"></td>--%>
                <%--<td><input type="button" value="Удалить" id="delete"></td>--%>
            <%--</tr>--%>
            <%--<script>--%>
                <%--$(document).ready(function(){--%>

                    <%--$("#edit").click(function(){--%>
                    <%--testid = $("input[type=radio]:checked").val();--%>
                    <%--$.ajax({--%>
                    <%--type: "POST",--%>
                    <%--url: "edit.action",--%>
                    <%--data: {user : ${users.id}},--%>
                    <%--success: function(html){--%>
                    <%--$("#content").html(html);--%>
                    <%--}--%>
                    <%--});--%>
                    <%--});--%>

                    <%--$("#delete").click(function(){--%>
                        <%--$.ajax({--%>
                            <%--type: "POST",--%>
                            <%--url: "delete.action",--%>
                            <%--data: {userid : 75},--%>
                            <%--success: function(html){--%>
                                <%--$("#content").html(html);--%>
                            <%--}--%>
                        <%--});--%>
                    <%--});--%>
                <%--});--%>
            <%--</script>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
<%--</c:if>--%>


</body>
</html>