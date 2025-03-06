package com.expense.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.Entity.User;
import com.expense.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public boolean validUser(String username,String password) {
		User user=userRepo.findByUsername(username);
		return user!=null&&user.getPassword().equals(password);
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	public User findByUserId(Long userId) {
		// TODO Auto-generated method stub
		
		
		return userRepo.findById(userId).orElse(null);
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
		
	}
	
}
