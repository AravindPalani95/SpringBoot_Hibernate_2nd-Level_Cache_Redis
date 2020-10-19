package com.sbr.cache.controller;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbr.cache.modal.AccountBalance;
import com.sbr.cache.service.PaymentService;



@RestController
@RequestMapping(value = "/payment")
public class PaymentController implements IPaymentController{
	
	public static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private PaymentService paymentService;

	@Override
	public ResponseEntity<AccountBalance> getAccountBalance(long accountId) {
		LOG.info("Inside Get Account Balance Method");
		AccountBalance accBalnace = paymentService.getAccountBalance(accountId);
		LOG.info("Exit Get Account Balance Method");
		return new ResponseEntity<AccountBalance>(accBalnace, HttpStatus.OK);  
	}

	@Override
	public ResponseEntity<String> updateAccountBalance(long accountId, long balance) {
		LOG.info("Inside Update Account Balance Method");
		paymentService.updateAccountBalance(accountId,balance);
		LOG.info("Exit Update Account Balance Method");
		return new ResponseEntity<String>("Account Balance Updated Successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updateAccountName(long accountId, String accountName) {
		LOG.info("Inside Update Account Name Method");
		paymentService.updateAccountName(accountId,accountName);
		LOG.info("Exit Update Account Name Method");
		return new ResponseEntity<String>("Account Name Updated Successfully", HttpStatus.OK);
	}

}
