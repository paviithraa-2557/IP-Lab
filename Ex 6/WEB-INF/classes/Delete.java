import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Delete extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        int DeptID=request.getParameter("deptid");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
            if (conn != null) {
                out.println("<h1> No issues in Connection</h1>");
            }

            int result = 0;

            PreparedStatement preparedStatement = conn.prepareStatement("delete from department where DeptID =?");
            preparedStatement.setInt(1, DeptID);
            result = preparedStatement.executeUpdate();

            // close the database connection
            conn.close();
            if (result == 1)
                out.println("<p> Student with Department ID " + DeptID + " is removed </p> <br>");

        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
}