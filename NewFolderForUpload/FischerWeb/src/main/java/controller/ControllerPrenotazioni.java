package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.PrenotazioneManager;
import model.Prenotazione;


/**
 * Servlet implementation class ControllerPrenotazione
 */
@WebServlet("/elencoPrenotazioni")
public class ControllerPrenotazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPrenotazioni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	List<Prenotazione> prenotazioni = PrenotazioneManager.elencoPrenotazioni();
		
		
		request.setAttribute("elencoPrenotazioni", prenotazioni);
		request.getRequestDispatcher("prenotazioni.jsp").forward(request, response);
	}


}
