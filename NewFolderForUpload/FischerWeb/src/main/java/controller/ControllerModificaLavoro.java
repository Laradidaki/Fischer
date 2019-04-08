package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.LavoroPrenotatoManager;
import model.LavoroPrenotato;


/**
 * Servlet implementation class ControllerModificaLavoro
 */
@WebServlet("/modificaLavoro")
public class ControllerModificaLavoro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerModificaLavoro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		Integer id = Integer.valueOf(request.getParameter("idLavoro"));
		LavoroPrenotato l =new LavoroPrenotato();
		l.setTipologiaCopertura(request.getParameter("tipologiaCopertura"));
		l.setStatoCopertura(request.getParameter("statoCopertura"));
		l.setLivelloUrgenza(request.getParameter("livelloUrgenza"));
		
		LavoroPrenotatoManager.modificaLavoroPrenotato(l, id);
		response.sendRedirect(response.encodeRedirectURL("elencoLavoriPrenotati"));

	}

}
