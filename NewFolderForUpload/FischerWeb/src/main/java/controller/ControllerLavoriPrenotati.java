package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LavoroPrenotatoManager;
import model.LavoroPrenotato;



/**
 * Servlet implementation class ControllerLavoriPrenotati
 */
@WebServlet("/lavoriPrenotati")
public class ControllerLavoriPrenotati extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLavoriPrenotati() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LavoroPrenotato> lavori = LavoroPrenotatoManager.elencoLavoriPrenotati();
		
		request.setAttribute("elencoLavoriPrenotati", lavori);
		request.getRequestDispatcher("lavoriPrenotati.jsp").forward(request, response);
	}

	

}
