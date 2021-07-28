package com.example.carRental1.controller;

import com.example.carRental1.exception.ResourceNotFoundException;
import com.example.carRental1.model.Customers;
import com.example.carRental1.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CustomersController {
    @Autowired
    private CustomersRepository customersRepository;

    //get Customers
    @GetMapping("customers")
    public List<Customers> getAllCustomers() {
        return this.customersRepository.findAll();
    }

    //get customers by id
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customers> getCustomersById(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        Customers customers = customersRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id::" + customerId));
        return ResponseEntity.ok().body(customers);
    }

    //save customers
    @PostMapping("customers")
    public Customers createCustomers(@RequestBody Customers customers) {
        return this.customersRepository.save(customers);

    }

    //update customer
    @PutMapping("customers/{id}")
    public ResponseEntity<Customers> updateCustomers(@PathVariable(value = "id") Long customerId,
                                                   @RequestBody Customers customerDetails) throws ResourceNotFoundException {
        Customers customers = customersRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id::" + customerId));
        customers.setCustomer_id(customerDetails.getCustomer_id());
        customers.setFirst_name(customerDetails.getFirst_name());
        customers.setLast_name(customerDetails.getLast_name());
        customers.setEmail(customerDetails.getEmail());
        customers.setSSN(customerDetails.getSSN());
        customers.setCountry(customerDetails.getCountry());
        customers.setState(customerDetails.getState());
        customers.setMobile_phone(customerDetails.getMobile_phone());

        return ResponseEntity.ok(this.customersRepository.save(customers));

    }

    //delete customer
    public Map<String, Boolean> deleteCustomers(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        {
            Customers customers = customersRepository.findById(customerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id::" + customerId));

            this.customersRepository.delete((customers));
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);

            return response;
        }
    }


}
