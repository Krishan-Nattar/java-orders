package com.krishannattar.orders.controllers;

import com.krishannattar.orders.models.Customer;
import com.krishannattar.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //http://localhost:2019/customer/order+

    @GetMapping(value = "/customer/order",
    produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myCustomers = customerService.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }
    
    //http://localhost:2019/customer/name/{custname}
    //http://localhost:2019/data/customer/new
    //http://localhost:2019/data/customer/update/{custcode}
    //http://localhost:2019/data/customer/delete/{custcode}


}
