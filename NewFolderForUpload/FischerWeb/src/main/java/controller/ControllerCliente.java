package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ClienteManager;
import business.UtenteRegistratoManager;
import model.Cliente;
import model.UtenteRegistrato;


/**
 * Servlet implementation class ControllerCliente
 */
@WebServlet("/elencoClienti")
public class ControllerCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> clienti;

		String stato = request.getParameter("stato");
		if (stato != null) {
			clienti = ClienteManager.elencoClientiPerStato(stato);
		} else {
			String noStato = request.getParameter("noStato");
			if (noStato == null) {
				clienti = ClienteManager.elencoClienti();
			} else {
				clienti = ClienteManager.elencoClientiNonPerStato(noStato);
			}
		}

		request.setAttribute("elencoClienti", clienti);
		request.getRequestDispatcher("clienti.jsp").forward(request, response);

		List<UtenteRegistrato> utenti = UtenteRegistratoManager.elencoUtenti();

//		request.setAttribute("elencoUtenti", utenti);
//		request.getRequestDispatcher("segnalatori.jsp").forward(request, response);

	}
}
