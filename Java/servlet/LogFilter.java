import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class LogFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Get init parameter
        String testParam = config.getInitParameter("test-param");   
        System.out.println("Test Param: " + testParam);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
        IOException, ServletException {
        // Get ip of client machine
        String ipAddress = request.getRemoteAddr();
        // Log
        System.out.println("IP " + ipAddress + ", Time " + new Date().toString());
        chain.doFilter(request, response);
    }

    public void destroy() {
        // TODO
    }
}

