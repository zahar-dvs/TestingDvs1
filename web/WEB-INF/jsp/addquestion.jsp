<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="content">
  <table align="center">
    <tr>
      <td>
        Вопрос:
      </td>
      <td>
        <textarea id="question" type="text" cols="50" rows="5"/>
      </td>
    </tr>
    <tr>
      <td>
        Ответ 1:
      </td>
      <td>
        <textarea id="answer1" type="text" cols="50"/>
      </td>
    </tr>
    <tr>
      <td>
        Ответ 2:
      </td>
      <td>
        <textarea id="answer2" type="text" cols="50"/>
      </td>
    </tr>
    <tr>
      <td>
        Ответ 3:
      </td>
      <td>
        <textarea id="answer3" type="text" cols="50"/>
      </td>
    </tr>
    <tr>
      <td>
        Ответ 4:
      </td>
      <td>
        <textarea id="answer4" type="text" cols="50"/>
      </td>
    </tr>
    <tr>
      <td colspan=2 align="center">
        <input id="save" type="button" value="Сохранить">
      </td>
    </tr>
    <tr>
      <td colspan=2 align="center">
        <input id="return" type="button" value="Вернуться">
      </td>
    </tr>
  </table>
</div>

<script type="text/javascript">

  $(document).ready(function(){

    $("#save").click(function(){
      if (($("#question").val() == "") || ($("#answer1").val() == "") || ($("#answer2").val() == "")) {
        alert("Введите вопрос и по крайней мере 2 первых ответа");
      } else {
        $.ajax({
          type: "POST",
          url: "savequestion.action",
          data: {
            question: $("#question").val(),
            answer1: $("#answer1").val(),
            answer2: $("#answer2").val(),
            answer3: $("#answer3").val(),
            answer4: $("#answer4").val()
          },
          success: function (html) {
            $("#content").html(html);
          }
        });
      }
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