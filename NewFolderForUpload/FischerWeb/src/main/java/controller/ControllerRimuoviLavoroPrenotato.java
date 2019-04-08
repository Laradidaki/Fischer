package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LavoroPrenotatoManager;

/**
 * Servlet implementation class ControllerRimuoviLavoroPrenotato
 */
@WebServlet("/rimuoviLavoroPrenotato")
public class ControllerRimuoviLavoroPrenotato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRimuoviLavoroPrenotato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idDaEliminare = Integer.valueOf(request.getParameter("idLavoro"));

		LavoroPrenotatoManager.eliminaLavoroPrenotato(idDaEliminare);
		response.sendRedirect("elencoLavoriPrenotati");
	}

	

}
