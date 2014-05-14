/*
  Importo i package di i/o per utilizzare la classe PrintWriter
  ed avere a disposizione l'eccezione IOException.
*/
import java.io.*;

/*
  Importo i package relativi alle servlet.
*/
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * ServletExample. Questa semplice servlet mette in evidenza la struttura di una Servlet.
 * Viene invocata in seguito ad una richiesta HTTP GET.
 *
 * @author Filippo Manganotto
 * @author Barbara Oliboni
 * @version 1.0   16/04/2003
 */
public class ServletHelloWWW extends HttpServlet { 
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException { 

	response.setContentType("text/html; charset=ISO-8859-1"); 
	PrintWriter out = response.getWriter(); 
	String docType =
	    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01" +
	    "Transitional//EN\">\n";
	out.println(docType +
		    "<HTML>\n" +
		    "<HEAD><TITLE>Hello World </TITLE></HEAD>\n" +
		    "<BODY>\n" +
		    "<H1> Hello World </H1>\n" +
		    "</BODY></HTML>");
    }
}


