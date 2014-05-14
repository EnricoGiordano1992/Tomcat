import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//import com.sun.org.apache.bcel.internal.generic.DMUL;

import did.*;

/**
 * Questa classe gestisce le richieste riguardanti le ricerche all'interno della
 * base di dati. Risponde solamente a richieste HTTP di tipo GET. I possibili
 * parametri che vengono considerati e le relative azioni effettuate sono le
 * seguenti:
 * <br>
 * <ol>
 *   <li>nessun parametro: viene visualizzata la lista dei corsi di studio esistenti;</li>
 *   <li>parametro 'id': vengono visualizzate le informazioni (compresa la/le facoltà di appartenenza) 
 *       del corso di studi con l'id specificato.</li>
 * </ol>
 */
public class ServletCorsoStudiB extends HttpServlet {

    /**
     * Questo metodo risponde alle richieste HTTP di tipo GET. Elabora le richieste, impostando
     * gli eventuali attributi necessari, e ridirige la visualizzazione alle pagine jsp relative.
     *
     * @param request Oggetto HttpServletRequest dal quale ottenere informazioni circa la
     *                richiesta effettuata.
     * @param response Oggetto HttpServletResponse per l'invio delle risposte.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

		//Definizione e recupero dell'eventuale parametro della servlet
		String id = "";
		String annoaccademico = "";
		
		if (request.getParameter("id") != null) {// Ottengo se presente il parametro 'id'
			id = request.getParameter("id");
		}
		
		if (request.getParameter("annoaccademico") != null)
			annoaccademico = request.getParameter("annoaccademico");
	
		try {
			// Oggetto per l'interazione con il Database
			DBMS dbms = new DBMS();
			
			//Definizione dello stream di output
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=ISO-8859-1");
	
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"");
			out.println("      \"http://www.w3.org/TR/REC-html40/loose.dtd\">");
			out.println("<html>");
			out.println("<head>");
			
			// Determino la pagina da visualizzare
			if (annoaccademico.equals("") && id.equals("")) {           //recupero e visualizzo tutti i corsi di studio disponibili
				
				//Delego l'esecuzione della query alla classe di interazione con il DB
				//Recupero il risultato della query come un Vector contenente dei bean
//				Vector css = dbms.getCorsiStudi();
				Vector css = dbms.getCorsoStudioConDipartimenti();
				out.println("<title>Corsi di Studio Esistenti</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Corsi di Studio Esistenti:</h1>");
				out.println("<table borderspace=10>");
				out.println("<tr><th>Codice</th><th>Nome</th><th>Dipartimento</th></tr>");			
				
				for (int i=0; i<css.size(); i++) {
					CorsoStudiBean csb =(CorsoStudiBean) css.get(i);
/*					out.println("<tr><td><a href=\"ServletCorsoStudiB?id="+csb.getId()+"\">"
							+csb.getCodice() + "</a></td><td>" + csb.getNomeCorsoStudi()+"</td></tr>");
*/
					
					out.println("<tr><td><a href=\"ServletCorsoStudiB?id="+csb.getId()+"\">"
							+csb.getCodice() + "</a></td><td>" + csb.getNomeCorsoStudi() + 
							"</td><td>"+ csb.getDipartimento() + "</td></tr>");					
				
				}
	
				out.println("</table>");
			}
			else if(annoaccademico.equals("") && !id.equals("")) {		//recupero e visualizzo le informazioni sul corso di studio con l'id specificato
				//Innanzittutto recupero le info presenti nella tabella CorsoStudi	
				Vector vcs = dbms.getCorsoStudi(Integer.parseInt(id));
				//il Vector conterrà un solo bean che quindi recupero subito
				CorsoStudiBean csb = (CorsoStudiBean)vcs.get(0);
				//Recupero poi la/e facoltà (possono essere più di una per i corsi interfacoltà) 
				//come un Vector contenente i nomi delle facoltà (non bean)
				Vector csf = dbms.getFacoltaCorso(Integer.parseInt(id));
				
				Vector anniinsb = dbms.getAAErogazioni(Integer.parseInt(id));
				
				
				//Utilizzando le info sul corso genero la pagina HTML di output
				out.println("<title>Informazioni su un Corso di Studio</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>"+csb.getNomeCorsoStudi()+"</h2>");
				out.println("<ul><li><b>Codice</b>: "+csb.getCodice()+"</li>");
				out.println("<li><b>Abbreviazione</b>: "+csb.getAbbreviazione()+"</li>");
				out.println("<li><b>Durata anni</b>: "+csb.getDurataanni()+"</li>");
				out.println("<li><b>Sede</b>: "+csb.getSede()+"</li>");
				out.println("<li><b>Dipartimento</b>:" + csb.getDipartimento() + "</li>");
				out.println("<li><b>Anno Accademico</b>: ");

				for (int j=0; j<anniinsb.size(); j++)
					out.println("<br><a href=\"ServletCorsoStudiB?id="+ id +"&annoaccademico=" + (String)anniinsb.get(j) + "\">" + anniinsb.get(j) + "</a><br> ");
				
				out.println("</li>");
				
				out.println("<li><b>Facoltà</b>: ");
				
				for (int j=0; j<csf.size(); j++) {
					out.println((String)csf.get(j)+", ");
				}
				out.println("</li>");				
				
				out.println("<li><b>Informativa</b>: "+csb.getInformativa()+"</li></ul>");
				
				//Visualizzo anche un link alla lista dei corsi di studi
				out.println("<a href=\"ServletCorsoStudiB\"><font color=\"00AA00\">Back</font></a>");
	
			}
			
			
			else {
				
				//Delego l'esecuzione della query alla classe di interazione con il DB
				//Recupero il risultato della query come un Vector contenente dei bean
				Vector iebv = dbms.getInsegnamentiErogati(Integer.parseInt(id), annoaccademico);
				out.println("<title>Insegnamenti per l'anno " + annoaccademico + "</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Insegnamenti per l'anno " + annoaccademico + ":</h1>");
				out.println("<table CELLSPACING=20>");
				out.println("<tr><th>Nome</th><th>Codice</th><th>Crediti</th><th>Discriminante</th><th>NomeModulo</th><th>disc. modulo</th>" +
						"<th>NomeUnita'</th></tr>");			
				
				for (int i=0; i<iebv.size(); i++) {
					InsErogatoBean ieb =(InsErogatoBean) iebv.get(i);

					out.println("<tr><td>" + ieb.getNomeFromInsegn() + "</td>" +
							"<td>"+ ieb.getCodiceFromInsegn() + "</td>" + 
							"<td>"+ ieb.getCreditiFromInsErogato() + "</td>" +
							"<td>"+ ieb.getDiscFromInsErogato() + "</td>" +
							"<td>"+ ieb.getNomeModuloFromInsErogato() + "</td>" +
							"<td>"+ ieb.getDiscFromInsErogato() + "</td>" +
							"<td>"+ ieb.getNomeUnitaFromInsErogato() + "</td>" +
							
							
							
							 "</tr>");					
				
				}
	
				out.println("</table>");

				
				
			}
			
			//Termino la pagina HTML
			out.println("</body>");
			out.println("</html>");
			
		} catch(Exception e) {  //Gestisco eventuali eccezioni visualizzando lo stack delle chiamate
			e.printStackTrace();
		}
    }
}
