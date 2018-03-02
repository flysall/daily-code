import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ReadParams extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Reading All from Parameters";
        String docType =
                     "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
         out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n" +
         "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
         "<tr bgcolor = \"#949494\">\n" +
            "<th>Param Name</th><th>Param Value(s)</th>\n"+
         "</tr>\n"
      	);
		
		Enumeration paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n</tr>");
            String[] paramValues = request.getParameterValues(paramName);
            // Read single valued data

            if(paramValues.length == 1) {
                String paramValue = paramValues[0];
                if(paramValue.length() == 0) 
                    out.println("<i>No Value</i>");
                else
                    out.println(paramValue);
            } else{
                out.println("<ul");
                for(int i = 0; i < paramValues.length; i++) 
                    out.println("<li>" + paramValues[i] + "</li>");
                out.println("</ul>");
            }
        }
        out.println("</tr>\n</table>\n</body></html>");
	}	
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        doGet(request, response);
    }
}
	
