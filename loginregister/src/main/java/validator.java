

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class validator
 */
@WebServlet("/validator")
public class validator extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String employeeId = request.getParameter("employee_id");
            if (employeeId != null && !employeeId.isEmpty()) {
                // Connect to the database
                Connection con = DriverManager.getConnection("");
                
                // Update the status to "verified" in the database
                String updateQuery = "UPDATE users SET status = 'verified' WHERE employee_id = ?";
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.setString(1, employeeId);
                int rowsAffected = ps.executeUpdate();
                
                // Close the database resources
                ps.close();
                con.close();
                
                if (rowsAffected > 0) {
                    RequestDispatcher rd=request.getRequestDispatcher("validator.jsp");
                    rd.forward(request, response);
                    
                } else {
                    out.println("<h2>No user found with the given Employee ID.</h2>");
                }
            } else {
                out.println("<h2>Employee ID parameter is missing.</h2>");
            }
        } catch (Exception e) {
            out.println("<h2>Error occurred: " + e.getMessage() + "</h2>");
        }
    }
}
