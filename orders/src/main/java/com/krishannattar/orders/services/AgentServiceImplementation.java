package com.krishannattar.orders.services;

import com.krishannattar.orders.models.Agent;
import com.krishannattar.orders.models.Customer;
import com.krishannattar.orders.repos.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service(value = "agentService")
public class AgentServiceImplementation implements AgentService{

    @Autowired
    private AgentRepository agentRepos;


    @Override
    public void delete(long agentcode) {

        Agent currentAgent = agentRepos.findById(agentcode)
                .orElseThrow(()-> new EntityNotFoundException(Long.toString(agentcode)));
        if(currentAgent.getCustomers().size() == 0)
        {
            agentRepos.deleteById(agentcode);
        } else {
            throw new EntityExistsException("This agent still has customers");
        }
    }
}
