package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import business.LavoroPrenotatoManager;
import model.LavoroPrenotato;


/**
 * Servlet implementation class ControllerLavoroPerId
 */
@WebServlet("/lavoroPerId")
public class ControllerLavoroPerId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLavoroPerId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idStr = request.getParameter("id");
		Integer idNum = Integer.valueOf(idStr);
		ObjectMapper om = new ObjectMapper();
		response.setContentType("application/json");
		LavoroPrenotato lp = LavoroPrenotatoManager.perId(idNum);
		try {
			response.getWriter().append(om.writeValueAsString(lp));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
