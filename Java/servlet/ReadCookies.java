import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadCookies extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;

        cookies = request.getCookies();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Reading Cookies Example";
		String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
		out.println(docType + 
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n");
        if(cookies != null) {
            out.println("<h2> Found Cookies Name and Value</h2>");
            for(int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.println("Name: " + cookie.getName() + ", ");
                out.println("Value: " + cookie.getValue() + "<br/>");
            }
        } else {
            out.println("</body></html>\n");
        }
    }
}

