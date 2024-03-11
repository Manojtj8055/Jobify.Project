package com.xworkz.chocolate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;


@Component
public class ChocolateRepoImpl implements ChocolateRepo {

	public EntityManagerFactory getEntityManagerFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chocolate-connection");
		return emf;
	}

	@Override
	public boolean save(ChocolateDTO dto) {

		EntityManagerFactory emf = getEntityManagerFactory();

		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(dto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			emf.close();
			em.close();
		}
		return false;
	}

	@Override
	public ChocolateDTO findById(int id) {
		EntityManagerFactory emf = getEntityManagerFactory();

		EntityManager em = emf.createEntityManager();

		try {
			ChocolateDTO foundDTO = em.find(ChocolateDTO.class, id);
			return foundDTO;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return null;
	}

	@Override
	public List<ChocolateDTO> readAll() {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		TypedQuery<ChocolateDTO> query = em.createQuery("select dto from ChocolateDTO dto", ChocolateDTO.class);
		return query.getResultList();

	}

	@Override
	public ChocolateDTO findByName(String name) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		TypedQuery<ChocolateDTO> foundData = em.createNamedQuery("findByName", ChocolateDTO.class);

		try {
			foundData.setParameter("nm", name);
			ChocolateDTO result = foundData.getSingleResult();
			return result;
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateQuantityByName(String name,int quantity) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
		
		transaction.begin();
		Query query=em.createNamedQuery("updateByQuantity");
		System.out.println(name);
		System.out.println(quantity);
		query.setParameter("qu", quantity);
		query.setParameter("nm", name);
		
		int rowsChanged=query.executeUpdate();
		transaction.commit();
		em.close();
		emf.close();
		System.out.println(rowsChanged);
		if(rowsChanged>0) {
			return true;
			
		}
		return false;
	}

	@Override
	public boolean deleteById(int id, Model model) {
		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
		
		transaction.begin();
		Query query= em.createNamedQuery("delete");
		query.setParameter("i", id);
		int delete=query.executeUpdate();
		transaction.commit();
		emf.close();
		em.close();
		
		if(delete>0) {
			return true;
		}
		return false;
	}
	
}
