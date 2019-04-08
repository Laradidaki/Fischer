package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.PrenotazioneManager;

/**
 * Servlet implementation class ControllerRimuoviPrenotazione
 */
@WebServlet("/rimuoviPrenotazione")
public class ControllerRimuoviPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRimuoviPrenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idDaEliminare = Integer.valueOf(request.getParameter("idPrenotazione"));
		PrenotazioneManager.eliminaPrenotazione(idDaEliminare);
		response.sendRedirect("elencoPrenotazioni");
	}


}
