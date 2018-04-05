/**
 * 
 */
package com.turkmen.scheduler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.turkmen.scheduler.domain.Person;

/**
 * @author TTTDEMIRCI
 *
 */

public interface PersonRepository extends CrudRepository<Person, Long> {
	
	//test
 List<Person> findByLastName(String surname);
	
}
