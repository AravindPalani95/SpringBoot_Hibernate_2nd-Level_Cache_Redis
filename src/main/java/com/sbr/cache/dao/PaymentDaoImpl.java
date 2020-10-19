package com.sbr.cache.dao;


import java.lang.invoke.MethodHandles;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbr.cache.dao.entity.AccountBalanceEntity;

@Repository
public class PaymentDaoImpl implements PaymentDao{
	
	public static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public AccountBalanceEntity getAccountBalance(long accountId) {
		LOG.info("Inside getAccountBalance - DAO Method");
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<AccountBalanceEntity> cQuery = criteriaBuilder.createQuery(AccountBalanceEntity.class);
		Root<AccountBalanceEntity> root = cQuery.from(AccountBalanceEntity.class);
		cQuery.select(root).where(criteriaBuilder.equal(root.get("accountId"),accountId));
		Query<AccountBalanceEntity> query = session.createQuery(cQuery);
		LOG.info("Exit Account Balance Method - DAO Method");
		return query.getSingleResult();
	}
	
	@Override
	public AccountBalanceEntity getAccount(long accountId) {
		LOG.info("Inside getAccount - DAO Method");
		Session session = sessionFactory.openSession();
		return session.find(AccountBalanceEntity.class,accountId);
	}
	
	@Override
	public void updateAccount(AccountBalanceEntity accountBalanceEntity) {
		LOG.info("Inside updateAccount - DAO Method");
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(accountBalanceEntity);
			session.getTransaction().commit();	
		}
		catch(Exception e) {
			LOG.error("Exception occured while updating Account : ",e.getMessage());
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}
