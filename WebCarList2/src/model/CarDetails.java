package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;;
@Entity
public class CarDetails {
	@Id
	@GeneratedValue
	private int id;
	private String driverName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Driver Driver;
	@OneToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Car> listOfCars;

	public CarDetails() {
		super();
	}

	

	public CarDetails(int id, String driverName, model.Driver driver, List<Car> listOfCars) {
		super();
		this.id = id;
		this.driverName = driverName;
		Driver = driver;
		this.listOfCars = listOfCars;
	}
	
	public CarDetails(String driverName, model.Driver driver) {
		super();
		this.driverName = driverName;
		Driver = driver;
	}
	
	public CarDetails(String driverName, model.Driver driver, List<Car> listOfCars) {
		super();
		this.driverName = driverName;
		Driver = driver;
		this.listOfCars = listOfCars;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Driver getDriver() {
		return Driver;
	}

	public void setDriver(Driver driver) {
		Driver = driver;
	}

	public List<Car> getListOfCars() {
		return listOfCars;
	}

	public void setListOfCars(List<Car> listOfCars) {
		this.listOfCars = listOfCars;
	}

	@Override
	public String toString() {
		return "CarDetails [id=" + id + ", listName=" + driverName + ", Driver=" + Driver + ", listOfCars="
				+ listOfCars + "]";
	}
	
	
	
	
	
	
}
