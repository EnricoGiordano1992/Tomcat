<%-- hello.jsp stampa il classico saluto --%>
<%@page import="java.util.*" %>
<%! static private String str = "world!";%>
<%! static private String str2 = "DefiMongolo";%>
<%! static private String nome;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
	<head>
		<title>Tabellina del 7</title>
	</head>

<body bgcolor="#0099FF">
	
	<h1 align=center>Tabellina del 7</h1>

    <h2>JSP per generare la tabellina del 7</h2>

<TABLE border=1 align="center"> <TR> <TH> numero </TH> <TH> numero per 7 </TH> </TR> <TR> <TD>1 </TD> <TD>7 </TD> </TR> <TR> <TD>2 </TD> <TD>14 </TD> </TR> <TR> <TD>3 </TD> <TD>21 </TD> </TR> <TR> <TD>4 </TD> <TD>28 </TD> </TR> <TR> <TD>5 </TD> <TD>35 </TD> </TR> <TR> <TD>6 </TD> <TD>42 </TD> </TR> <TR> <TD>7 </TD> <TD>49 </TD> </TR> <TR> <TD>8 </TD> <TD>56 </TD> </TR> <TR> <TD>9 </TD> <TD>63 </TD> </TR> <TR> <TD>10 </TD> <TD>70 </TD> </TR> </TABLE>


</body>
</html> 
