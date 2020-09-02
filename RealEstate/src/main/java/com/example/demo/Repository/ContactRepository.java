package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Contact;


public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
