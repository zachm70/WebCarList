package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarDetails;
import model.Driver;

public class CarDetailHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarList");
	
	public void insertNewListDetails(CarDetails d) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarDetails> getCars(){
		EntityManager em = emfactory.createEntityManager();
		List<CarDetails> allDetails = em.createQuery("SELECT d FROM CarDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(CarDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<CarDetails> typedQuery = em.createQuery("select detail from CarDetails detail where detail.id = :selectedId", CarDetails.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		
		CarDetails result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public CarDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CarDetails found = em.find(CarDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateList(CarDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public Driver findDriver(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Driver> typedQuery = em.createQuery("select dh from Driver dh where dh.driverName = :selectedName",Driver.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Driver foundDriver;
		
		try {
		foundDriver = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
		foundDriver = new Driver(nameToLookUp);
		}
		em.close();
		return foundDriver;
		}
}
