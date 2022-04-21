package com.tackedev.service;

import com.tackedev.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer get(int id);

    void save(Customer customer);

    void delete(int id);
}
