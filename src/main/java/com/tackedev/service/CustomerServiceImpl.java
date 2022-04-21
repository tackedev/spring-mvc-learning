package com.tackedev.service;

import com.tackedev.entity.Customer;
import com.tackedev.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @Override
    @Transactional
    public Customer get(int id) {
        return customerRepository.get(id);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void delete(int id) {
        customerRepository.delete(id);
    }

}
