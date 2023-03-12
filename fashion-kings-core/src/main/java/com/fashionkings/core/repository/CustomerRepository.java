package com.fashionkings.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fashionkings.core.jpa.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
