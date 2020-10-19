package com.sbr.cache.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbr.cache.modal.AccountBalance;

public interface IPaymentController {
	
	@GetMapping(value = "/getAccountBalance", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountBalance> getAccountBalance(@RequestParam("accountId") long accountId);
	
	@PutMapping(value = "/updateAccountBalance/{accountId}/{balance}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateAccountBalance(@PathVariable("accountId") long accountId,@PathVariable("balance") long balance);
	
	@PutMapping(value = "/updateAccountName/{accountId}/{accountName}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateAccountName(@PathVariable("accountId") long accountId,@PathVariable("accountName") String accountName);

}
