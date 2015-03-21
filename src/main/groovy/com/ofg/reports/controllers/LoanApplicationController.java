package com.ofg.reports.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import com.google.common.collect.Lists;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofg.reports.model.LoanApplicationDto;
import com.ofg.reports.model.entities.Client;
import com.ofg.reports.model.entities.LoanApplication;
import com.ofg.reports.repository.ClientRepository;
import com.ofg.reports.repository.LoanApplicationRepository;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import groovy.util.logging.Slf4j;

/**
 * @author mzielinski on 21.03.15.
 */
@Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "loan", description = "Loan application operations")
public class LoanApplicationController {

    private Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private LoanApplicationRepository loanRepository;
    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/reporting", method = GET, headers="Accept=application/json")
    @ApiOperation(value = "Gets all loans")
    public Iterable<LoanApplication> getLoans() {
        Iterable<LoanApplication> loans = loanRepository.findAll();
        log.info("Found loans {}", DefaultGroovyMethods.size(loans));
        return loans;
    }

    @RequestMapping(value = "/reporting", method = POST, headers="Accept=application/json")
    @ApiOperation(value = "Put one loan")
    public LoanApplicationDto saveLoan(@RequestBody LoanApplicationDto model) {
        log.info("loan {}", model);

        LoanApplication loan = loanRepository.findByLoanId(model.getLoanId());
        if (loan == null) {
            log.info("New loan");
            loan = new LoanApplication(model);
            loanRepository.save(loan);
        } else {
            log.info("Already saved...");
        }
        return model;
    }

    @RequestMapping(value = "/reporting", method = PUT, headers="Accept=application/json")
    @ApiOperation(value = "Put one loan")
    public LoanApplicationDto updateLoan(@RequestBody LoanApplicationDto model) {
        log.info("loan {}", model);

        LoanApplication loan = loanRepository.findByLoanId(model.getLoanId());
        if (loan != null) {
            log.info("Update loan {}", loan);
            loan.setDecision(model.getDecision());
            loan.setFraudStatus(model.getFraudStatus());
            loan.setJob(model.getJob());
        } else {
            log.info("New loan");
            loan = new LoanApplication(model);
        }
        loanRepository.save(loan);
        return model;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

}
