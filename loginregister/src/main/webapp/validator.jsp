<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="loginregister.UserDTO" %> <!-- Import the UserDTO class -->
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Validator Page</title>
</head>
<body>
<div class="table">
    <table border="1">
        <tr>
            <td>Name</td>
            <td>EmployeeID</td>
            <td>Address</td>
            <td>Date of joining</td>
            <td>Status</td>
        </tr>

        <%
        try {
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bpaas", "root", "shivansh");
            Statement st = con1.createStatement();
            String str = "select * from users";
            ResultSet rs = st.executeQuery(str);
            while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getString("name") %></td>
                    <td><%= rs.getString("employee_id") %></td>
                    <td><%= rs.getString("address") %></td>
                    <td><%= rs.getString("doj") %></td>
                    <td>
    <%
    String status = rs.getString("status");
    if (status.equals("verified")) {
        out.print("Already verified");
    } else {
        String employeeId = rs.getString("employee_id");
    %>
        <form action="validator" method="GET">
            <input type="hidden" name="employee_id" value="<%= employeeId %>">
            <button type="submit">Verify</button>
        </form>
    <%
    }
    %>
</td>
                </tr>
                <%
            }
        } catch (Exception e) {
            
        } finally {
            
            try {
            	 Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bpaas", "root", "shivansh");
                 Statement st = con1.createStatement();
                 String str = "select * from users";
                 ResultSet rs = st.executeQuery(str);
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con1 != null) con1.close();
            } catch (Exception e) {
                // Handle exceptions here (print or log them)
            }
        }
        %>
    </table>
</div>
</body>
<style>
    body {
        background-color: rgba(0, 0, 0, 1);
    }

    .table {
        background-color: rgba(205.06250202655792, 205.06250202655792, 205.06250202655792, 0.800000011920929);;
        position: absolute;
        left: 458px;
        top: 292px;
        margin-left: 210px;
    }
</style>
</html>
