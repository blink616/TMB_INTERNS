package com.shehriyar.SSSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SsSpringBootDemoApplication {

	HashMap<String, User> users = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(SsSpringBootDemoApplication.class, args);
	}

	@GetMapping("/get_users")
	public HashMap<String, User> getUsers() {
		return users;
	}

	@PostMapping("/create_user")
	public String createUser(@RequestParam String name) {
		String id = "" + (users.size() + 1);
		users.put(id, new User(id, name));
		return "New user has been created!";
	}

	@DeleteMapping("/delete_user/{id}")
	public String deleteUser(@PathVariable String id) {
		if (users.containsKey(id)) {
			users.remove(id);
			return "User has been deleted!";
		}

		return "User does not exist!";
	}

	@PutMapping("/replace_user/{id}")
	public String replaceUser(@PathVariable String id, @RequestParam String name) {
		if (users.containsKey(id)) {
			users.replace(id, new User(id, name));
			return "User has been replaced!";
		}

		return "User does not exist!";
	}

	@PatchMapping("/update_user/{id}")
	public String updateUser(@PathVariable String id, @RequestParam String name) {
		if (users.containsKey(id)) {
			User user = users.get(id);
			users.get(id).setName(name);
			users.put(id, user);
			return "User has been updated!";
		}

		return "User does not exist!";
	}

}
