<%-- hello.jsp stampa il classico saluto --%>
<%@page import="java.util.*" %>
<%! static private String number;%>
<%! static private int num;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
	<head>
		<title>Tabellina</title>
	</head>

<body>
	
	<% number = request.getParameter("num"); %>
    <% num = Integer.parseInt(number); %>

	<h1 align=center>Tabellina del <%= num %> </h1>

    <h2>JSP per generare la tabellina del <%= num %> </h2>

    <TABLE border=1 align=center>
     <TR> <TH> numero </TH> <TH> numero per <%= num %> </TH> </TR>   
    <% for(int i=1;i<11;i++){ %>
        <TR> <TD> <%= i %> </TD> <TD> <%= i * num %> </TD> </TR>
       <%     } %>
    
    </TABLE>



</body>
</html> 
