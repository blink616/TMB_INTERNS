package com.example.car_rental.controller;

import com.example.car_rental.exceptions.ResourceNotFoundException;
import com.example.car_rental.model.Customer;
import com.example.car_rental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    //get customers
    @GetMapping("customers")
    public List<Customer> getAllCustomer () {
        return this.customerRepository.findAll();
    }
    //get customer by id
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
        throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer not found for this id :: " + customerId ));
        return ResponseEntity.ok().body(customer);
    }

    //save customer
    @PostMapping("customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return this.customerRepository.save(customer);
    }

    //update customer
    @PutMapping("customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId, @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: " + customerId));
        customer.setEmail(customerDetails.getEmail());
        customer.setFirstname(customerDetails.getFirstname());
        customer.setLastname(customerDetails.getLastname());
        customer.setState(customerDetails.getState());
        customer.setSsn(customerDetails.getSsn());
        customer.setCountry(customerDetails.getCountry());
        customer.setContact(customerDetails.getContact());
        return ResponseEntity.ok(this.customerRepository.save(customer));
    }

    //delete customer
    @DeleteMapping("customers/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long customerId) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        this.customerRepository.delete(customer);

        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

}
