package crudLogics;

import sampleProject.ContactApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/StoreServlet")
public class StoreServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String EmpId = request.getParameter("empid");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String emailId=request.getParameter("email");
		String phoneNo=request.getParameter("mobile");
		
		ContactApp cApp=new ContactApp(EmpId,name,age,emailId,phoneNo);
		
		ofy().save().entity(cApp).now();
		response.getWriter().println("\r\n"
				+ "<html>\r\n"
				+ "<center><h1>Hi, Your Contact Saved Successfully !</h1></center>\r\n"
				+ "</html>");
		response.getWriter().println("\r\n"
				+ "<html>\r\n"
				+ "<center><h2>\r\n"
				+ "Do you want to use our Service again?<br><br>Then Click here <a href='index.html'>Services Page</a>\r\n"
				+ "</h2></center>\r\n"
				+ "</html>");
	}
}
