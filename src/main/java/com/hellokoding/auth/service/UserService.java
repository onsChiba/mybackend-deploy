package com.hellokoding.auth.service;

import java.util.List;

import com.hellokoding.auth.model.User;

public interface UserService {
   public User save(User user);

    User findByUsername(String username);
    public User updateAbonne(User ab);
	public  void deleteUser(Long id);
	public List<User> getAllAbonne();
	 public User findByEmail(String email);
	 public User findByFirstname( String firstname);
}
