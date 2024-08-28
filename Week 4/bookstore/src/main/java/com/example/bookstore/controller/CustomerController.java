package com.example.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.model.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();
    private Long customerIdCounter = 1L;

    // Initializing some dummy data
    public CustomerController() {
        customers.add(new Customer(customerIdCounter++, "John Doe", "john.doe@example.com", "123-456-7890"));
        customers.add(new Customer(customerIdCounter++, "Jane Smith", "jane.smith@example.com", "098-765-4321"));
    }

    // Handle POST request to create a new customer
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setId(customerIdCounter++);
        customers.add(customer);
        return customer;
    }

    // Handle GET request to retrieve all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @PostMapping("/register")
public Customer registerCustomer(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("phone") String phone) {
    Customer customer = new Customer(customerIdCounter++, name, email, phone);
    customers.add(customer);
    return customer;
}

}
