package com.krishannattar.orders.repos;

import com.krishannattar.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByCustname(String custname);
}
