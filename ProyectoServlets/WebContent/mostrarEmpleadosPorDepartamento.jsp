<%@page import="java.util.List"%>
<%@page import="tablas_Clases.Employees"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



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
	
	Lo muestro usando JSTL:
	<% 
	String color = "#DDDDDD";
	int i =0; 
	%>
	<table border="0" bgcolor="#00515E">
		<tr align="center">
			<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Nombre</b></td>
			<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Apellido</b></td>
			<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Telefonor</b></td>
			<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Email</b></td>
			<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Salario</b></td>
			<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Comosion (%)</b></td>
			<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Job ID</b></td>
			<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Departamento ID</b></td>
			<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Hire Date</b></td>
		</tr>
		
		<c:forEach items="${listaEmpleados}" var="empleado">
			<% if(i%2 ==0){
				color = "#DDDDDD";
			}
			else{
				color = "#EEEEEE";
			}
			%>

		<tr align="center">
			<td ALIGN=CENTER BGCOLOR=<%=color%>><c:out value="${empleado.firstName}"></c:out></td>
			<td ALIGN=CENTER BGCOLOR=<%=color%>><c:out value="${empleado.lastName}"></c:out></td>
			<td ALIGN=CENTER BGCOLOR=<%=color%>><c:out value="${empleado.phoneNumber}"></c:out></td>
			<td ALIGN=CENTER BGCOLOR=<%=color%>><c:out value="${empleado.email}"></c:out></td>
			<td ALIGN=CENTER BGCOLOR=<%=color%>><c:out value="${empleado.salary}"></c:out></td>
			<td ALIGN=CENTER BGCOLOR=<%=color%>><c:out value="${empleado.commissionPct}"></c:out></td>
			<td ALIGN=CENTER BGCOLOR=<%=color%>><c:out value="${empleado.jobs.jobId}"></c:out></td>
			<td ALIGN=CENTER BGCOLOR=<%=color%>><c:out value="${empleado.departments.departmentId}"></c:out></td>
			<td ALIGN=CENTER BGCOLOR=<%=color%>><c:out value="${empleado.hireDate}"></c:out></td>
		</tr>	
		<% i++; %>
		</c:forEach>	
	</table>
	
	
</body>
</html>