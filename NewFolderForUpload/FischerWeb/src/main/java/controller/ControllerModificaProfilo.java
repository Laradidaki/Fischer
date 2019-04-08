package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ClienteManager;
import model.Cliente;
import model.Indirizzo;

/**
 * Servlet implementation class ControllerModificaProfilo
 */
@WebServlet("/modificaProfilo")
public class ControllerModificaProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerModificaProfilo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cliente c = new Cliente();
		c.setIdUtente(request.getSession().getAttribute("email").toString());
		c.setNome(request.getParameter("Nome"));
		c.setCognome(request.getParameter("Cognome"));
		c.setNumeroTel(request.getParameter("Numero"));
//		Date data_data = new Date();
//		String data_string = new String (request.getParameter("Data"));
//		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		try {
//			data_data = df.parse(data_string);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		s.setDataNascita(data_data);
		c.setNomeUtente(request.getParameter("Username"));
		Indirizzo i = new Indirizzo ();
		i.setVia(request.getParameter("Via"));
		i.setCap(Integer.valueOf(request.getParameter("Cap")));
		i.setCivico(request.getParameter("Civico"));
		i.setInterno(request.getParameter("Interno"));
		i.setCitta(request.getParameter("Comune"));
		i.setProvincia(request.getParameter("Provincia"));
		c.setPassword(request.getParameter("Password"));
		
		ClienteManager.modificaCliente(c, i);
		response.sendRedirect(response.encodeRedirectURL("profiloutente.jsp"));
	}

}
