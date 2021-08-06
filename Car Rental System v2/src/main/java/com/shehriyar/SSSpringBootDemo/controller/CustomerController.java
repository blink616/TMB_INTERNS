package com.shehriyar.SSSpringBootDemo.controller;

import com.shehriyar.SSSpringBootDemo.database.DBConnection;
import com.shehriyar.SSSpringBootDemo.exception.ResourceNotFoundException;
import com.shehriyar.SSSpringBootDemo.model.Customer;
import com.shehriyar.SSSpringBootDemo.model.Customer;
import com.shehriyar.SSSpringBootDemo.model.Rental;
import com.shehriyar.SSSpringBootDemo.repository.CustomerRepository;
import com.shehriyar.SSSpringBootDemo.repository.CustomerRepository;
import com.shehriyar.SSSpringBootDemo.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RentalRepository rentalRepository;

    @GetMapping("customers")
    public List<Customer> getAllCustomers() {
        Connection db_con = DBConnection.make_connection();

        return customerRepository.findAll(db_con);
    }

    @GetMapping("customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) throws ResourceNotFoundException {
        Connection db_con = DBConnection.make_connection();

        Customer customer = customerRepository.findById(db_con, id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("customers")
    public Map<String, Boolean> createCustomer(@RequestBody Customer customer) {
        Connection db_con = DBConnection.make_connection();

        boolean isAdded = this.customerRepository.save(db_con, null, customer);

        Map<String, Boolean> response = new HashMap<>();
        response.put("added", isAdded);

        return response;
    }

    @PutMapping("customers/{id}")
    public Map<String, Boolean> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Connection db_con = DBConnection.make_connection();

        boolean isUpdated = this.customerRepository.save(db_con, id, customerDetails);

        Map<String, Boolean> response = new HashMap<>();
        response.put("updated", isUpdated);

        return response;
    }

    @DeleteMapping("customers/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable Long id) throws ResourceNotFoundException {
        Connection db_con = DBConnection.make_connection();

        boolean isDeleted = this.customerRepository.delete(db_con, id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", isDeleted);

        return response;
    }

    @GetMapping("customers/{id}/rentals")
    public List<Rental> getCustomerRentals(@PathVariable Long id) throws ResourceNotFoundException {
        Connection db_con = DBConnection.make_connection();

        return this.rentalRepository.findByCustomerId(db_con, id);
    }
    
}
