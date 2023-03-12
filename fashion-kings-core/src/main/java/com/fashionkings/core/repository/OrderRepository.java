package com.fashionkings.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fashionkings.core.jpa.Customer;
import com.fashionkings.core.jpa.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	Optional<Order> findByStatusAndCustomer(Order.OrderStatus status, Customer customer);
	
	Optional<Order> findByStatusAndCustomerId(Order.OrderStatus status, long customerId);

}
