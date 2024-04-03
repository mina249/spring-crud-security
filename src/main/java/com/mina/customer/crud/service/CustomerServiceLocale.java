package com.mina.customer.crud.service;

import com.mina.customer.crud.model.Customer;

import java.util.List;

public interface CustomerServiceLocale {

    public List<Customer> findAll();

    public Customer save(Customer customer);

    public void remove(Customer customer);

    public Customer findById(int id);
}
