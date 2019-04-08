package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ClienteManager;

/**
 * Servlet implementation class ControllerNuovoUtente
 */

@WebServlet("/nuovoUtente")
public class ControllerNuovoUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerNuovoUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UtenteRegistrato ut = new UtenteRegistrato();
		response.setContentType("application/json");
		String email=(request.getParameter("emailUtente"));
		String cf=(request.getParameter("cfUtente"));
		String cognome =(request.getParameter("cognomeUtente"));
		String nome=(request.getParameter("nomeUtente"));
		String username=(request.getParameter("usernameUtente"));
		String password=(request.getParameter("passwordUtente"));
		ClienteManager.aggiungiCliente(email, nome, cognome, username, password, cf);
		response.sendRedirect(response.encodeRedirectURL("elencoClienti"));

	}

}
