package Controllers;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.TruckDao;
import models.Truck;

/**
 * Servlet implementation class TruckController
 */
@WebServlet(name = "Truck", urlPatterns = { "/TruckController" })
public class TruckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/truck.jsp";
	private static String LIST_TRUCK = "/listTruck.jsp";
	private TruckDao dao;

	public TruckController() {
	        super();
	        dao = new TruckDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		dao = new TruckDao();

		if (action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("truckId"));
			dao.deleteTruck(id);
			forward = LIST_TRUCK;
			request.setAttribute("trucks", dao.getAllTrucks());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int id = Integer.parseInt(request.getParameter("truckId"));
			Truck truck = dao.getTruckById(id);
			request.setAttribute("truck", truck);
		} else if (action.equalsIgnoreCase("listTruck")) {
			forward = LIST_TRUCK;
			request.setAttribute("trucks", dao.getAllTrucks());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Truck truck = new Truck();
        truck.setModel(request.getParameter("model"));
        truck.setDriver(request.getParameter("driver"));
        truck.setTotalKm(request.getParameter("totalKm"));
        truck.setCurrentLocation(request.getParameter("currentLocation"));
        truck.setDestiny(request.getParameter("destiny"));;
        
        String id = request.getParameter("id");
        if(id == null || id.isEmpty()) {
        	dao.addTruck(truck);
        }
        else {
        	truck.setId(Integer.parseInt(id));
        	dao.updateTruck(truck);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_TRUCK);
        request.setAttribute("trucks", dao.getAllTrucks());
        view.forward(request, response);
    }
    
}
