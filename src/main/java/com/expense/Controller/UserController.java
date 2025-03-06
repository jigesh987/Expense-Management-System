package com.expense.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.expense.Entity.User;
import com.expense.Services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestParam String username,@RequestParam String password,Model model) {
		//TODO: process POST request
		if(userService.findByUsername(username)!=null) {
			model.addAttribute("error", "User already register");
			return "register";
		}
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.saveUser(user);
		return "redirect:/login";
	}
	
	
	
	
	
	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, 
	                    @RequestParam String password, 
	                    HttpSession session, 
	                    Model model) {
	    User user = userService.findByUsername(username);
	    
	    if (user != null && user.getPassword().equals(password)) {
	        session.setAttribute("loggedInUser", username);  // Store in session
	        session.setAttribute("loggedInUserId", user.getId()); // Store user ID
	        return "redirect:/home";
	    } else {
	        model.addAttribute("error", "Invalid Credentials");
	        return "login";
	    }
	}

	@GetMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/login";
	}
	
}
