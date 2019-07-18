package com.sapient.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("employeeimp.xml");
		EmpDAO empdi =(EmpDAO)ctx.getBean("empdi");
		Emp e = new Emp();
		e.setId(Integer.parseInt(request.getParameter("t1")));
		e.setName(request.getParameter("t2"));
		e.setProject(request.getParameter("t3"));
		e.setAge(Integer.parseInt(request.getParameter("t4")));
		e.setPsw(request.getParameter("t5"));
		e.setRole(request.getParameter("t7"));
		
		if(empdi.initEmp(e))
		{
		RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
		rd.forward(request,response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Wrong.jsp");
			rd.forward(request,response);

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
