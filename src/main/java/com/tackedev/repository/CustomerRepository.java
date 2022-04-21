package com.tackedev.repository;

import com.tackedev.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getCustomers();

    Customer get(int id);

    void save(Customer customer);

    void delete(int id);
}
