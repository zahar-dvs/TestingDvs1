<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="userResults" align="center">
  Результаты ${username}:
  <table border="1">
    <tr>
      <th>Номер теста</th>
      <th>Ваш результат</th>
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
    </tr>
  </table>
  <td>
    <input id="return" type="button" value="Вернуться"/>
  </td>
</div>

<script type="text/javascript">
  $(document).ready(function(){
            $('#return').click(function(){

                      $.ajax({
                        type: "POST",
                        url: "showtest.action",
                        data: {},
                        success: function(html){
                          $("#content").html(html);
                        }
                      });
                    }
            )
          }
  )
</script>