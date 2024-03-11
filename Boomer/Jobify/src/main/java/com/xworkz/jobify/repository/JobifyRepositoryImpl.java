package com.xworkz.jobify.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import com.workz.jobify.dto.JobifyEntity;

@Component
public class JobifyRepositoryImpl implements JobifyRepository {

//	public EntityManagerFactory getEntityManagerFactory() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobify-connection");
//		return emf;

//	}

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean save(JobifyEntity entity) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.persist(entity);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();

		}

		return false;
	}

//	@Override
//	public List<JobifyEntity> readAll() {
//
//		EntityManager em = emf.createEntityManager();
//		TypedQuery<JobifyEntity> query = em.createNamedQuery("readAll",JobifyEntity.class);
//		query.setParameter("ra", query);	
//		return query.getResultList();
//
//	}

	@Override
	public JobifyEntity findByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		// EntityTransaction transaction= em.getTransaction();
		TypedQuery<JobifyEntity> foundData = em.createNamedQuery("findByEmail",JobifyEntity.class);
		
		try {
			foundData.setParameter("eq", email);
			JobifyEntity result=foundData.getSingleResult();
			return result;
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	

}
