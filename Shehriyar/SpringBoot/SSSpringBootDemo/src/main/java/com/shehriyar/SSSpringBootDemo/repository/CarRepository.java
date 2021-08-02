package com.shehriyar.SSSpringBootDemo.repository;

import com.shehriyar.SSSpringBootDemo.model.Car;
import com.shehriyar.SSSpringBootDemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
