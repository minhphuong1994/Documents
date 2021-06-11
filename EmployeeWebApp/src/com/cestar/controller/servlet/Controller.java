package com.cestar.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cestar.dao.EmpDao;
import com.cestar.model.Employee;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url = request.getServletPath();
		switch(url) {
			case "/insert":{
				insertRec(request,response);
				out.print("This is Insert Page");
				break;
			}
			case "/display":{
				displayAll(request, response);
				out.print("This is Display Page");
				break;
			}
			case "/edit":{
				editRec(request, response);
				out.print("This is Edit Page");
				break;
			}
			case "/update":{
				updateRec(request, response);
				out.print("Update success!!");
				break;
			}
			case "/delete":{
				deleteRec(request, response);
				out.print("This is Delete Page");
				break;
			}
			default:{
				out.print("Sorry, page not exist!");
			}
		}
	}
	
	protected void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao obj = new EmpDao();
		List<Employee> emps = obj.displayAllRec();
		HttpSession session  = request.getSession();
		session.setAttribute("emps", emps);
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		rd.forward(request, response);
	}
	
	protected void deleteRec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao obj = new EmpDao();
		int id = Integer.parseInt(request.getParameter("id"));
		obj.deleteRec(id);
		displayAll(request, response);		
	}
	
	
	protected void editRec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao obj = new EmpDao();
		int old_id = Integer.parseInt(request.getParameter("id")); //get id return from client side
		Employee new_emp = obj.getRecById(old_id);		
		
		HttpSession session  = request.getSession(); //create session of data to push
		session.setAttribute("update_emp", new_emp);
		session.setAttribute("old_id", old_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp"); //setup place to push data
		rd.forward(request, response); //execute pushing data 
	}
	

	protected void updateRec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		EmpDao obj = new EmpDao();
		Employee update_emp = new Employee(id,name,city,contact,email);
		
		HttpSession session = request.getSession();
		int old_id = (int) session.getAttribute("old_id");
		obj.updateRec(old_id, update_emp);
		displayAll(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void insertRec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
//		out.print("<br/>Hello to my first servlet app");	
		int id = Integer.parseInt(request.getParameter("id"));		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");				
		
		EmpDao obj = new EmpDao();
		Employee emp = new Employee(id,name,city,contact,email);
		obj.insertRec(emp);
		displayAll(request, response);
	}

}
