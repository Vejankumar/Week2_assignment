<%@page import="com.sapient.employee.EmpDAOImplementation"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.sapient.employee.Emp"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update employee</title>
</head>
<body>

<form action="" method="post">

  <div class="container">
    <h1>Updating</h1>
    <p>Enter Employee id</p>
    <hr>
	<label for="id"><b>Id</b></label>
    <input type="number" placeholder="Enter id" name="t1" required>   
    
    <button type="submit" class="checkemp">check</button>
   </div>
  
</form>

<%!
	Emp e = new Emp();;
%>

<%
	if("POST".equalsIgnoreCase(request.getMethod()))
	{
		ApplicationContext factory = new ClassPathXmlApplicationContext("employeeimp.xml");
		EmpDAOImplementation obj = (EmpDAOImplementation)factory.getBean("empdi");
		e = obj.getEmp(request.getParameter("t1"));	
	}
%>

<form action="update" method="post">
	<br><br>
  <div class="container">
   <label for="id"><b>Id</b></label>
    <input type="text" name="t1"   value="<%= e.getId() %>" readonly ><br><br>

    <label for="name"><b>Name</b></label>
    <input type="text"  name="t2" value="<%= e.getName() %>"   required><br><br>

    <label for="project"><b>Project</b></label>
    <input type="text"  name="t3"  value="<%= e.getProject() %>"  required><br><br>
    
    <label for="age"><b>Age</b></label>
    <input type="number"  name="t4"  value="<%= e.getAge() %>"  required><br><br>
    
    
     <label for="psw"><b>Password</b></label>
    <input type="password"  name="t5"  value="<%= e.getPsw() %>" readonly ><br><br>
      
    <label for="role"><b>Role</b></label>
    <input type="text"  name="t6"  value="<%= e.getRole() %>" required><br><br>
    
    <button type="submit" class="checkemp">Update</button>
   </div>
  
</form>

</body>
</html>