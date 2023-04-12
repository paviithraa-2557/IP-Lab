import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;


public class display extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
           
            stmt = conn.createStatement();

           
            String sql = "Select * from stu";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String id = rs.getString("id");
                String name = rs.getString("name");
                String grade = rs.getString("grade");
                String mark = rs.getString("mark");
                
                out.println("<p> ID: " + id + "<br>");
                out.println("Name: " + name + "<br>");
                out.println("Grade: " + grade + "<br>");
                out.println("Mark " + mark + " %<br></p>");
            }
            out.println("</body></html>");
            rs.close();
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Error connecting to DB - Error:" + e);
        }
    }
}
