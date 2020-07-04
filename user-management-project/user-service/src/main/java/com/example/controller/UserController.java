package com.example.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.entity.Address;
import com.example.entity.User;
import com.example.service.AddressService;
import com.example.service.UserService;



@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired 
	AddressService addressService;
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User createdUser = userService.createUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> retrieveUser(@PathVariable Long id) {
		
		User user = userService.retrieveUser(id);
		if(user == null) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<User>(user, HttpStatus.FOUND); 
	}
	
	
	@PostMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		
		User updatedUser = userService.updateUser(id, user);
		if(updatedUser == null) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updatedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		
		userService.deleteUser(id);
	}
	
	
    // http://localhost:8080/user/1/address  [{ "detail": "Ankara"},{ "detail": "Çankaya"}] 
	@PostMapping("/user/{id}/address")
	public ResponseEntity<List<Address>> addAddressToUser(@PathVariable Long id, @RequestBody List<Address> addresses) {
		
		List<Address> savedAddresses = addressService.saveAddress(id, addresses);
		
		return new ResponseEntity<List<Address>>(savedAddresses,HttpStatus.CREATED);
	}
	
	
    // http://localhost:8080/user/1/address 
	@GetMapping("/user/{id}/address")
	public ResponseEntity<List<Address>> findUserAddress(@PathVariable Long id) {
		
		List<Address> addresses = addressService.findAddress(id);
		if(addresses == null) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<List<Address>>(addresses, HttpStatus.FOUND);
	}

}
