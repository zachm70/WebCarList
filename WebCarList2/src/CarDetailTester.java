import java.util.ArrayList;
import java.util.List;

import controller.CarDetailHelper;
import controller.DriverHelper;
import model.Car;
import model.CarDetails;
import model.Driver;

public class CarDetailTester {
	public static void main(String[] args) {
		Driver zach = new Driver("Zach");
		
		DriverHelper dh = new DriverHelper();
		
		CarDetailHelper cdh = new CarDetailHelper();
		
		Car car1 = new Car("chevy", "trax");
		Car car2 = new Car("audi", "r8");
		
		List<Car> zachsCars = new ArrayList<Car>();
		zachsCars.add(car1);
		zachsCars.add(car2);
		
		
		
		CarDetails zachCar = new CarDetails("Zach's Cars", zach);
		
		zachCar.setListOfCars(zachsCars);
		
		cdh.insertNewListDetails(zachCar);
		
		List<CarDetails> allCars = cdh.getCars();
		
		for(CarDetails a : allCars) {
			System.out.println(a.toString());
		}
			
		
	}
}
