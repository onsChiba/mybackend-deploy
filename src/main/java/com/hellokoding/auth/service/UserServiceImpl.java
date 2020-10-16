package com.hellokoding.auth.service;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.RoleRepository;
import com.hellokoding.auth.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
     //   user.setRoles(new HashSet<>(roleRepository.findAll()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	

	@Override
	public User updateAbonne(User ab) {
		return userRepository.save(ab);
	}

	@Override
	public void deleteUser(Long id) {
	userRepository.deleteById(id);		
	}

	@Override
	public List<User> getAllAbonne() {
		List<User> list=(List<User>) userRepository.findAll();
		return list;
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByFirstname(String firstname) {
		return userRepository.findByFirstname(firstname);
	}
}
