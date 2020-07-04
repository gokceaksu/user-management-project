package com.example.service;

import java.util.List;

import com.example.entity.Address;


public interface AddressService {
	
	
	List<Address> saveAddress(Long id, List<Address> addresses);
	List<Address> findAddress(Long id);

}
