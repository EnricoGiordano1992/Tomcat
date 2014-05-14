import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class
ServletHelloWWW
extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws IOException, ServletException
{
response.setContentType("text/html; charset=ISO-8859-1");
PrintWriter out = response.getWriter();
String docType =
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01" + "Transitional//EN\">\n";
    out.println(docType +"<HTML>\n" + 
                        "<HEAD>"+
                            "<TITLE> Hello World </TITLE>"+
                        "</HEAD>\n" + 

                        "<BODY>\n" + 
                            "<H1> Hello World </H1>\n" + 
                        "</BODY></HTML>");
}
} 
