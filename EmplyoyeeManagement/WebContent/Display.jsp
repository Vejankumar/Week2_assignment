<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
 <%@page import="com.sapient.employee.Emp"%>
<%@page import="java.util.Iterator"%> 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>

<%@page import="com.sapient.employee.EmpDAOImplementation"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
<form action="display" method="post">
<h2>
<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Sapient123");
	PreparedStatement st = con.prepareStatement("Select * from Employee");
	ResultSet rs = st.executeQuery();
	while(rs.next())
	{
		out.println(rs.getInt(1));
		out.println(rs.getString(2));
		out.println(rs.getString(3));
		out.println(rs.getInt(4));
		out.println(rs.getString(5));
		out.println(rs.getString(6));
		out.println("<br>");
	}
	rs.close();
	st.close();
}
	catch(Exception E)
	{
		out.println(E);
	}

%>
</h2>
</form>
</body>
</html>