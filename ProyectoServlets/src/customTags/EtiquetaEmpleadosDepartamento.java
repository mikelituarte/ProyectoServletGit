package customTags;

import hibernateAll.empleadoHibernateDAO.EmpleadoHibernateDAO;
import interfaces.interfaceRecuperable.Recuperable;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import servicios.Empleados.EmployeesServices;
import tablas_Clases.Employees;

public class EtiquetaEmpleadosDepartamento extends SimpleTagSupport {

	short id;
	
	private List<Employees> obtenerEmpleados(short id_departamento){
		List<Employees> lista = null;

		EmployeesServices es = new EmployeesServices();
		Recuperable objetoDao = new EmpleadoHibernateDAO();
		es.setRecuperable(objetoDao);
		lista = es.obtenerEmpleadosPorDepartamento(id_departamento);
		return lista;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		List<Employees> lista = null;
		String color = "#DDDDDD";
		lista = obtenerEmpleados(this.id);
		
		getJspContext().getOut().println("<table border='0' bgcolor='#A19D9D'>"+
		"<tr align='center'>" +
			"<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Nombre</b></td>" +
			"<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Apellido</b></td>" +
			"<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Telefonor</b></td>" +
			"<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Email</b></td>" +
			"<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Salario</b></td>" +
			"<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>Comosion (%)</b></td>" +
			"<td ALIGN=CENTER BGCOLOR=#BBBBBB><b>JHire Date</b></td>" +
		"</tr>");
		int i =0;
		for (Employees empleado : lista) {
			if (i%2 ==0){
				color = "#DDDDDD";
			}
			else{
				color = "#EEEEEE";
			}
			getJspContext().getOut().println("" + 
			"<tr align='center'>" +
				"<td ALIGN=CENTER BGCOLOR="+ color+ ">" +empleado.getFirstName() + "</td>" +
				"<td ALIGN=CENTER BGCOLOR="+ color+ ">" +empleado.getLastName() + "</td>" +
				"<td ALIGN=CENTER BGCOLOR="+ color+ ">" +empleado.getPhoneNumber() + "</td>" +
				"<td ALIGN=CENTER BGCOLOR="+ color+ ">" +empleado.getEmail() + "</td>" +
				"<td ALIGN=CENTER BGCOLOR="+ color+ ">" +empleado.getSalary() + "</td>" +
				"<td ALIGN=CENTER BGCOLOR="+ color+ ">" +empleado.getCommissionPct() + "</td>" +
				"<td ALIGN=CENTER BGCOLOR="+ color+ ">" +empleado.getHireDate() + "</td>" +
			"</tr>");
			i++;
		}
		getJspContext().getOut().println("</table>");
		
		
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}


	
	
}
