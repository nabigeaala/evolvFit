package com.evolvFit.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.evolvFit.phonebook.model.Contact;
import com.evolvFit.phonebook.repository.ContactRepo;

@Service
public class ContactServiceImp implements ContactService {
    
	@Autowired
	ContactRepo contactRepo;
	
	
	@Override
	public void addAContact(Contact contact) {
		contactRepo.save(contact);

	}

	@Override
	public List<Contact> getAllContact() {
		
		return contactRepo.findAll();
	}

	@Override
	public Contact getContactById(int id) {
		
		return contactRepo.getById(id);
	}

	@Override
	public void DeleteAContactById(int id) {
		
		contactRepo.deleteById(id);

	}

	@Override
	public void updateAContactById(int id, Contact contact) {
		Contact newContact= contactRepo.getById(id);
		newContact.setContactNumber(contact.getContactNumber());
		newContact.setName(contact.getName());
		
		contactRepo.save(newContact);

	}

	@Override
	public List<Contact> getContactsOfGivenName(String name) {
		
		return contactRepo.findByName(name);
	}

	@Override
	public Page<Contact> getPageableList(Pageable pageable) {
		return contactRepo.findAll(pageable);
	}

}
