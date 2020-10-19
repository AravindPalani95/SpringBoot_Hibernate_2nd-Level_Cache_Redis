package com.sbr.cache.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "account_balance")
@Cache(region = "AccountBalanceCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class AccountBalanceEntity implements Serializable{

	private static final long serialVersionUID = -9029369949308706941L;

	@Id
	@Column(name = "account_id")
	private long accountId;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated")
	private Date lastUpdated;
	
	@Column(name = "balance")
	private double balance;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
		return "[Account Id = "+ this.accountId + ", Account Name = "+ this.accountName +", "+
				"Account Type = " + this.accountType +" last updated = "+ this.lastUpdated;
	}
	
}
