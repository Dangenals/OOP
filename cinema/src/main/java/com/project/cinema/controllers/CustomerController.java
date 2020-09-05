package com.project.cinema.controllers;


import com.project.cinema.model.Customer;
import com.project.cinema.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomerById(@PathVariable int id) {
        customerService.deleteCustomerById(id);
        return "Customer was deleted";
    }

    @PostMapping("/customers")
    public String createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return "Customer was added";
    }
}
