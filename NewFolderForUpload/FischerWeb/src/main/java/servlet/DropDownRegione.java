package servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/dropDownRegione")
public class DropDownRegione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  String regione=request.getParameter("nomiRegioni");
		  Map<String, String> lomb = new LinkedHashMap<String, String>();
		    lomb.put("1", "Bergamo");
		    lomb.put("2", "Milano");
		    lomb.put("3", "Brescia");
		    lomb.put("4", "Cremona");
		    
		    Map<String, String> sar = new LinkedHashMap<String, String>();
		    sar.put("1", "Cagliari");
		    sar.put("2", "Oristano");
		    sar.put("3", "Sanluri");
		    sar.put("4", "Sassari");
		    String json = null ;
		    if(regione.equals("Lombardia")){
		     json= new Gson().toJson(lomb);   
		    }
		    else if(regione.equals("Sardegna")){
		     json=new Gson().toJson(sar);  
		    }
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);       
		 }

		}