<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Muestro un empleado usando EL
	${empleadoBean.firstName}
	
	<TABLE BORDER=0 WIDTH=300 BGCOLOR = #999999>

 		 	<TR ALIGN=CENTER BORDER=3px>
 		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF BORDER=3px>
 		 			<B>Employee Id </B>
 		 		</TD>
 		 	
 		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
 		 			${empleadoBean.employeeId}
 		 		</TD>
 		 	
 		 	</TR>
 		 	
 		 	<TR ALIGN=CENTER>
 		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#F3F3F3>
 		 			<B>Jobs ID </B>
 		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 		JobId
		 		</TD>
		 	</TR>
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<B>Departments </B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			
		 		</TD>
		 	</TR>	
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<B>Employees </B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			${empleadoBean.employees.employeeId} 
		 		</TD>
		 	</TR>	
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<B>First Name </B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			${empleadoBean.firstName}
		 		</TD>
		 	</TR>
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<B>Last Name </B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			${empleadoBean.lastName}
		 		</TD>
		 	</TR>
		 
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<B>Email</B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			${empleadoBean.email}
		 		</TD>
		 	</TR>
		 
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<B>Phone Number</B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			${empleadoBean.phoneNumber}
		 		</TD>
		 	</TR>
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<B>Hire Date</B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			${empleadoBean.hireDate}
		 		</TD>
		 	</TR>
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<B>Salary</B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			${empleadoBean.salary}
		 		</TD>
		 	</TR>
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<B>Commission (%)</B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			${empleadoBean.commissionPct}
		 		</TD>
		 	</TR>
		 
		 </TABLE>




</body>
</html>