import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HitCount extends HttpServlet {

    private int hitCount = 0;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        hitCount++;
        PrintWriter out = response.getWriter();
        

        out.println("<html>");
        out.println("<body>");
        out.println("<h1 align = 'center'>Number of hits</h1>");
        out.println("<h2 align = 'center'>" + hitCount + "</h2>");
        out.println("</body></html>");
    }

}