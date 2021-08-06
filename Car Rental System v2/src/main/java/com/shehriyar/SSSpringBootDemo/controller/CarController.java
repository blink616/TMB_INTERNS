package com.shehriyar.SSSpringBootDemo.controller;

import com.shehriyar.SSSpringBootDemo.database.DBConnection;
import com.shehriyar.SSSpringBootDemo.exception.ResourceNotFoundException;
import com.shehriyar.SSSpringBootDemo.model.Car;
import com.shehriyar.SSSpringBootDemo.model.Rental;
import com.shehriyar.SSSpringBootDemo.repository.CarRepository;
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
public class CarController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private RentalRepository rentalRepository;

    @GetMapping("cars")
	public List<Car> getAllCars() {
        Connection db_con = DBConnection.make_connection();

        return carRepository.findAll(db_con);
	}

	@GetMapping("cars/{id}")
	public ResponseEntity<Car> getCar(@PathVariable Long id) throws ResourceNotFoundException {
        Connection db_con = DBConnection.make_connection();

        Car car = carRepository.findById(db_con, id);
		return ResponseEntity.ok(car);
	}

	@PostMapping("cars")
    public Map<String, Boolean> createCar(@RequestBody Car car) {
        Connection db_con = DBConnection.make_connection();

        boolean isAdded = this.carRepository.save(db_con, null, car);

        Map<String, Boolean> response = new HashMap<>();
        response.put("added", isAdded);

        return response;
    }

    @PutMapping("cars/{id}")
    public Map<String, Boolean> updateCar(@PathVariable Long id, @RequestBody Car carDetails) throws ResourceNotFoundException {
        Connection db_con = DBConnection.make_connection();

        boolean isUpdated = this.carRepository.save(db_con, id, carDetails);

        Map<String, Boolean> response = new HashMap<>();
        response.put("updated", isUpdated);

        return response;
    }

    @DeleteMapping("cars/{id}")
    public Map<String, Boolean> deleteCar(@PathVariable Long id) throws ResourceNotFoundException {
        Connection db_con = DBConnection.make_connection();

        boolean isDeleted = this.carRepository.delete(db_con, id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", isDeleted);

        return response;
    }

    @GetMapping("cars/{id}/rentals")
    public List<Rental> getCarRentals(@PathVariable Long id) throws ResourceNotFoundException {
        Connection db_con = DBConnection.make_connection();

        return this.rentalRepository.findByCarId(db_con, id);
    }
}
