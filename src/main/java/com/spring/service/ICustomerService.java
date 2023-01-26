package com.spring.service;

import com.spring.entities.Customer;

import java.util.List;

public interface ICustomerService {

    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
