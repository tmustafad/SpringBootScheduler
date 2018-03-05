/**
 * 
 */
package com.turkmen.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.turkmen.scheduler.domain.Person;
import com.turkmen.scheduler.repository.PersonRepository;

/**
 * @author TTTDEMIRCI
 *
 */
@Component
public class ScheduledTasks {
	
	private static final Logger logger=LoggerFactory.getLogger(ScheduledTasks.class);
	private static final DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Autowired
	PersonRepository personRepository;
	
	
	@Scheduled(fixedRate=3000)
	public void scheduleWithFixedRate() {
		logger.info("Starting Scheduler.............................");
		Person person=new Person("Türkmen Mustafa", "Demirci");
		personRepository.save(person);
		
		logger.info("FindByLastName : "+personRepository.findByLastName("Demirci").get(0));
		logger.info("Fixed Rate Scheduler finished : "+dateTimeFormatter.format(LocalDateTime.now()));
		
	}

}
