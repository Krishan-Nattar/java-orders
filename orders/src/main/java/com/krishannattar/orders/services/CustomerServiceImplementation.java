package com.krishannattar.orders.services;

import com.krishannattar.orders.models.Customer;
import com.krishannattar.orders.models.Order;
import com.krishannattar.orders.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerRepository customerRepos;

    @Override
    public List<Customer> findAll() {
        List<Customer> returnList = new ArrayList<>();
        customerRepos.findAll().iterator().forEachRemaining(returnList::add);
        return returnList;
    }

    @Override
    public Customer findCustomerByName(String custname) {

        Customer returnCustomer = customerRepos.findByName(custname);

        if (returnCustomer==null)
        {
            throw new EntityNotFoundException("Customer Not Found: " + custname);
        }

        return returnCustomer;
    }

    @Override
    public Customer save(Customer customer) {

        Customer newCustomer = new Customer;
        newCustomer.setAgent(customer.getAgent());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setWorkingarea(customer.getWorkingarea());

        for(Order o: customer.getOrders())
        {
            newCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamount(), o.getOrddescription(), newCustomer));
        }


        return customerRepos.save(newCustomer);
    }

    @Override
    public Customer update(Customer customer, long custcode) {
        return null;
    }

    @Override
    public void delete(long custcode) {

    }
}
