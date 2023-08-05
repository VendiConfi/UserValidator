<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <div class="user-form">
        <h1 style="margin-left:115px"><i>User</i></h1>
        <form action="register" method="post">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="n" placeholder="Please enter your name"></td>
                </tr>
                <tr>
                    <td>Employee ID</td>
                    <td><input type="text" name="id" placeholder="Please enter your employee ID"></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="add" placeholder="Please enter your address"></td>
                </tr>
                <tr>
                    <td>Date of Joining</td>
                    <td><input type="text" name="doj" placeholder="Please enter your date of joining"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="sub" value="Submit"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
<style>
    body {
        background-color: rgba(0, 0, 0, 1);
    }
    .user-form {
        background-color: rgba(205.06250202655792, 205.06250202655792, 205.06250202655792, 0.800000011920929);;
        position: absolute;
        left: 458px;
        top: 232px;
        margin-left: 310px;
        height: 500px;
    }
    .user-form h1 {
        margin-left: 85px;
    }
    .user-form table {
        margin-top: 100px;
        margin-bottom: 20px;
    }
    .user-form input[type="text"],
    .user-form input[type="password"] {
        width: 200px;
    }
    .user-form input[type="submit"] {
        margin-top: 20px;
    }
</style>
</html>
