package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
	Optional<User> findById(int id);

}
