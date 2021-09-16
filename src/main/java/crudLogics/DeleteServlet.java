package crudLogics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.googlecode.objectify.ObjectifyService.ofy;

import sampleProject.ContactApp;
import sampleProject.OfyService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empidString=request.getParameter("empid");
		Long empLong=Long.parseLong(empidString);
		
		ofy().delete().type(ContactApp.class).id(empLong).now();
		response.getWriter().println("\r\n"
				+ "<html>\r\n"
				+ "<center><h1>Hi, That Contact Deleted Successfully !</h1></center>\r\n"
				+ "</html>");
		response.getWriter().println("\r\n"
				+ "<html>\r\n"
				+ "<center><h2>\r\n"
				+ "Do you want to use our Service again?<br><br>Then Click here <a href='index.html'>Services Page</a>\r\n"
				+ "</h2></center>\r\n"
				+ "</html>");	
		
	}


}
