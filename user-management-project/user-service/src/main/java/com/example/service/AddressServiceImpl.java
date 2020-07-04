package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.entity.User;
import com.example.repository.AddressRepository;
import com.example.repository.UserRepository;


@Service
public class AddressServiceImpl implements AddressService {
	
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<Address> saveAddress(Long id, List<Address> addresses) {
		
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			return null;
		}
		
		for (Address address : addresses) {
			address.setUser(user.get());
		}
		
		return addressRepository.saveAll(addresses);
	}
	
	
	@Override
	public List<Address> findAddress(Long id) {
		
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			return null;
		}
		return addressRepository.findByUserId(id);
	}

}
