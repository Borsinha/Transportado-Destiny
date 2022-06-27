package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DestinyDao;
import models.Destiny;

/**
 * Servlet implementation class DestinyController
 */
@WebServlet(name = "Destiny", urlPatterns = { "/DestinyController" })
public class DestinyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ADDUP = "/Destiny.jsp";
	private static String LIST = "/listDestiny.jsp";
	private DestinyDao dao;

	public DestinyController() {
	        super();
	        dao = new DestinyDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String op = request.getParameter("op");
		dao = new DestinyDao();

		if (op.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("destinyId"));
			dao.deleteDestiny(id);
			forward = LIST;
			request.setAttribute("destiny", dao.getAllDestiny());
		} else if (op.equalsIgnoreCase("edit")) {
			forward = ADDUP;
			int id = Integer.parseInt(request.getParameter("destinyId"));
			Destiny destiny = dao.getDestinyById(id);
			request.setAttribute("action", "Atualizar");
			request.setAttribute("destiny", destiny);
		} else if (op.equalsIgnoreCase("listdestiny")) {
			forward = LIST;
			request.setAttribute("destiny", dao.getAllDestiny());
		} else {
			request.setAttribute("action", "Adicionar");
			forward = ADDUP;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Destiny destiny = new Destiny();
    	destiny.setName(request.getParameter("name"));
    	destiny.setStreet(request.getParameter("street"));
    	destiny.setNumber(request.getParameter("number"));
    	destiny.setCep(request.getParameter("cep"));
    	destiny.setCity(request.getParameter("city"));
    	destiny.setState(request.getParameter("state"));;
        
        String id = request.getParameter("id");
        if(id == null || id.isEmpty()) {
        	dao.addDestiny(destiny);
        }
        else {
        	destiny.setId(Integer.parseInt(id));
        	dao.updateDestiny(destiny);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("destiny", dao.getAllDestiny());
        view.forward(request, response);
    }

}
