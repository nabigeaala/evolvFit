package com.evolvFit.phonebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evolvFit.phonebook.model.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {
    
	//function for return all the contacts of given name
    List<Contact> findByName(String name);
}
