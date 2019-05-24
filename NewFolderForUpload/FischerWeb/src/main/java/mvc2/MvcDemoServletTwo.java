package mvc2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcDemoServletTwo")
public class MvcDemoServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1-PRENDERE I DATI DEGLI STUDENTI DALLA CLASSE HELPER(MODEL)
			List<Studente>studenti= StudenteDataUtil.getStudenti();
		
		//2-AGGIUNGERE GLI STUDENTI ALL'OGGETTO REQUEST
			request.setAttribute("listaStudenti", studenti);
			
		//3-GET REQUESTDISPATCHER
			RequestDispatcher dispatcher= request.getRequestDispatcher("/viewStudenti2.jsp");
		
		//4-FORWARDARE ALLA PAGINA JSP
			dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
