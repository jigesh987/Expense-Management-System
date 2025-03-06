package com.expense.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.expense.Entity.Expense;
import com.expense.Entity.User;
import com.expense.Services.ExpenseService;
import com.expense.Services.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return "redirect:/login";  // Redirect if not logged in
        }
        model.addAttribute("username", username);
        return "profile";
    }
	
	@GetMapping("/addExpense")
	public String addExpense() {
		return "addExpense";
	}
	@PostMapping("/saveExpense")
	public String saveExpense(@RequestParam String category,@RequestParam double amount,@RequestParam String date,HttpSession session) {
		//TODO: process POST request
		String username = (String) session.getAttribute("loggedInUser");
        Long userId = (Long) session.getAttribute("loggedInUserId");
        if (username == null&&userId==null) {
            return "redirect:/login";  // Redirect if not logged in
        }
		Expense expense=new Expense();
		expense.setAmount(amount);
		expense.setCategory(category);
		expense.setDate(LocalDate.parse(date));
		
		User user=userService.findByUserId(userId);
		expense.setUser(user);
		expenseService.addExpense(expense, username);
		return "redirect:/viewExpense";
	}
	
	@GetMapping("/viewExpense")
	public String viewExpenses(Model model, HttpSession session) {
        String username = (String) session.getAttribute("loggedInUser");
        Long userId = (Long) session.getAttribute("loggedInUserId");
        if (username == null&&userId==null) {
            return "redirect:/login";  // Redirect if not logged in
        }

        List<Expense> expenses = expenseService.getUserExpense(username);
        model.addAttribute("expenses", expenses);
        return "viewExpense";
	}
	
	@GetMapping("/deleteExpense")
	public String deleteExpense(@RequestParam Long id) {
	    expenseService.deleteExpenseById(id);
	    return "redirect:/viewExpense";
	}
	
	
}
