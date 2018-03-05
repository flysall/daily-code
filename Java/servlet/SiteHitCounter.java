import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SiteHitCounter implements Filter {
    private int hitCount;
    
    public void init(FilterConfig config) throws ServletException {
        hitCount = 0;
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
        throws IOException, ServletException {
        hitCount++;
        System.out.println("Site visits count: " + hitCount);
        chain.doFilter(request, response);
    }

    public void destroy() {
    
    }
}
