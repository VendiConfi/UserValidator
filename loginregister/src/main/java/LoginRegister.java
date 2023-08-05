import java.sql.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRegister() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Load the MySQL JDBC driver (if not already loaded)
            Class.forName("com.mysql.jdbc.Driver");

            // Create a connection to the database
            Connection con = DriverManager.getConnection("");

            String username = request.getParameter("name");
            String password = request.getParameter("password");

            // Prepare a SQL query to retrieve the username from the user table
            PreparedStatement ps = con.prepareStatement("SELECT username, role FROM user WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);

            // Execute the query and get the result set
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                if (role.equals("validator")) {
                    RequestDispatcher rd = request.getRequestDispatcher("validator.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
                    rd.forward(request, response);
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("lgin.jsp");
                rd.forward(request, response);
            }

            // Close the result set, statement, and connection
            rs.close();
            ps.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            // Handle the exceptions here
            e.printStackTrace();
            // You can redirect to an error page or display an error message to the user
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

