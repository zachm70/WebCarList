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
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarHelper ch = new CarHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String driverName = request.getParameter("driverName");

		String[] selectedCars = request.getParameterValues("allCarsToAdd");
	    List<Car> selectedCarsInList = new ArrayList<Car>();
	    
	    if(selectedCars != null && selectedCars.length > 0) {
	    	for(int i = 0; i <selectedCars.length; i++) {
	    		System.out.println(selectedCars[i]);
	    		Car c = ch.searchForCarById(Integer.parseInt(selectedCars[i]));
	    		selectedCarsInList.add(c);
	    	}
	    }
	    
	    Driver driver = new Driver();
	    CarDetails cd = new CarDetails(listName, driver);
	    cd.setListOfCars(selectedCarsInList);
	    CarDetailHelper cdh = new CarDetailHelper();
	    cdh.insertNewListDetails(cd);
	    
	    System.out.println("success");
	    System.out.println(cdh.toString());
	    
	    getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
