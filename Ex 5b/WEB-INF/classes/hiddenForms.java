import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class hiddenForms extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
    
        out.println("<body>");
        out.println("<form action='./grade' method='get'>");
        out.println("<label for='name'>Name:</label>");
        out.println("<input type='text' id='name' name='name'><br>");
        out.println("<label for='grade'>Grade:</label>");
        out.println("<input type='text' id='grade' name='grade'><br>");
        out.println("<label for='mark'>Mark:</label>");
        out.println("<input type='hidden' id='mark' name='mark'><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}