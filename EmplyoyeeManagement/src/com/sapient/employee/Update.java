package com.sapient.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Update() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Emp e = new Emp();
		String id = (request.getParameter("t1"));
		System.out.println(id);
		e.setId(Integer.parseInt(id));
		e.setName(request.getParameter("t2"));
		e.setProject(request.getParameter("t3"));
		e.setAge(Integer.parseInt(request.getParameter("t4")));
		e.setPsw("123");
		e.setRole(request.getParameter("t5"));
	
		EmpDAOImplementation empdi = new EmpDAOImplementation();
		if(empdi.updateEmp(e))
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
