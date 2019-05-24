package eserciziostudenti2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/studenteControllerServlet")
public class StudenteControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
		StudenteDbUtil2 dao =new StudenteDbUtil2();
			
		List<Studente> listaStudenti=dao.getStudenti();
			
		request.setAttribute("listaStudenti", listaStudenti);
		request.getRequestDispatcher("tabellaStudenti.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
