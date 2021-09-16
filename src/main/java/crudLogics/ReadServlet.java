package crudLogics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sampleProject.ContactApp;
import sampleProject.OfyService;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	static String EmployeeId;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeId = request.getParameter("empid");
		ContactApp entity = (ContactApp)OfyService.ofy().load().type(ContactApp.class).id(Long.parseLong(EmployeeId)).now();
		
		PrintWriter pWriter=response.getWriter();
		
		try {
			if(nullOrNotNull() && EmployeeId.equals(entity.getId().toString()))
			{
				pWriter.println("<html>\r\n"
						+ "<body>\r\n"
						+ "<center><br><h1> Hi your contact is retrived Successfully !!!</h1><br><br></center></body>\r\n"
						+ "</html>");
				pWriter.println("<html>\r\n"
						+ "<body><center><h3><br>\r\n"
						+"Employee Id: "+entity.getId()+"<br><br>\r\n"
						+"Name: "+entity.getUserName()+"<br><br>\r\n"
						+"Email Id:"+entity.getEmailId()+"<br><br>\r\n"
						+"Phone No:"+ entity.getPhoneNo()+"<br><br>\r\n"
						+ "</h3></center></body>\r\n"
						+ "</html>");
				response.getWriter().println("\r\n"
						+ "<html>\r\n"
						+ "<center><h2>\r\n"
						+ "Do you want to use our Service again?<br><br>Then Click here <a href='index.html'>Services Page</a>\r\n"
						+ "</h2></center>\r\n"
						+ "</html>");
			}
			else {
				{
					pWriter.println("<html>\r\n"
							+ "<body>\r\n"
							+ "<br><br>\r\n"
							+ "<h1>Sorry, Your Contact is not found !</h1>\r\n"
							+ "</body>\r\n"
							+ "</html>\r\n"
							+ "\r\n"
							+ "");
					response.getWriter().println("\r\n"
							+ "<html>\r\n"
							+ "<center><h2>\r\n"
							+ "Do you want to use our Service again?<br><br>Then Click here <a href='index.html'>Services Page</a>\r\n"
							+ "</h2></center>\r\n"
							+ "</html>");
				}
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			pWriter.println("<html>\r\n"
					+ "<body>\r\n"
					+ "<br><br>\r\n"
					+ "<center><h1>Sorry, Your Contact is not found !</h1></center>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "\r\n"
					+ "");
			response.getWriter().println("\r\n"
					+ "<html>\r\n"
					+ "<center><h2>\r\n"
					+ "Do you want to use our Service again?<br><br>Then Click here <a href='index.html'>Services Page</a>\r\n"
					+ "</h2></center>\r\n"
					+ "</html>");
		}
	}
	
	boolean nullOrNotNull()
	{
		if(!EmployeeId.isEmpty())
		{
			return true;
		}
		else {
			return false;
		}
	}

}
