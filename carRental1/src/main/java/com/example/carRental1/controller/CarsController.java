package com.example.carRental1.controller;

import com.example.carRental1.exception.ResourceNotFoundException;
import com.example.carRental1.model.Cars;
import com.example.carRental1.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CarsController {
    @Autowired
    private CarsRepository carsRepository;

    //get Cars
    @GetMapping("cars")
    public List<Cars> getAllCars(){
        return this.carsRepository.findAll();
    }

    //get car by id
    @GetMapping("/cars/{id}")
    public ResponseEntity<Cars> getCarsById(@PathVariable(value = "id") Long carId)
            throws ResourceNotFoundException {
        Cars cars = carsRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + carId));
        return ResponseEntity.ok().body(cars);
    }

    //save car
    @PostMapping("cars")
    public Cars createCars(@RequestBody Cars cars) {
        return this.carsRepository.save(cars);

    }

    //update car
    @PutMapping("employees/{id}")
    public ResponseEntity<Cars> updateCars(@PathVariable(value = "id") Long carId,
                                                   @RequestBody Cars carDetails) throws ResourceNotFoundException {
        Cars cars = carsRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + carId));
        cars.setCarDescription(carDetails.getCarDescription());
        cars.setBrand(carDetails.getBrand());
        cars.setColor(carDetails.getColor());
        cars.setModel(carDetails.getModel());
        cars.setPurchase_Date(carDetails.getPurchase_Date());

        return ResponseEntity.ok(this.carsRepository.save(cars));

    }

    //delete car
    public Map<String, Boolean> deleteCars(@PathVariable(value = "id") Long carId)
            throws ResourceNotFoundException {
        {
            Cars cars = carsRepository.findById(carId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + carId));

            this.carsRepository.delete((cars));
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);

            return response;
        }
    }

}
