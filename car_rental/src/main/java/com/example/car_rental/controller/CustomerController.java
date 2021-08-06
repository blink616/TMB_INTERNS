package com.JDBC.controller;

import com.JDBC.dbConnection.dbConnection;
import com.JDBC.repository.CustomerRepository;
import com.JDBC.exception.ResourceNotFoundException;
import com.JDBC.model.Customer;
import com.JDBC.model.Rental;
import com.JDBC.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
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
    public List<Customer> getAllCustomers() throws SQLException {
        dbConnection con = new dbConnection();

        return this.customerRepository.AllCustomers(con.makeConnection());
    }

//	@GetMapping("customers/{id}")
//	public ResponseEntity<Customer> getCustomer(@PathVariable Long id) throws ResourceNotFoundException {
//		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
//		return ResponseEntity.ok(customer);
//	}
//
//	@PostMapping("customers")
//    public Customer createCustomer(@RequestBody Customer customer) {
//        return this.customerRepository.save(customer);
//    }
//
//    @PutMapping("customers/{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) throws ResourceNotFoundException {
//        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
//
//        customer.setFirstName(customerDetails.getFirstName());
//        customer.setLastName(customerDetails.getLastName());
//        customer.setEmail(customerDetails.getEmail());
//        customer.setPhoneNumber(customerDetails.getPhoneNumber());
//
//        return ResponseEntity.ok(this.customerRepository.save(customer));
//    }
//
//    @DeleteMapping("customers/{id}")
//    public Map<String, Boolean> deleteCustomer(@PathVariable Long id) throws ResourceNotFoundException {
//        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
//
//        this.customerRepository.delete(customer);
//
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//
//        return response;
//    }
//
//    @GetMapping("customers/{id}/rentals")
//    public List<Rental> getCustomerRentals(@PathVariable Long id) throws ResourceNotFoundException {
//        return this.rentalRepository.findByCustomerId(id);
//    }
}
