package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Contact;

import com.example.demo.Repository.ContactRepository;

@Service
@Transactional
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	public Page<Contact> findAllContact(Pageable pageable) {
		return contactRepository.findAll(pageable);
		}
}
