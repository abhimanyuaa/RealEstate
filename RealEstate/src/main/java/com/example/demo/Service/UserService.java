package com.example.demo.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
		
	
	public void saveNewUser(User user)
	{
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String encodedpwd=encoder.encode(user.getPassword());
		Date date= new Date();
		DateFormat format= new SimpleDateFormat("yyyy/MM/dd");	
		String todaysDate= format.format(date);
		User u= new User(user.getStatus(), user.getUsername(), encodedpwd, user.getAddress(), user.getMobile(), user.getFirstName(), user.getLastName(),
			user.getRoles(), todaysDate);
		userRepository.save(u);
	}
	
	
	//Display All User in Admin Panel
	public Page<User> findAll(Pageable pageable) {
	return userRepository.findAll(pageable);
	}
	
	//Update status of user from admin panel
	public void updateUserById(User user) {
		
		Optional<User> u = userRepository.findById(user.getId());
			
			if (u.isPresent()) {
				User editusr = u.get();
				editusr.setStatus(user.getStatus());
				editusr = userRepository.save(editusr);
				
			} else {
				
			
			}

		}

		public User getUserByUsername(String username) {
		User u=userRepository.findByUsername(username);
		
		return u;
		
	}
	
}
