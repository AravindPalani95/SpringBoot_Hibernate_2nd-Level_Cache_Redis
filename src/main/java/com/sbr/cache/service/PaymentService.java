package com.sbr.cache.service;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbr.cache.dao.PaymentDao;
import com.sbr.cache.dao.entity.AccountBalanceEntity;
import com.sbr.cache.modal.AccountBalance;

@Service
public class PaymentService {
	
	public static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private PaymentDao paymentDao;
	
	public AccountBalance getAccountBalance(long accountId) {
		LOG.info("Inside getAccountBalance - Service Method");
		AccountBalanceEntity accBalEntity = paymentDao.getAccountBalance(accountId);
		LOG.info("AccountBalanceEntity "+ accBalEntity.toString());
		LOG.info("Mapping Entity to Modal");
		AccountBalance accBal = new AccountBalance();
		accBal.setAccountName(accBalEntity.getAccountName());
		accBal.setAccountId(accBalEntity.getAccountId());
		accBal.setLastUpdated(accBalEntity.getLastUpdated());
		accBal.setBalance(accBalEntity.getBalance());
		LOG.info("AccountBalance Modal "+ accBal.toString());
		return accBal;
	}
	
	public void updateAccountBalance(long accountId, float balance) {
		LOG.info("Inside updateAccountBalance - Service Method");
		AccountBalanceEntity accBalEntity = paymentDao.getAccount(accountId);
		accBalEntity.setBalance(balance);
		paymentDao.updateAccount(accBalEntity);
	}
	
	public void updateAccountName(long accountId, String accountName) {
		LOG.info("Inside updateAccountName - Service Method");
		AccountBalanceEntity accBalEntity = paymentDao.getAccount(accountId);
		accBalEntity.setAccountName(accountName);
		paymentDao.updateAccount(accBalEntity);
	}
}
