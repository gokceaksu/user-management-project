package com.example.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.UserRepository;

@Service
@Transactional
public class UserSchedulerServiceImpl implements UserSchedulerService {
	
	
	@Autowired
	UserRepository userRepository;
	
	
	public void markOldUsers(int minute){
		
		Date createdDate = Date.from(Instant.now().minus(Duration.ofMinutes(minute)));
		
		userRepository.updateUsersByCreatedDate(createdDate);
	}

}
