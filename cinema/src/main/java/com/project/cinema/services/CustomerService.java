package com.project.cinema.services;


import com.project.cinema.model.Customer;
import com.project.cinema.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
      return customerRepository.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    public void deleteCustomerById(int id) {
         customerRepository.deleteCustomerById(id);
    }

    public void createCustomer(Customer customer) {
        customerRepository.insertCustomer(customer);
    }
}
