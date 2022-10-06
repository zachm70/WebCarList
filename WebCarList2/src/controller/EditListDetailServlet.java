package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.CarDetails;
import model.Driver;

/**
 * Servlet implementation class EditListDetailServlet
 */
@WebServlet("/editListDetailServlet")
public class EditListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarDetailHelper cdh = new CarDetailHelper();
		CarHelper ch = new CarHelper();
		DriverHelper dh = new DriverHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		CarDetails carsToUpdate = cdh.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		String driverName = request.getParameter("driverName");

		Driver newDriver = cdh.findDriver(driverName);

		try {
			String[] selectedItems =request.getParameterValues("allCarsToAdd");
			
			List<Car> selectedCarsInList = new ArrayList<Car>();
			
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Car c =ch.searchForCarById(Integer.parseInt(selectedItems[i]));
				selectedCarsInList.add(c);
			}
				carsToUpdate.setListOfCars(selectedCarsInList);
		} catch (NullPointerException ex) {
			List<Car> selectedCarsInList = new ArrayList<Car>();
			carsToUpdate.setListOfCars(selectedCarsInList);
		}
		carsToUpdate.setDriverName(newListName);
		carsToUpdate.setDriver(newDriver);
		cdh.updateList(carsToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
	}

}
