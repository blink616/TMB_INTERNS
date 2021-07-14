package com.example.hassan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@SpringBootApplication
@RestController
public class HassanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HassanApplication.class, args);
	}

	@GetMapping("/{id}")
	public String getMethod(@PathVariable String id){
		return id;
	}

	@PostMapping("/post")
	public String postMethod(@RequestParam("name") String name){
		return name;
	}

	@PutMapping("/put")
	public String putMethod(@RequestParam("name") String name) {
		return name;
	}

	@DeleteMapping("/{id}")
	public String deleteMethod(@PathVariable String id){
		return id;
	}
	@PatchMapping("/patch")
	public @ResponseBody ResponseEntity<String> patchMethod() {
		return new ResponseEntity<String>("PATCH Response", HttpStatus.OK);
	}
}
