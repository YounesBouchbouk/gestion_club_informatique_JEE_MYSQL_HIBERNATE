package net.connectionjee.Cnt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.connectionjee.User;

import java.io.IOException;



@WebServlet (urlPatterns = "/EventsCnt")
public class EventsCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventsCnt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		EventManager eventmanager = new EventManager();
		HttpSession session = request.getSession(false);
		 
		 int User_id =(int)session.getAttribute("User_id");
		 System.out.print("  Your id is :  " +User_id);
		 
		request.setAttribute("session", String.valueOf(User_id) );
		request.setAttribute("result", eventmanager.getAllEvent());

		request.getRequestDispatcher("/Dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
