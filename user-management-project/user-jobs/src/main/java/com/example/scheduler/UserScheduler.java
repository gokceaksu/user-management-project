package com.example.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.service.UserSchedulerService;


@Component
public class UserScheduler {
	
	
	@Autowired
	private UserSchedulerService userSchedulerService;
	
	Logger logger = LoggerFactory.getLogger(UserScheduler.class);
	
	
	@Scheduled(fixedRate = 300000) // 5dk
	public void scheduleTaskMarkOldUsers(){
		
		userSchedulerService.markOldUsers(5);
		
		logger.info("Schedule task executed.");
	}

}
