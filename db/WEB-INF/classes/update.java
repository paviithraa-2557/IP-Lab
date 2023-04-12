import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class update extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String mark = request.getParameter("mark");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
           
            stmt = conn.createStatement();
            String sql = "UPDATE stu SET mark='" + mark + "' WHERE name='" + name + "'";
            int rowsAffected = stmt.executeUpdate(sql);
            if (rowsAffected > 0) {
                out.println("<h2> data updated!! </h2>");
            } 
             stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Error connecting to DB - Error:" + e);
        }
    }
}
