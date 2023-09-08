package com.magic.project.controller;

import com.magic.project.models.Password;
import com.magic.project.models.User;
import com.magic.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("management/user")
public class UserController {
	@Autowired
	UserService userServ;

	// update a user password by ID and Patch request
	@PatchMapping("/update/password/{username}")
	public ResponseEntity<User> updateUserPassword(@Valid @PathVariable String username,
			@Valid @RequestBody Password updatedPassword) {
		User user = userServ.updateUserPassword(updatedPassword, username);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	// get list of all user
	@GetMapping("/list")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = userServ.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	// get list of all user
		@GetMapping("/role/{username}")
		public ResponseEntity<String> getUserRoleByUserName(@PathVariable @Valid String username) {
		String userRole = userServ.getUserRole(username);
		return ResponseEntity.status(HttpStatus.OK).body(userRole);
		}
		
	//authentication
	@GetMapping("/authenticate")
	public ResponseEntity<String> authenticate() {
		return ResponseEntity.status(HttpStatus.OK).build();
		}

}
