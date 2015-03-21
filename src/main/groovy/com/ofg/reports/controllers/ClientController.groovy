package com.ofg.reports.controllers

import com.ofg.reports.model.ClientDto
import com.ofg.reports.model.entities.Client
import com.ofg.reports.repository.ClientRepository
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
@Api(value = "client", description = "Client operations")
class ClientController {

    @Autowired
    private ClientRepository clientRepository

    @Autowired
    private LoanApplicationRepository loanApplicationRepository

    @RequestMapping(value = '/client', method = GET)
    @ApiOperation(value = "Gets all clients")
    Iterable<Client> getClients() {
        def clients = clientRepository.findAll()
        log.info("Found client {}", clients)
        return clients
    }

    @RequestMapping(value = '/client', method = POST)
    @ApiOperation(value = "Put one client")
    ClientDto saveClient(ClientDto model) {
        def client = new Client(model)
        def loan = loanApplicationRepository.findByLoanId(model.getLoanId())
        if (loan != null) {
            client.getLoan().add(loan)
        }
        clientRepository.save(client)
        return model
    }

}
