package net.connectionjee.Cnt;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.connectionjee.Utils.Exportcsv;

import java.io.IOException;


@WebServlet(urlPatterns = "/cvsFile", asyncSupported=true)
public class Getcsv extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Getcsv() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Exportcsv exputil = new Exportcsv();
		UserManager usermn = new UserManager();
		
		exputil.exportList(usermn.getAllUsers());
		//request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
