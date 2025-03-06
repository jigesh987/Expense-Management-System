package com.expense.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.Entity.Expense;
import com.expense.Entity.User;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long>{
	List<Expense> findByUser(User user);
	List<Expense> findByUserId(Long userId);
}
