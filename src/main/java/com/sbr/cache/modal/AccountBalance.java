package com.sbr.cache.modal;

import java.io.Serializable;
import java.util.Date;

public class AccountBalance implements Serializable{

	private static final long serialVersionUID = 2786157178274448138L;
	
	private String accountName;
	
	private long accountId;
	
	private Date lastUpdated;
	
	private double balance;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "AccountBalance [ accountId = "+ this.accountId +", lastUpdated = ]"+ this.lastUpdated 
				+ ", balance = "+ this.balance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
