package com.krishannattar.orders.services;

import com.krishannattar.orders.models.Customer;

import java.util.List;

public interface CustomerService {


List<Customer> findAll();

Customer findCustomerByName(String name);

Customer save(Customer customer);

Customer update(Customer customer, long custcode);

void delete(long custcode);

}
