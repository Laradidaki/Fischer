package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UtenteRegistratoManager;
import model.UtenteRegistrato;


/**
 * Servlet implementation class ControllerUtenteRegistrato
 */
public class ControllerUtenteRegistrato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUtenteRegistrato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UtenteRegistrato> utenti = UtenteRegistratoManager.elencoUtenti();	
		request.setAttribute("elencoUtenti", utenti);
		request.getRequestDispatcher("clienti.jsp").forward(request, response);
	}



}
