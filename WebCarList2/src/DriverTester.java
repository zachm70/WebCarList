import java.util.List;

import controller.DriverHelper;
import model.Driver;

public class DriverTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Driver zach = new Driver("Zach");
		
		DriverHelper dh = new DriverHelper();
		
		dh.insertDriver(zach);
		
		List<Driver> allDrivers = dh.showAllDrivers();
		for(Driver d: allDrivers) {
			System.out.println(d.toString());
		}
	}

}
