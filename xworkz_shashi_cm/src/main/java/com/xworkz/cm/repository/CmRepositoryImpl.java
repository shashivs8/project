package com.xworkz.cm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.cm.entity.CmEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CmRepositoryImpl implements CmRepository {

	@Autowired
	public EntityManagerFactory entityManagerFactory;

	@Override
	public boolean save(CmEntity userEntity) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(userEntity);
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}

	@Override
	public CmEntity userSignIn(String userId, String password) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("userANDpassword");
			query.setParameter("ui", userId);
			query.setParameter("pwd", password);
			Object object = query.getSingleResult();
			CmEntity entity = (CmEntity) object;
			log.info("" + entity);
			return entity;
		} finally {
			em.close();
		}

	}

	@Override 
	public List<CmEntity> findAll() {
		EntityManager em =	  this.entityManagerFactory.createEntityManager(); try { Query query =
	  em.createNamedQuery("find"); List<CmEntity> list = query.getResultList();
	  log.info("Total list size found in repo" + list.size()); return list; }
	  finally { em.close(); }
	}

	@Override public Long findByEmail(String email) { EntityManager em =
	  this.entityManagerFactory.createEntityManager(); try { Query query =
	  em.createNamedQuery("emailId"); query.setParameter("emailBy", email); Object
	  object = query.getSingleResult(); Long value = (Long) object;
	  System.out.println(value); return value;
	  
	  } finally { em.close(); }
	  
	  }

	@Override public Long findByUser(String user) { EntityManager em =
	  this.entityManagerFactory.createEntityManager(); try { Query query =
	  em.createNamedQuery("userId"); query.setParameter("userBy", user); Object
	  object = query.getSingleResult(); Long value = (Long) object;
	  System.out.println(value); return value;
	  
	  } finally { em.close(); } }

	@Override
	public Long findByMobile(Long number) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("mobileId");
			query.setParameter("mobileBy", number);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			em.close();
		}
	}

}
