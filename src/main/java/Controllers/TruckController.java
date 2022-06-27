package Controllers;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DestinyDao;
import daos.TruckDao;
import models.Truck;

/**
 * Servlet implementation class TruckController
 */
@WebServlet(name = "Truck", urlPatterns = { "/TruckController" })
public class TruckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ADDUP = "/truck.jsp";
	private static String LIST = "/listTruck.jsp";
	private TruckDao dao;
	private DestinyDao destDao;

	public TruckController() {
	        super();
	        dao = new TruckDao();
	        destDao = new DestinyDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String op = request.getParameter("op");
		dao = new TruckDao();

		if (op.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("truckId"));
			dao.deleteTruck(id);
			forward = LIST;
			request.setAttribute("destinys", destDao.getAllDestiny());
			request.setAttribute("trucks", dao.getAllTrucks());
		} else if (op.equalsIgnoreCase("edit")) {
			forward = ADDUP;
			int id = Integer.parseInt(request.getParameter("truckId"));
			Truck truck = dao.getTruckById(id);
			request.setAttribute("action", "Atualizar");
			request.setAttribute("destinys", destDao.getAllDestiny());
			request.setAttribute("truck", truck);
		} else if (op.equalsIgnoreCase("listTruck")) {
			forward = LIST;
			request.setAttribute("trucks", dao.getAllTrucks());
			request.setAttribute("destinys", destDao.getAllDestiny());
		} else {
			forward = ADDUP;
			request.setAttribute("action", "Adicionar");
			request.setAttribute("destinys", destDao.getAllDestiny());
			
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
        truck.setDestiny(destDao.getDestinyById(Integer.parseInt(request.getParameter("destiny"))).getId());;
        
        String id = request.getParameter("id");
        if(id == null || id.isEmpty()) {
        	dao.addTruck(truck);
        }
        else {
        	truck.setId(Integer.parseInt(id));
        	dao.updateTruck(truck);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("trucks", dao.getAllTrucks());
        request.setAttribute("destinys", destDao.getAllDestiny());
        view.forward(request, response);
    }
    
}
