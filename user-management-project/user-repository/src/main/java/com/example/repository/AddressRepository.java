package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
	
	
	@Query("SELECT a FROM Address a WHERE a.user.id = ?1")
	List<Address> findByUserId(Long userId);

}
