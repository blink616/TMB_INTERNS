package com.example.carRental1.controller;

import com.example.carRental1.exception.ResourceNotFoundException;
import com.example.carRental1.model.Rentals;
import com.example.carRental1.repository.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RentalsController {
    @Autowired
    private RentalsRepository rentalsRepository;

    //get rentals
    @GetMapping("rentals")
    public List<Rentals> getAllRentals(){
        return this.rentalsRepository.findAll();
    }
    //get rental by id
    @GetMapping("/rentals/{id}")
    public ResponseEntity<Rentals> getRentalsById(@PathVariable(value="id") Long rentalId)
            throws ResourceNotFoundException {
        Rentals rentals = rentalsRepository.findById(rentalId)
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found for this id::" + rentalId));
        return ResponseEntity.ok().body(rentals);
    }
    //save rentals
    @PostMapping("rentals")
    public Rentals createRentals(@RequestBody Rentals rentals) {
        return this.rentalsRepository.save(rentals);
    }
    //update rentals
    @PutMapping("rentals/{id}")
    public ResponseEntity<Rentals> updateRentals(@PathVariable(value = "id") Long rentalId,
                                                   @RequestBody Rentals rentalDetails) throws ResourceNotFoundException {
        Rentals rentals = rentalsRepository.findById(rentalId)
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found for this id::" + rentalId));
        rentals.setAmount(rentalDetails.getAmount());
        rentals.setPick_up_date(rentalDetails.getPick_up_date());
        rentals.setReturn_date(rentalDetails.getReturn_date());

        return ResponseEntity.ok(this.rentalsRepository.save(rentals));

    }
    //delete rentals
    public Map<String, Boolean> deleteRentals(@PathVariable(value = "id") Long rentalId)
            throws ResourceNotFoundException {
        {
            Rentals rentals = rentalsRepository.findById(rentalId)
                    .orElseThrow(() -> new ResourceNotFoundException("Rental not found for this id::" + rentalId));

            this.rentalsRepository.delete((rentals));
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);

            return response;
        }
    }

}
