package com.mina.customer.crud.repository;

import com.mina.customer.crud.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
