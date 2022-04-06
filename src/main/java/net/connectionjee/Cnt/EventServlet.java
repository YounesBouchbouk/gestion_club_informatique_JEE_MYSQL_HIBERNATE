package net.connectionjee.Cnt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import net.connectionjee.Evenement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.mail.internet.AddressException;

@WebServlet(urlPatterns = "/Event", asyncSupported=true)
@MultipartConfig
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EventManager eventmanager = new EventManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
//	    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		 final Part filePart = request.getPart("file");
		 final String fileName = getFileName(filePart);
		 final String path = getServletContext().getRealPath("/assets/images");

		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String checkbx = request.getParameter("sendem");
		Evenement newone = new Evenement();

	    OutputStream out = null;
	    InputStream filecontent = null;
	    final PrintWriter writer = response.getWriter();

	    try {
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        writer.println("New file " + fileName + " created at " + path);
//	        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
//	                new Object[]{fileName, path});
	        newone = eventmanager.addEvent(title, date, time,description,path + fileName );
			if(checkbx != null) {
				try {
					eventmanager.notifyAdr(newone);
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			request.getRequestDispatcher("ListUsers.jsp").forward(request, response);


	    } catch (FileNotFoundException fne) {
	        writer.println("You either did not specify a file to upload or are "
	                + "trying to upload a file to a protected or nonexistent "
	                + "location.");
	        writer.println("<br/> ERROR: " + fne.getMessage());

//	        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
//	                new Object[]{fne.getMessage()});
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	        if (writer != null) {
	            writer.close();
	        }
	    }
		
		
	}

}
