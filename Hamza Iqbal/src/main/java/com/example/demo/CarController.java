package com.example.demo;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@SpringBootApplication
@RestController
public class CarController {


	public static void main(String[] args) {
		SpringApplication.run(CarController.class, args);
	}

	@GetMapping("/{id}")
	public String getMethod(@PathVariable String id){
		return id;
	}

	@PostMapping("/post")
	public String postMethod(@RequestParam("carName") String carName){
		return carName;
	}

	@PutMapping("/put")
	public String putMethod(@RequestParam("carName") String carName){
		return carName;
	}

	@PatchMapping("/patch")
	public @ResponseBody ResponseEntity<String> pathMethod(){
		return new ResponseEntity<String>("Patch Response", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public String deleteMethod(@PathVariable String id){
		return id;
	}


}


