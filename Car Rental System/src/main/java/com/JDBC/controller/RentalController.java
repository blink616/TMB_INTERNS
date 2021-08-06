package com.JDBC.controller;

import com.JDBC.exception.ResourceNotFoundException;
import com.JDBC.model.Car;
import com.JDBC.model.Customer;
import com.JDBC.model.Rental;
import com.JDBC.repository.CarRepository;
import com.JDBC.repository.CustomerRepository;
import com.JDBC.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class RentalController {

    private RentalRepository rentalRepository;
    private CustomerRepository customerRepository;
    private CarRepository carRepository;

//    @GetMapping("rentals")
//	public List<Rental> getAllRentals() {
//		return this.rentalRepository.findAll();
//	}
//
//	@GetMapping("rentals/{id}")
//	public ResponseEntity<Rental> getRental(@PathVariable Long id) throws ResourceNotFoundException {
//		Rental rental = rentalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rental not found for this id :: " + id));
//		return ResponseEntity.ok(rental);
//	}
//
//	@PostMapping("rentals")
//    public Rental createRental(@RequestBody Rental rental, @RequestParam int car_id, @RequestParam int customer_id) throws ResourceNotFoundException {
//        Customer customer = customerRepository.findById((long) customer_id).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customer_id));
//        Car car = carRepository.findById((long) car_id).orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + customer_id));
//
//        rental.setCustomer(customer);
//        rental.setCar(car);
//
//        return rentalRepository.save(rental);
//    }
//
//    @PutMapping("rentals/{id}")
//    public ResponseEntity<Rental> updateRental(@PathVariable Long id, @RequestBody Rental rentalDetails) throws ResourceNotFoundException {
//        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rental not found for this id :: " + id));
//
//        rental.setAmount(rentalDetails.getAmount());
//        rental.setPickUpDate(rentalDetails.getPickUpDate());
//        rental.setReturnDate(rentalDetails.getReturnDate());
//
//        return ResponseEntity.ok(this.rentalRepository.save(rental));
//    }
//
//    @DeleteMapping("rentals/{id}")
//    public Map<String, Boolean> deleteRental(@PathVariable Long id) throws ResourceNotFoundException {
//        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rental not found for this id :: " + id));
//
//        this.rentalRepository.delete(rental);
//
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//
//        return response;
//    }

}
