<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="content">
 <table align="center">
 	<tr>
 		<td>
 			UserName :
 		</td>
 		<td>
 			<input id="username" type="text"/>
 		</td>
 	</tr>
 	<tr>
 		<td>
 			Password :
 		</td>
 		<td>
 			<input id="password" type="password"/>
 		</td>
 	</tr>
 	<tr>
 		<td>
 			<input id="login" type="button" value="LogIn"/>
 		</td>
 		<td align="right">
 			<input id="register" type="button" value="Register"/>
 		</td>
 	</tr>
 	<tr>
 		<td colspan=2 align="center">
 			<input id="reset" type="button" value="Reset">
 		</td>
 	</tr>
 </table>
</div>



 <script type="text/javascript">
 	$(document).ready(function(){

 		$("#reset").click(function(){
 			$("input[type=text]").val("");
 			$("input[type=password]").val("");
 		});

 		$("#register").click(function(){
 			if (($("#username").val() == "") || ($("#password").val() == "")){
 	 			alert("Не указан логин или пароль!");
 	 		} else {
 				$.ajax({
 					type: "POST",
 					url: "register.action",
 					data: {username: $("#username").val(), password: $("#password").val()},
 					success: function(html){
 					$("#content").html(html);
 					}
 				});
 	 		};
 		});

 		$("#login").click(function(){
 			if (($("#username").val() == "") || ($("#password").val() == "")){
 	 			alert("Не указан логин или пароль!");
 	 		} else {
 				$.ajax({
 					type: "POST",
 					url: "login.action",
 					data: {username: $("#username").val(), password: $("#password").val()},
 					success: function(html){
 						$("#content").html(html);
 					}
 				});
 	 		};
 		});

 	});
 </script>