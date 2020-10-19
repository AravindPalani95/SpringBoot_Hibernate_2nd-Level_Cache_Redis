package com.sbr.cache.dao;

import com.sbr.cache.dao.entity.AccountBalanceEntity;

public interface PaymentDao {

	public AccountBalanceEntity getAccountBalance(long accountId);

	public AccountBalanceEntity getAccount(long accountId);

	public void updateAccount(AccountBalanceEntity accountBalanceEntity);
	
}
