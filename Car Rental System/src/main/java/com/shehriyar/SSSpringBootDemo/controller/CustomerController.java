package com.shehriyar.SSSpringBootDemo.controller;

import com.shehriyar.SSSpringBootDemo.exception.ResourceNotFoundException;
import com.shehriyar.SSSpringBootDemo.model.Customer;
import com.shehriyar.SSSpringBootDemo.model.Rental;
import com.shehriyar.SSSpringBootDemo.repository.CustomerRepository;
import com.shehriyar.SSSpringBootDemo.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		return this.customerRepository.findAll();
	}

	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
		return ResponseEntity.ok(customer);
	}

	@PostMapping("customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    @PutMapping("customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));

        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());

        return ResponseEntity.ok(this.customerRepository.save(customer));
    }

    @DeleteMapping("customers/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable Long id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));

        this.customerRepository.delete(customer);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    @GetMapping("customers/{id}/rentals")
    public List<Rental> getCustomerRentals(@PathVariable Long id) throws ResourceNotFoundException {
        return this.rentalRepository.findByCustomerId(id);
    }
}
