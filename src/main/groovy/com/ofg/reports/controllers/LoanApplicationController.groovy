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
import static org.springframework.web.bind.annotation.RequestMethod.PUT

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

    @RequestMapping(value = '/loan', method = GET)
    @ApiOperation(value = "Gets all loans")
    Iterable<LoanApplication> getLoans() {
        def loans = loanRepository.findAll()
        log.info("Found loans {}", loans.size())
        return loans
    }

    @RequestMapping(value = '/loan', method = PUT)
    @ApiOperation(value = "Put one loan")
    LoanApplication saveLoan(LoanApplicationDto model) {
        def loan = loanRepository.save(new LoanApplication(model))
        log.info("Save loan {}", loan)
        return loan
    }

}
