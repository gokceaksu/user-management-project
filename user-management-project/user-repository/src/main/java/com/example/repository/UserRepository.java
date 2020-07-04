package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	
	@Query(value = "SELECT * FROM User u WHERE u.old_user = 0 and u.created_date < :createdDate", nativeQuery = true)
	List<User> listUserByCreatedDate(@Param("createdDate") Date createdDate);
	
	
	@Modifying
	@Query(value = "UPDATE User u SET u.old_user = 1 WHERE u.old_user = 0 and u.created_Date <= :createdDate",  nativeQuery = true)
	void updateUsersByCreatedDate(@Param("createdDate") Date createdDate);

	
}
