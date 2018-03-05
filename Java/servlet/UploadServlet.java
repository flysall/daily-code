import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

import org.apache.logging.log4j.*;

public class UploadServlet extends HttpServlet {
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 1024 * 1024;
    private int maxMemSize = 1024 * 1024;
    private File file;
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public void init() {
        logger.info("You init a servlet name UploadServlet");
        filePath = getServletContext().getInitParameter("file-upload");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        logger.info("UploadServlet.doPost()=============================================================================");
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(!isMultipart) {
            out.println("<html>" +
                    "<head>" +
                    "<title>Servlet upload</title</title>" +
                    "</head>" +
                    "<body>" +
                    "<p>No file uploaded</p>" +
                    "</body></html>");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);

        // Location 
        factory.setRepository(new File("/tmp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(maxFileSize);

        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            Iterator<FileItem> i =fileItems.iterator();
            out.println("<html>" +
                    "<head><title>Servlet upload</title>" +
                    "</head>" +
                    "<body>");
            while(i.hasNext()) {
                FileItem fi = i.next();
                if(!fi.isFormField()) {
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    // Display in tomcat:
                    logger.info("fileName is: " + fileName + "\nfieldName is: " + fieldName);
                    logger.info("current filePath is: " + filePath);
                    

                    if(fileName.lastIndexOf("/") >= 0) {
                        filePath = filePath + fileName.substring(fileName.lastIndexOf("/"));
                    } else {
                        filePath = filePath + fileName.substring(fileName.lastIndexOf("/") + 1);
                    }
                    logger.info("final filePath is: " + filePath);
                    file = new File(filePath);
                    fi.write(file);
                    out.println("Uploaded FileName: " + fileName + "<br>");
                }
            }
            out.println("</body></html>");
        } catch(Exception ex) {
            System.out.println(ex);
        }
        logger.info("=============================================================================================");
    }

    public void  doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        throw new ServletException("Get method used with " +
                getClass().getName() + ": POST method required.");
    }
}
