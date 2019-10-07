package com.krishannattar.orders.controllers;

import com.krishannattar.orders.models.Customer;
import com.krishannattar.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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
    @GetMapping(value = "/customer/name/{custname}",
    produces = {"application/json"})
    public ResponseEntity<?> findCustomerByName(@PathVariable String custname)
    {
        Customer returnCustomer = customerService.findCustomerByName(custname);
        return new ResponseEntity<>(returnCustomer, HttpStatus.OK);
    }


    //http://localhost:2019/data/customer/new
    @PostMapping(value = "/data/customer/new",
    produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customer newCustomer) throws URISyntaxException
    {
        newCustomer = customerService.save(newCustomer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custname}").buildAndExpand(newCustomer.getCustname()).toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    //http://localhost:2019/data/customer/update/{custcode}
    @PutMapping(value = "/data/customer/update/{custcode}",
    produces = {"application/json"},
    consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable long custcode)
    {

        customerService.update(updatedCustomer, custcode);
        return new ResponseEntity<>("Update Success", HttpStatus.OK);
    }


    //http://localhost:2019/data/customer/delete/{custcode}


}
