package UpdateLogics;

import static com.googlecode.objectify.ObjectifyService.ofy;

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
 * Servlet implementation class EmailUpdate
 */
@WebServlet("/EmailUpdate")
public class EmailUpdate extends HttpServlet {
	static String EmployeeId;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pWriter=response.getWriter();
		EmployeeId = request.getParameter("newempid");
		String newMail = request.getParameter("newmail");
		ContactApp entity = (ContactApp)OfyService.ofy().load().type(ContactApp.class).id(Long.parseLong(EmployeeId)).now();
		try {
			if(nullOrNotNull() && EmployeeId.equals(entity.getId().toString()))
			{
				ContactApp cApp=new ContactApp(entity.getId().toString(),entity.getUserName(),entity.getAge(),newMail,entity.getPhoneNo());
				
				ofy().save().entity(cApp).now();
				response.getWriter().println("\r\n"
						+ "<html>\r\n"
						+ "<center><h1>Hi, Your Contact is Updated Successfully !</h1></center>\r\n"
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
