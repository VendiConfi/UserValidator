import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
//import loginregister.UserDTO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;

@WebServlet("/register") // Corrected mapping
public class register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public register() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	System.out.println("entered"+request.getParameter(" n "));
    	
//    	
//      String na = request.getParameter("n");
//      String eid = request.getParameter("id");
//      String add = request.getParameter("add");
//      String dateoj = request.getParameter("doj");
//      PrintWriter out=response.getWriter();
//      out.print(na);
//      out.print
    
        try {
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bpaas", "root", "shivansh");
            String na = request.getParameter("n");
            String eid = request.getParameter("id");
            String add = request.getParameter("add");
            String dateoj = request.getParameter("doj");
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO users (name, employee_id, address, doj) VALUES (?, ?, ?, ?)";
                ps = con1.prepareStatement(query);
                ps.setString(1, na);
                ps.setString(2, eid);
                ps.setString(3, add);
                ps.setString(4, dateoj);
                ps.executeUpdate();
                
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                    	e.printStackTrace();
                    }
                }
            }
            con1.close();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
        rd.forward(request, response);

        doGet(request, response);
    }
}
