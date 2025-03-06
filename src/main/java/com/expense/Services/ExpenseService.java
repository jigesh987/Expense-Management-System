package com.expense.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.Entity.Expense;
import com.expense.Entity.User;
import com.expense.Repository.ExpenseRepo;
import com.expense.Repository.UserRepo;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepo expenseRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public void addExpense(Expense expense ,String username) {
		User user=userRepo.findByUsername(username);
		expense.setUser(user);
		expenseRepo.save(expense);
	}
	public List<Expense> getUserExpense(String username){
		User user=userRepo.findByUsername(username);
		return expenseRepo.findByUser(user);
	}
	public List<Expense> getUserExpenses(Long userId) {
	    return expenseRepo.findByUserId(userId);
	}
	public void deleteExpenseById(Long id) {
	    expenseRepo.deleteById(id);
	}
}
