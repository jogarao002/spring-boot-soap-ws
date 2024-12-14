package com.intellect.spring.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.intellect.spring.soap.api.loaneligibility.Acknowledgement;
import com.intellect.spring.soap.api.loaneligibility.CustomerRequest;
import com.intellect.spring.soap.api.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityindicatorEndpoint {
	
	@Autowired
	private LoanEligibilityService service;

	@PayloadRoot(namespace = "http://www.intellect.com/spring/soap/api/loanEligibility", localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}
}
