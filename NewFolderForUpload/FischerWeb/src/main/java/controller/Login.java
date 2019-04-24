package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.AccessoApp;
import business.UtenteRegistratoManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/prova")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		if(AccessoApp.login(username, password)){
			request.getSession().setAttribute("email", username);
			UtenteRegistratoManager.modificaStato(username);
			response.sendRedirect(response.encodeRedirectURL("home.jsp"));
		} else {
			request.setAttribute("messaggio", "l' username o la password sono errati!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
	}

}
