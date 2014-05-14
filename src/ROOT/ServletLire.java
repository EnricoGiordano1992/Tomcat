/*
  Importo i package di i/o per utilizzare la classe PrintWriter
  ed avere a disposizione l'eccezione IOException.
*/
import java.io.*;
import java.text.*;

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
public class ServletLire extends HttpServlet {
    private static final DecimalFormat FMT = new DecimalFormat("#0.00");
    /** Valore da utilizzare per ottenere la conversione. */
    private static final double VALORE = 1936.27;

    /**
     * Costruttore di default della classe. Non compie nessuna operazione, crea 
     * solamente un nuovo oggetto.
     */
    public ServletLire() {
    }

    /**
     * Questo metodo viene richiamato in risposta ad una richiesta HTTP di tipo GET.
     * Ottiene lo stream di output e scrive sullo stesso il codice HTML da visualizzare
     * nel browser.
     *
     * @param request Oggetto che incapsula la richiesta HTTP effettuata dal client.
     * @param response Oggetto che permette alla Servlet di impostare lo stato e l'header.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
	/* 
	   Ottengo lo stream di output su cui inviare il codice HTML da 
	   visualizzare. 
	*/
	PrintWriter out = response.getWriter();
	// Imposto il tipo di output
	response.setContentType("text/html");
	// Scrivo sullo stream di output il codice HTML da visualizzare
	out.println("<html>");
	out.println("  <head>");
	out.println("    <title>Servlet di prova</title>");
	out.println("  </head>");
	out.println("  <body bgcolor=\"white\">");
	out.println("    <h1 align=\"center\">Conversione Euro-Lire </h1>");
	out.println("    <table border=\"1\" cellspacing=\"5\" cellpadding=\"5\" align=\"center\" summary=\"Conversione\">");
	out.println("      <tr>");
	out.println("        <th>Euro</th>");
	out.println("        <th>Lire</th>");
	out.println("      </tr>");
	// Ciclo per stampare la conversione
	for (double i=1; i<=10; i++) {
	    out.println("      <tr>");
	    out.println("        <td align=\"center\">" + FMT.format(i) + "</td>");
	    out.println("        <td align=\"center\">" +  FMT.format(VALORE * i) + "</td>");
	    out.println("      </tr>");
	}
	out.println("    </table>");
	out.println("  </body>");
	out.println("</html>");
	// Chiudo lo stream di output
	out.close();
    }
}
