package net.connectionjee.Cnt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.connectionjee.Utils.SendEmailTLS;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Servlet implementation class Contact
 */
@WebServlet(urlPatterns = "/Contact")

public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String Object = request.getParameter("subject");
		String Body = request.getParameter("content");
		String Email = request.getParameter("email");
		
		 Session emailSession = SendEmailTLS.getMailConnection();
		 
		 
		 try {

	         Message message = new MimeMessage(emailSession);
	         message.setFrom(new InternetAddress("ClubInfo@gmail.com"));
	         message.setRecipients(
	                 Message.RecipientType.TO,
	                  InternetAddress.parse("younss.india@gmail.com")
	         );
	      // Create the message part 
	         MimeBodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         messageBodyPart.setText("<h1>Dear User, </h1>"
	                 
	                 + "<div> <h3> Title : New message from  " + Email + "<h3/>"
	                 + "<div><p> " + Body  + "<p/> </div>"
	   
	                 ,"UTF-8","html");

	         Multipart multipart = new MimeMultipart();
	         multipart.addBodyPart(messageBodyPart);
	         
	         message.setSubject("ClubInfo :" + Object);
//	         message.setText("Dear  User,"
//	                 + "\n\n Please Confirm Your Email By Clicking Here!" + "your Token is " + Token );
	         message.setContent(multipart);
	         Transport.send(message);

	         System.out.println("Done");
	         
	         request.setAttribute("succ", "Your message was sent, thank you!");

	 		request.getRequestDispatcher("/ContactUs.jsp").forward(request, response);

	     } catch (MessagingException e) {
	         e.printStackTrace();
	         
	         request.setAttribute("err", "Some Thing Went wrong ! plese try again later");

		 	request.getRequestDispatcher("/ContactUs.jsp").forward(request, response);
	     }
		
	}

}
