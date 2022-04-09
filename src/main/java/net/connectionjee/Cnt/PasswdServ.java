package net.connectionjee.Cnt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.connectionjee.User;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class PasswdServ
 */
@WebServlet(urlPatterns = { "/ChangePassword" })

public class PasswdServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManager usermng;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() throws ServletException {
		usermng = new UserManager();
	}

	public PasswdServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String OldPasswd = request.getParameter("OldPasswd");
		String NewPasswd = request.getParameter("NewPasswd");
		String CPasswd = request.getParameter("CPasswd");
		User newuser = new User();

		HttpSession session = request.getSession();

		int User_id = (int) session.getAttribute("User_id");

		if (NewPasswd.equals(CPasswd)) {

			int A = usermng.ChangePassword(OldPasswd, NewPasswd, User_id);

			if (A == 1) {
				request.setAttribute("Succmsg", "le mot de passe a changé avec succes !");
				request.getRequestDispatcher("EditPasswd.jsp").forward(request, response);

			} else if (A != 1) {

				request.setAttribute("errmsg", "le mot de passe ancien n'est pas correct !");
				request.getRequestDispatcher("EditPasswd.jsp").forward(request, response);
			}

		} else
			request.setAttribute("errmsg", "les mots de passe ne sont pas correspondant!");
		request.getRequestDispatcher("EditPasswd.jsp").forward(request, response);
	}

	// To be continued
}
