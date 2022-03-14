package net.connectionjee.Cnt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.connectionjee.User;
import net.connectionjee.UserModel;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Userstable","*.do"})

public class Userstable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManager usermng;
	
	 @Override
	public void init() throws ServletException {
		 usermng = new UserManager();
	}
	 
    public Userstable() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String path=request.getServletPath();

		if (path.equals("/Userstable")) {
			List<User> listUsers =  usermng.getAllUsers();
			
			request.setAttribute("model", listUsers);
			request.getRequestDispatcher("ListUsers.jsp").forward(request, response);
		}
		
		if(path.equals("/setToAdh.do")) {
			int id = Integer.parseInt(request.getParameter("id")) ;
			
			System.out.println(id);
			usermng.addRole(id, 2);
			List<User> listUsers =  usermng.getAllUsers();
			
			request.setAttribute("model", listUsers);
			request.getRequestDispatcher("ListUsers.jsp").forward(request, response);
		}
		
		}
		

}
