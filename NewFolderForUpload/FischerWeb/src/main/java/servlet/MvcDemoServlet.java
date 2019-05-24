package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcDemoServlet")
public class MvcDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1-AGGIUNGERE I DATI
		String[]students= {"Lara","Gabriele","Zhou","Dario"};
		request.setAttribute("lista_studenti", students);
		
		//2-GET	REQUESTDISPATCHER
		RequestDispatcher dispatcher= request.getRequestDispatcher("/viewStudenti.jsp");
		
		//3-FORWARDARE LA REQUEST ALLA JSP
		dispatcher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
