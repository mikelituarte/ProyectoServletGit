<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Adivinar Numero</title>
	</head>
	<body>
		<%
			// La primera vez que entra...
			Integer maximo = (Integer)application.getAttribute("maximo");
			Integer minimo =(Integer)application.getAttribute("minimo");
			Integer numero = (Integer)application.getAttribute("numero");
			numero = -1;
			maximo = 100;
			minimo = 1;
			application.setAttribute("minimo", minimo);
			application.setAttribute("maximo", maximo);
			application.setAttribute("numero", numero);
	    %>
		<form action="procesarNumero.jsp" method="get">
			<blink>Piensa en un Numero del 1 al 100 y pulsa Adivinar</blink>
			<br>
			<input type="submit" value="Adivinar" title="Adivinar"></> 
			<br>
		</form>
	</body>
</html>