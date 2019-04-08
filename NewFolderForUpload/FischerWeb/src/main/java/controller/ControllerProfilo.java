package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.ClienteManager;
import model.Cliente;

/**
 * Servlet implementation class ControllerProfilo
 */
public class ControllerProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProfilo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente;

		String email = request.getParameter("email");
		cliente = ClienteManager.trovaCliente(email);
		if (cliente==null) {
			response.sendRedirect("login.jsp");
		}
		else {
			/*request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("profiloutente.jsp").forward(request, response);*/
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json");
			response.getWriter().append(om.writeValueAsString(cliente));
			
		}
		

//		request.setAttribute("elencoUtenti", utenti);
//		request.getRequestDispatcher("clienti.jsp").forward(request, response);
	}



}
