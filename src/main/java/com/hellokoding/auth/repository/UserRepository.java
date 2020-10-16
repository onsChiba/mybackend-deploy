package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    public User findByEmail(String email);
	public User findByFirstname(String firstname);
	//public void deleteById(Long id);
	
}
