package com.evolvFit.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evolvFit.phonebook.model.Contact;
import com.evolvFit.phonebook.service.ContactService;

@RestController
public class PhoneBookController {
	
	
	@Autowired
	ContactService contactService;
	
	//this function will add a contact in our db
	@PostMapping("/addContact")
	public ResponseEntity<Object> addContact(Contact contact){
		contactService.addAContact(contact);
		
		return new ResponseEntity<>("Contact added succesfully", HttpStatus.OK);
		
	}
	
	//this function will return all the contacts
	@GetMapping("/getAllContacts")
	public List<Contact> getAllContacts(){
		return contactService.getAllContact();
	}
	
	//this function return contact of given id
	@GetMapping("/getContactById/{id}")
	public Contact getContactById(@PathVariable("id") int id) {
		return contactService.getContactById(id);
	}
	
	//this function delete a contact given id
	@DeleteMapping("deleteAContact/{id}")
	public void deleteAContact(@PathVariable("id") int id) {
		contactService.DeleteAContactById(id);
	}
	
	//this function update contact of given id
	@PutMapping("/updateAContact/{id}")
	public void updateAContact(@PathVariable("id") int id, Contact contact) {
		contactService.updateAContactById(id, contact);
	}
	
	
	//Level 2
	@GetMapping("/findContacts")
	public List<Contact> getContactsOfGivenName(@RequestParam("name") String name){
		
		return contactService.getContactsOfGivenName(name);
		
	}
	
	//pagination
	@GetMapping("/pageableList")
	public Page<Contact> pageableList(Pageable pageable){
		return contactService.getPageableList(pageable);
	}
	
	

}
