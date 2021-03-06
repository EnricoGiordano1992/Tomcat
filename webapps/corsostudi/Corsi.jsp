<!--	Corsi.jsp: 
	La JSP visualizza la lista di tutti i corsi di studio attivi e gestiti da un
	diparitmento passato come parametro idDip.
-->

<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="did.*"%>
<%@page errorPage="error.jsp"%>
<%@page isErrorPage="false" %>
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

<%
            IdDidBean iddidb;
%>

<title>Corsi di Studio Esistenti</title>

<body>

    <% iddidb = (IdDidBean) iddid.get(0); %>

    <h1>Corsi di studio attivi gestiti dal dipartimento ''<%= iddidb.getNomeDip() %>'' </h1> <br>
    <h2>CORSI DI LAUREA: </h2><br>


<% for (int i = 0; i < iddid.size(); i++)
{
    if(i != 0)
        iddidb = (IdDidBean) iddid.get(i); 

    //cerco le lauree
    if((iddidb.getId_tipocs() == 5 || iddidb.getId_tipocs() == 20 ) &&(iddidb.getCreditiTot() > 1 && iddidb.getNumIns() > 1)) {    
%>

    


     <%= iddidb.getCodice() %> - <%= iddidb.getNomeCorso() %> 

    <ul>
    
    <li> <b> Durata anni: </b> <%= iddidb.getDurata() %> </li>

    <li> <b>Sede:</b> <%= iddidb.getSede() %> </li>

    <li> <b>Presentazione:</b> <br><br><%= iddidb.getInformativa() %> </li>

    <li> <b>Numero insegnamenti attivi nell'anno 2013/2014:</b> <%= iddidb.getNumIns() %> </li>

    <li> <b>Numero totale crediti erogati nell'anno 2013/2014:</b> <%= iddidb.getCreditiTot() %> </li>

    </ul>
        <% }} %>


    <h2>CORSI DI LAUREA MAGISTRALE: </h2><br>


<% for (int i = 0; i < iddid.size(); i++)
{
    iddidb = (IdDidBean) iddid.get(i);

    //cerco le lauree magistrali     
    if((iddidb.getId_tipocs() == 25 || iddidb.getId_tipocs() == 23)  &&(iddidb.getCreditiTot() > 1 && iddidb.getNumIns() > 1)) {
%>

     <%= iddidb.getCodice() %> - <%= iddidb.getNomeCorso() %> 

    <ul>
    
    <li> <b> Durata anni: </b> <%= iddidb.getDurata() %> </li>

    <li> <b>Sede:</b> <%= iddidb.getSede() %> </li>

    <li> <b>Presentazione:</b> <br><br><%= iddidb.getInformativa() %> </li>

    <li> <b>Numero insegnamenti attivi nell'anno 2013/2014:</b> <%= iddidb.getNumIns() %> </li>

    <li> <b>Numero totale crediti erogati nell'anno 2013/2014:</b> <%= iddidb.getCreditiTot() %> </li>

    </ul>
        <% }} %>



    <h2>CORSI DI DOTTORATO: </h2>


<% for (int i = 0; i < iddid.size(); i++)
{
     iddidb = (IdDidBean) iddid.get(i); 

    //cerco i dottorati
    if(iddidb.getId_tipocs() == 14 ) {     
%>


     <%= iddidb.getCodice() %> - <%= iddidb.getNomeCorso() %> 

    <ul>
    
    <li> <b> Durata anni: </b> <%= iddidb.getDurata() %> </li>

    <li> <b>Sede:</b> <%= iddidb.getSede() %> </li>

    <li> <b>Presentazione:</b> <br><br><%= iddidb.getInformativa() %> </li>

    </ul>
        <% }}} %>


<a href="Corsi.jsp"><font color="00AA00">Back</font></a>

</body>
</html>
