import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Mark extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");
        String mark = request.getParameter("mark");
        out.println("<html>");
        out.println("<body>");
        out.println("<p>Hey " + name + "</p>");
        out.println("<p>Your grade is " + grade + "</p>");
        out.println("<p>Your mark is "+ mark +"</p>");
        out.println("</body>");
        out.println("</html>");
    }
}