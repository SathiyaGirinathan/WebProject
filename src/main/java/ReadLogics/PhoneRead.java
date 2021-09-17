package ReadLogics;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sampleProject.ContactApp;

/**
 * Servlet implementation class PhoneRead
 */
@WebServlet("/PhoneRead")
public class PhoneRead extends HttpServlet {
	static String Name;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Name = request.getParameter("phone");
		//ContactApp entity = (ContactApp)OfyService.ofy().load().type(ContactApp.class).filter(ContactApp.userName, Name).list();
		List<ContactApp> list=ofy().load().type(ContactApp.class).filter("phoneNo", Name).list();
		
		ListIterator<ContactApp> iterator = list.listIterator();
		
		PrintWriter out=response.getWriter();
		Integer i=1;
		out.println("<html><body><center><table border=2><tr><th>Si.No</th><th>Employee Id</th><th>Name</th><th>Age</th><th>Email Id</th><th>Phone No</th></tr>");
		while (iterator.hasNext()) {
			ContactApp entity = (ContactApp) iterator.next();
			out.println("<tr><td>"+i+"</td><td>"+entity.getId()+"</td><td>"+entity.getUserName()+"</td><td>"+entity.getAge()+"</td><td>"+entity.getEmailId()+"</td><td>"+entity.getPhoneNo());
			i++;
		}
		out.println("</table></center></body></html>");
		response.getWriter().println("\r\n"
				+ "<html>\r\n"
				+ "<center><h2>\r\n"
				+ "Do you want to use our Service again?<br><br>Then Click here <a href='index.html'>Services Page</a>\r\n"
				+ "</h2></center>\r\n"
				+ "</html>");
	}
}
