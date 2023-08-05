<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
<div class="login">
<form action="LoginRegister" method="post">
<h1 style="margin-left:85px"><i>Login</i></h1>

<table>
<tr><td><div class="username">Username</div></td><td><div class="data"><input type="text" name="name" placeholder="Please enter your username"></div></td></tr>
<tr><td>Password</td><td><input type="password" name="password" placeholder="Please enter your password"></td></tr>
<tr><td><input type="submit" name="submit" value="login"></td></tr>


</table>
</form>
</div>

</body>
<style>
body{
background-color:rgba(0, 0, 0, 1);
}
.username{
margin-top:100px;
margin-bottom:20px;
}
.data
{
margin-top:100px;
margin-bottom:20px;
}
.login{
background-color:rgba(205.06250202655792, 205.06250202655792, 205.06250202655792, 0.800000011920929);
position:absolute;
left:458px;
top:232px;
margin-left: 310px; 
height:500px;
}

</style>
</html>