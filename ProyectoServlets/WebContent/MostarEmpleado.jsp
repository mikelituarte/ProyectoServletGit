<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- Recupero el empleado.. -->
	<jsp:useBean id="empleadoBean" type="tablas_Clases.Employees" scope="request"></jsp:useBean>
	<jsp:getProperty property="firstName" name="empleadoBean"/>
	<jsp:getProperty property="lastName" name="empleadoBean"/>
	<jsp:getProperty property="employeeId" name="empleadoBean"/>
	<jsp:getProperty property="email" name="empleadoBean"/>
	<jsp:getProperty property="phoneNumber" name="empleadoBean"/>
	<jsp:getProperty property="hireDate" name="empleadoBean"/>
	<jsp:getProperty property="salary" name="empleadoBean"/>
	<jsp:getProperty property="commissionPct" name="empleadoBean"/>
	
	
	<br>
	<TABLE BORDER=0 WIDTH=300 BGCOLOR = #999999>

 		 	<TR ALIGN=CENTER BORDER=3px>
 		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF BORDER=3px>
 		 			<B>Employee Id </B>
 		 		</TD>
 		 	
 		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
 		 			<jsp:getProperty property="employeeId" name="empleadoBean"/>
 		 		</TD>
 		 	
 		 	</TR>
 		 	
 		 	<TR ALIGN=CENTER>
 		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#F3F3F3>
 		 			<B>Jobs ID </B>
 		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 		jobs.getJobId()
		 		</TD>
		 	</TR>
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<B>Departments </B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			departments.getDepartmentId() 
		 		</TD>
		 	</TR>	
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<B>Employees </B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			//employees.getEmployeeId()  
		 		</TD>
		 	</TR>	
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<B>First Name </B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<jsp:getProperty property="firstName" name="empleadoBean"/>
		 		</TD>
		 	</TR>
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<B>Last Name </B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<jsp:getProperty property="lastName" name="empleadoBean"/>
		 		</TD>
		 	</TR>
		 
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<B>Email</B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<jsp:getProperty property="email" name="empleadoBean"/>
		 		</TD>
		 	</TR>
		 
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<B>Phone Number</B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<jsp:getProperty property="phoneNumber" name="empleadoBean"/>
		 		</TD>
		 	</TR>
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<B>Hire Date</B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<jsp:getProperty property="hireDate" name="empleadoBean"/>
		 		</TD>
		 	</TR>
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<B>Salary</B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#F3F3F3>
		 			<jsp:getProperty property="salary" name="empleadoBean"/>
		 		</TD>
		 	</TR>
		 		
 		 	<TR ALIGN=CENTER>
		 		<TD WIDTH=200 HEIGHT= 30 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<B>Commission (%)</B>
		 		</TD>
		 	
		 		<TD WIDTH=200 ALIGN=CENTER BGCOLOR=#DFDFDF>
		 			<jsp:getProperty property="commissionPct" name="empleadoBean"/>
		 		</TD>
		 	</TR>
		 
		 </TABLE>
</body>
</html>