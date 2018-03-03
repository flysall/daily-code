import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteCookies extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;

        cookies = request.getCookies();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String  title = "Delete Cookies Example";
        String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n");
        if(cookies != null) {
            out.println("<h2> Cookies Name and Value</h2>");
            for(int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if(cookie.getName().compareTo("first_name") == 0) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.println("Delete cookie: " + cookie.getName() + "<br/>");
                } 
                out.print("Name: " + cookie.getName() + ", ");
                out.print("Value: " + cookie.getValue() + "<br/>");
            }
        } else {
            out.println("<h2>No cookies founds</h2>");
        }
        out.println("</body>\n" + "</html>");
    }
} 
