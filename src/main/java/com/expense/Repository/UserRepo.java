package com.expense.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
