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

@WebServlet(urlPatterns = "/loginooooo", asyncSupported=true)

public class LoginController extends HttpServlet {

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
				//User Auser;
				
				if(usermng.checkifEmailConfirmed(A) == 1) {
					System.out.println("Email Confirmed");
					System.out.println(A);
					session.setAttribute("User_id", A);
					req.setAttribute("Succmsg", "Email Confirmed");
					req.getRequestDispatcher("login-success.jsp").forward(req, resp);

					
				} else if(usermng.checkifEmailConfirmed(A) == 0) {
					req.setAttribute("errmsg", "Email not Confirmed");
				//	System.out.println("Email not Confirmed");
					req.getRequestDispatcher("Login.jsp").forward(req, resp);

				
	
				} else if(usermng.checkifEmailConfirmed(A) == 2) {
					req.setAttribute("errmsg", "Your account is not activated yet");
					//	System.out.println("Email not Confirmed");
						req.getRequestDispatcher("Login.jsp").forward(req, resp);
				}
				
				
			}else {
 
				req.setAttribute("errmsg", "Your password or CNE is incorrect !! ");
				req.getRequestDispatcher("Login.jsp").forward(req, resp);


			}
	 }
	 
}
