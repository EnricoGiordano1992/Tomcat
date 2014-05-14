<%-- hello.jsp stampa il classico saluto --%>
<%@page import="java.util.*" %>
<%! static private String str = "world!";%>
<%! static private String str2 = "DefiMongolo";%>
<%! static private String nome;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
	<head>
		<title>Hello!</title>
	</head>

<body>
	
	<h1>Hello world!</h1>

	<b>Hello, <%= str.toUpperCase() %> </b>

	<% nome = request.getParameter("nome"); %>

	<b>	  ciao <%= nome %>, sei proprio un <%= str2 %> !</b> 

	<% for (int var=1; var<100; var++)
	   {
		if(var == 1) { %>
			<br>lo dico
			<%= var %>
			volta!	
	<%	}else if((var == new Random().nextInt() %100))	{ %>

			<br><b>mia voja</b>

	<%	}else	{ %>

			<br>lo dico
			<%= var %>
			volte!

    	<% }
	}%> 

</body>
</html> 
