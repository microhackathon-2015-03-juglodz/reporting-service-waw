package com.ofg.reports.controllers

import com.ofg.reports.model.LoanApplicationDto
import com.ofg.reports.model.entities.LoanApplication
import com.ofg.reports.repository.LoanApplicationRepository
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

/**
 * @author mzielinski on 21.03.15.
 */
@Slf4j
@RestController
@RequestMapping('/api')
@Api(value = "loan", description = "Loan application operations")
class LoanApplicationController {

    @Autowired
    private LoanApplicationRepository loanRepository

    @RequestMapping(value = '/reporting', method = GET)
    @ApiOperation(value = "Gets all loans")
    Iterable<LoanApplication> getLoans() {
        def loans = loanRepository.findAll()
        log.info("Found loans {}", loans.size())
        return loans
    }

    @RequestMapping(value = '/reporting', method = POST)
    @ApiOperation(value = "Put one loan")
    LoanApplicationDto saveLoan(LoanApplicationDto model) {
        def loan = loanRepository.findByLoanId(model.getLoanId())
        if (loan != null) {
            log.info("Update loan {}", loan)
            loan.setDecision(model.decision)
            loan.setFraudStatus(model.fraudStatus)
        } else {
            log.info("New loan {}", loan)
            loan = new LoanApplication(model)
        }
        loanRepository.save(loan)
        return model
    }

}