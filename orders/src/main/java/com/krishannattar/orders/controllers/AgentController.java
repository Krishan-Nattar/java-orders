package com.krishannattar.orders.controllers;

import com.krishannattar.orders.models.Agent;
import com.krishannattar.orders.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    @Autowired
    private AgentService agentService;

    //http://localhost:2019/agent/{agentcode}
    @DeleteMapping(value = "/agent/{agentcode}",
            produces = {"application/json"})
    public ResponseEntity<?> deleteAgent(@PathVariable long agentcode) {
//        Agent currentAgent = new Agent();

        agentService.delete(agentcode);
        return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
    }
}
