<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="content" align="center">
  Выбери правильный ответ для своего вопроса:
  <br>
  <c:forEach items="${answers}" var="answers">
  <input type="radio" name="answers" value="${answers.id}">${answers.answer}
  <br>
  </c:forEach>
  <br>
  <input type="button" value="Сохранить" id="savecorrect">
</div>
<script>
  $(document).ready(function(){

    $("#savecorrect").click(function(){
      correct = $("input[type=radio]:checked").val();
      $.ajax({
        type: "POST",
        url: "savecorrect.action",
        data: {correct : correct},
        success: function(html){
          $("#content").html(html);
        }
      });
    });
  });

</script>
