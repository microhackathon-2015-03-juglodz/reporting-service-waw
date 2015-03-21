package com.ofg.reports.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofg.reports.model.ClientDto;
import com.ofg.reports.model.entities.Client;
import com.ofg.reports.model.entities.LoanApplication;
import com.ofg.reports.repository.ClientRepository;
import com.ofg.reports.repository.LoanApplicationRepository;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * @author mzielinski on 21.03.15.
 */
@RestController
@RequestMapping("/api")
@Api(value = "client", description = "Client operations")
public class ClientController {

    private Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @RequestMapping(value = "/client", method = GET, headers="Accept=application/json")
    @ApiOperation(value = "Gets all clients")
    public Iterable<Client> getClients() {
        Iterable<Client> clients = clientRepository.findAll();
        log.info("Found client {}", clients);
        return clients;
    }

    @RequestMapping(value = "/client", method = POST, headers="Accept=application/json")
    @ApiOperation(value = "Put one client")
    public ClientDto saveClient(@RequestBody ClientDto model) {
        log.info("client {}", model);
        Client client = new Client(model);
        LoanApplication loan = loanApplicationRepository.findByLoanId(model.getLoanId());
        if (loan != null) {
            client.getLoan().add(loan);
        }
        clientRepository.save(client);
        return model;
    }

}
