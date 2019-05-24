package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet("/ajaxHandler")
public class AjaxHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public AjaxHandler() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        JSONArray array = new JSONArray();
        
        JSONObject user1 = new JSONObject();
        user1.put("name", "TOM");
        user1.put("age", "26");
        JSONObject user2 = new JSONObject();
        user2.put("name", "ASB");
        user2.put("age", "26");
        
        array.put(user1);
        array.put(user2);
        
        response.setContentType("application/json");
        response.getWriter().write(array.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}