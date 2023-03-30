import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Grade extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello " + name + "</h1>");
        out.println("<p>Your grade is" + grade + "</p><br>");
        out.println("<form action='./mark' method='get'>");
        out.println("<label for='name'>Name:</label>");
        out.println("<input type='hidden' id='name' name='name' value="+name+"><br>");
        out.println("<label for='grade'>Grade:</label>");
        out.println("<input type='hidden' id='grade' name='grade' value=" +grade+ "><br>");
        out.println("<label for='mark'>Mark:</label>");
        out.println("<input type='number' id='mark' name='mark'><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}