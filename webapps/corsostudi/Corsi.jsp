<!--	Corsi.jsp: 
	La JSP visualizza la lista di tutti i corsi di studio attivi e gestiti da un
	diparitmento passato come parametro idDip.
-->

<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="did.*"%>
<%@page errorPage="error.jsp"%>
<%@ page isErrorPage="false" %>
<html>
<% 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
   // did2013
    DBMS dbms = new DBMS();
    int ccs;
    //Ottengo l'eventuale parametro
    String idDip;
    if (request.getParameter("idDip") != null) // Ottengo se presente il parametro 'idDip'
	    idDip = (String)request.getParameter("idDip");
    else
	    idDip = "";

    //A seconda della presenza o meno del parametro la JSP varia il proprio comportamento
    if (idDip.equals("")) {  //parametro vuoto o assente: messaggio d'errore

%> 
	    <h2>Inserire il codice per gestire la mancanza del parametro idDip</h2>
       

<%
    } else { 
%>
<%	    // E' presente il parametro idDip.
	    // Si devono mostrare i dati dei corsi attivi nel dipartimento con id=idDip.
	    // -------------------------------------------------------------------------
	    // TODO
	    // INSERIRE IL CODICE PER L'ESTRAZIONE DEI DATI ATTRAVERSO I METODI 
	    // DELL'OGGETTO dbms E LA GENERAZIONE DEL CODICE HTML IN CUI SI PRESENTA
	    // L'ELENCO DEI CORSI DI STUDIO ATTIVI PRESSO IL DIPARTIMENTO
	    // ------------------------------------------------------------------------- %>

<% 
            Vector iddid = dbms.getIdDid(Integer.parseInt(idDip)); %>

            <%= iddid.size() %>
<%
            IdDidBean iddidb;
%>

<title>Corsi di Studio Esistenti</title>

<body>
<h1>Corsi di studio attivi gestiti dal dipartimento</h1>

<% for (int i = 0; i < iddid.size(); i++)
{
     iddidb = (IdDidBean) iddid.get(i); 
%>

    <ul>

    <li> <%= iddidb.getNomeDip() %> </li>

    <li> <%= iddidb.getCodice() %> </li> 

    <li> <%= iddidb.getNomeCorso() %> </li> 
    
    <li> <%= iddidb.getDurata() %> </li>

    <li> <%= iddidb.getSede() %> </li>

    <li> <%= iddidb.getInformativa() %> </li>

    <li> <%= iddidb.getNumIns() %> </li>

    <li> <%= iddidb.getCreditiTot() %> </li>

    </ul>
        <% }} %>


<a href="Corsi.jsp"><font color="00AA00">Back</font></a>

</body>
</html>
