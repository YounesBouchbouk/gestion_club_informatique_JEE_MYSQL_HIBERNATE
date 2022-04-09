package net.connectionjee.Cnt;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.connectionjee.User;

@WebServlet (urlPatterns = "/LoginCnt")

public class LoginCnt extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserManager usermng;
	
	 @Override
	public void init() throws ServletException {
		 usermng = new UserManager();
	}
	 
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 resp.getWriter().append("Served at: ").append(req.getContextPath());

	 }
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 HttpSession session = req.getSession();

		 	String CNE = req.getParameter("CNE");
			String password = req.getParameter("password");
			int A = usermng.validate(CNE, password);
			
			if (A != -1) {
			
				
				if(usermng.checkIfAccountDisabled(A)  != -1) {
					if(usermng.checkifEmailConfirmed(A) != -1) {
						System.out.println("Start the session");
						System.out.println(A);
						session.setAttribute("User_id", A);
						req.setAttribute("Succmsg", "Email Confirmed");
						req.getRequestDispatcher("/EventsCnt").forward(req, resp);
					}else {
						req.setAttribute("errmsg", "Vous Navez pas encore confirmer votre Email ");
						//	System.out.println("Email not Confirmed");
							req.getRequestDispatcher("Login.jsp").forward(req, resp);
					}
				}else {
					req.setAttribute("errmsg", "Votre Compte est desactivé , Contact votre admin ");
					//	System.out.println("Email not Confirmed");
						req.getRequestDispatcher("Login.jsp").forward(req, resp);
				}
			}else {
 
				req.setAttribute("errmsg", "Your password or CNE is incorrect !! ");
				req.getRequestDispatcher("Login.jsp").forward(req, resp);


			}
	 }
	 
}
