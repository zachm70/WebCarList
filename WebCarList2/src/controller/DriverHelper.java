package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Driver;

public class DriverHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarList");
	
	public void insertDriver(Driver d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Driver> showAllDrivers(){
		EntityManager em = emfactory.createEntityManager();
		List<Driver> allDrivers = em.createQuery("SELECT d FROM Driver d").getResultList();
		return allDrivers;
	}
}
