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
	private static String INSERT_OR_EDIT = "/Destiny.jsp";
	private static String LIST_DESTINY = "/listDestiny.jsp";
	private DestinyDao dao;

	public DestinyController() {
	        super();
	        dao = new DestinyDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		dao = new DestinyDao();

		if (action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("destinyId"));
			dao.deleteDestiny(id);
			forward = LIST_DESTINY;
			request.setAttribute("destiny", dao.getAllDestiny());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int id = Integer.parseInt(request.getParameter("destinyId"));
			Destiny destiny = dao.getDestinyById(id);
			request.setAttribute("destiny", destiny);
		} else if (action.equalsIgnoreCase("listdestiny")) {
			forward = LIST_DESTINY;
			request.setAttribute("destiny", dao.getAllDestiny());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Destiny destiny = new Destiny();
    	destiny.setName(request.getParameter("nome"));
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

        RequestDispatcher view = request.getRequestDispatcher(LIST_DESTINY);
        request.setAttribute("destiny", dao.getAllDestiny());
        view.forward(request, response);
    }

}
