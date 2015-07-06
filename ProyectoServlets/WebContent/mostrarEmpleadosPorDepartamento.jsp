<%@page import="java.util.List"%>
<%@page import="tablas_Clases.Employees"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Employees> lista = null;
	Iterator<Employees> it = null;
	Employees empleado = null;
	lista = (List<Employees>)request.getAttribute("listaEmpleados");
	it = lista.iterator();
	if(lista != null){
		while(it.hasNext()){
			empleado = it.next();
			%><%= empleado.imprimirEmpleado() %><br><%
			
		}
	}
	%>
	<form method="get" action="http://172.16.1.19:8090/ProyectoServlets/recuperarEmpleadosPorDepartamento.html">
			<button type="submit">
						Volver
			</button>
	</form>
	
	Lo muestro con JSTL:
	
	
</body>
</html>