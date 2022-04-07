package net.connectionjee.Cnt;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.connectionjee.User;
import utils.JPAutil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

@WebServlet(urlPatterns = "/SignupServ", asyncSupported=true)

public class SignupServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManager usermng;
	
	 @Override
	public void init() throws ServletException {
		 usermng = new UserManager();
	}
//    
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String email = request.getParameter("email") ;
		String fname = request.getParameter("fname") ;
		String cin = request.getParameter("cin") ;
		String cne = request.getParameter("cne") ;
		String filier = request.getParameter("filier") ;
		String bDate = request.getParameter("bDate") ;
		String password = request.getParameter("password") ;
		String Cpassword = request.getParameter("Cpassword") ;
		User newuser;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		
		
		if(password.equals(Cpassword)) {
			//UserManager userCnt = new UserManager();
			newuser = usermng.create(email, password, cin, cne, filier, bDate);
		
			request.setAttribute("errmsg", "Password not matches");
			request.getRequestDispatcher("AuthSign.jsp").forward(request, response);
       
			
		}else {
			
			request.setAttribute("errmsg", "Password not matches");
			request.getRequestDispatcher("AuthSign.jsp").forward(request, response);

		}

	
		
	}

}
