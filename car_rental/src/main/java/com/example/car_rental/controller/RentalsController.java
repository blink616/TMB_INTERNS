package com.example.car_rental.controller;

import com.example.car_rental.exceptions.ResourceNotFoundException;
import com.example.car_rental.model.Customer;
import com.example.car_rental.model.Rentals;
import com.example.car_rental.repository.CustomerRepository;
import com.example.car_rental.repository.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class RentalsController {
    @Autowired
    private RentalsRepository rentalsRepository;

    //get rentals
    @GetMapping("rentals")
    public List<Rentals> getAllRentals () {
        return this.rentalsRepository.findAll();
    }
    //get rental by id
    @GetMapping("/rentals/{id}")
    public ResponseEntity<Rentals> getRentalsById(@PathVariable(value = "id") Long rentalId)
            throws ResourceNotFoundException {
        Rentals rentals = rentalsRepository.findById(rentalId).orElseThrow(()-> new ResourceNotFoundException("Rentals not found for this id :: " + rentalId ));
        return ResponseEntity.ok().body(rentals);
    }

    //save rental
    @PostMapping("rentals")
    public Rentals createRental(@RequestBody Rentals rental){
        return this.rentalsRepository.save(rental);
    }

    //update rental
    @PutMapping("rentals/{id}")
    public ResponseEntity<Rentals> updateRental(@PathVariable(value = "id") Long rentalId, @RequestBody Rentals rentalDetails) throws ResourceNotFoundException {
        Rentals rental = rentalsRepository.findById(rentalId).orElseThrow(()-> new ResourceNotFoundException("Rental not found for this id :: " + rentalId));
        rental.setAmount(rentalDetails.getAmount());
        rental.setPickup_date(rentalDetails.getPickup_date());
        rental.setReturn_date(rentalDetails.getReturn_date());
        return ResponseEntity.ok(this.rentalsRepository.save(rental));
    }

    //delete rental
    @DeleteMapping("rentals/{id}")
    public Map<String, Boolean> deleteRental(@PathVariable(value = "id") Long rentalId) throws ResourceNotFoundException {
        Rentals rental = rentalsRepository.findById(rentalId).orElseThrow(()-> new ResourceNotFoundException("Rental not found for this id :: " + rentalId));
        this.rentalsRepository.delete(rental);

        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
