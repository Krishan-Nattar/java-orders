package com.krishannattar.orders.repos;

import com.krishannattar.orders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
