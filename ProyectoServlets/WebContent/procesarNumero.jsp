<%@page import="practicaHibernate.AdivinarNumero"%>
<%@page import="jdk.internal.org.objectweb.asm.commons.AdviceAdapter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		Adivinator!!
				
				
			
		<%!int a =0; %>
		<%
			// La primera vez que entra...
			Integer maximo = (Integer)application.getAttribute("maximo");
			Integer minimo =(Integer)application.getAttribute("minimo");
			Integer numero = (Integer)application.getAttribute("numero"); 
			boolean flag = true;

			if(maximo == 100 && minimo == 1 && numero == -1){//caso inicial...
				numero = (maximo+minimo)/2;
				application.setAttribute("numero", numero);
				%> Es este tu numero?<%= numero %>    <%
			}
			else{// si no es la primera vez...
				
				String opcionElegida = (String)request.getParameter("opcion");
				
				if(opcionElegida.equals("Mayor")){
					minimo = numero; 
					application.setAttribute("minimo", minimo);
					numero = (maximo+minimo)/2;
					application.setAttribute("numero", numero);
					a++;
					%> Es: <font size="6"><%= numero %> <%= a%></font>
				<%}
				else{
					if(opcionElegida.equals("Igual")){
						numero = -1;
						maximo = 100;
						minimo = 1;
						application.setAttribute("minimo", minimo);
						application.setAttribute("maximo", maximo);
						application.setAttribute("numero", numero);
						flag = false;
						%><font size="10">Bieeeeeen!!!!!!</font> <%
					}
					else{
						maximo = numero; 
						application.setAttribute("maximo", maximo);
						numero = (maximo+minimo)/2;
						application.setAttribute("numero", numero);
						%> Es: <font size="6"><%= numero %> </font><%
					}
				}
			}

				
		if(flag){%>		
		<form action="procesarNumero.jsp" method="get" >
			<select name="opcion">
   				<option value="Mayor">Mayor</option>
  				<option value="Igual">Igual</option>
  				<option value="Menor">Menor</option>
			</select> 
			 <input type="submit" value="confirmar"/>
		</form>
		<%}
				String res = "<br>";
		res += "<form method=\"get\" action=\"http://172.16.1.19:8090/ProyectoServlets/AdivinarNumero.jsp\">"+
					"<button type=\"submit\">"+
						"Volver"+
					"</button>"+
				"</form>";
		%><%=res %>
		
		<jsp:include page="/ServletSesionesActivas"/> -Tiempo de procesamiento
			(como acción – se genera otro Servlet)
			<%@ include file="/ServletSesionesActivas"%> - Tiempo de traducción
				(como directiva – dentro del mismo Servlet)
			
		

	</body>
</html>