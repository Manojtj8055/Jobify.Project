package com.xworkz.jobify.repository;

import java.util.List;

import javax.imageio.ImageTranscoder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mysql.cj.Query;
import com.xworkz.jobify.dto.JobRegisterEntity;
import com.xworkz.jobify.dto.JobifyEntity;

@Repository
public class JobifyRepositoryImpl implements JobifyRepository {

	@PersistenceUnit
	private EntityManagerFactory emf;
	public boolean updateLoginAttemptByEmail;

	@Override
	@Transactional
	public boolean save(JobifyEntity entity) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			entity = em.merge(entity);
			em.persist(entity);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();

		}
		System.out.println(entity);

		return true;
	}

	@Override
	public JobifyEntity findByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<JobifyEntity> foundData = em.createNamedQuery("findByEmail", JobifyEntity.class);
		foundData.setParameter("eq", email);
		try {
			return foundData.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateLoginAttemptByEmail(int loginAttempts, String email) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			TypedQuery<JobifyEntity> dataUpdate = em.createNamedQuery("updateLoginAttemptByEmail", JobifyEntity.class);
			dataUpdate.setParameter("up", loginAttempts);
			dataUpdate.setParameter("email", email);

			int updatedRows = dataUpdate.executeUpdate();
			transaction.commit();

			return updatedRows > 0;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}

	}

	@Transactional
	public boolean saveJob(JobRegisterEntity registerEntity) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			registerEntity = entityManager.merge(registerEntity);
			// entityManager.persist(registerEntity);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
		System.out.println("Registering Entity is : - " + registerEntity);
		return true;

	}

	@Override
	public List<JobRegisterEntity> getJobsByJobProviderEmail(String jobProviderEmail) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<JobRegisterEntity> fetchJob = em.createNamedQuery("jobUploaded", JobRegisterEntity.class);
		fetchJob.setParameter("je", jobProviderEmail);

		try {
			return fetchJob.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	public JobRegisterEntity getJobsById(Integer jobsId) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<JobRegisterEntity> fetchJobById = em.createNamedQuery("jobId", JobRegisterEntity.class);
		fetchJobById.setParameter("id", jobsId);

		try {
			return fetchJobById.getSingleResult();

		} catch (NoResultException e) {

			System.out.println("No entity found for ID: " + jobsId);

			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}

	}

	public JobRegisterEntity updateExistingJob(JobRegisterEntity updatedJob) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			JobRegisterEntity existingJob = em.find(JobRegisterEntity.class, updatedJob.getId());

			if (existingJob != null) {
				existingJob = em.merge(updatedJob);
				transaction.commit();
				return existingJob;
			} else {

				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;

	}

	@Transactional
	public boolean softDeleteJobById(Integer jobId, String jobProviderEmail) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();

			javax.persistence.Query updateQuery = em.createNamedQuery("softDeleteById");
			updateQuery.setParameter("jobId", jobId);
			updateQuery.setParameter("jobProviderEmail", jobProviderEmail);

			int updatedRows = updateQuery.executeUpdate();
			transaction.commit();

			return updatedRows > 0;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}

	}
//	@Override
//	public List<JobRegisterEntity> allActiveJobs(String loggedInUserEmail) {
//	    EntityManager em = emf.createEntityManager();
//	    TypedQuery<JobRegisterEntity> active = em.createNamedQuery("JobRegisterEntity.readAll", JobRegisterEntity.class);
//	    return active.getResultList();
//	}

	@Override
	public List<JobRegisterEntity> allActiveJobs() {
		  EntityManager em = emf.createEntityManager();
		    TypedQuery<JobRegisterEntity> active = em.createNamedQuery("JobRegisterEntity.readAll", JobRegisterEntity.class);
		    return active.getResultList();
	}


}
