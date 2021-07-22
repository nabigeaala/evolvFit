package com.evolvFit.phonebook.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.evolvFit.phonebook.model.Contact;

public interface ContactService {
   

	void addAContact(Contact contact);
	List<Contact> getAllContact();
	Contact getContactById(int id);
	void DeleteAContactById(int id);
	void updateAContactById(int id, Contact contact);
	
	//Level 2
	List<Contact> getContactsOfGivenName(String name);
	Page<Contact> getPageableList(Pageable pageable);
	
	
	
}
