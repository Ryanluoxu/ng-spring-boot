package io.ryanluoxu.springboot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.springboot.demo.model.User;
import io.ryanluoxu.springboot.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public ArrayList<User> getUserList(){
		return (ArrayList<User>) userRepository.findAll();
	}

	public User getUserByName(String name) {
		return userRepository.findOne(name);
	}

	public boolean addUser(User user) {
		// name shouldn't be existed.
		if (userRepository.findOne(user.getUserName()) == null) {
			userRepository.save(user);
			return true;
		} else {
			System.err.println(user.getUserName() + " is existed..");
			return false;
		}
	}

	public boolean updateUserByName(User updatedUser, String name) {
		// name must be the same
		if (updatedUser.getUserName().equals(name)) {
			User u = userRepository.save(updatedUser);
			if (u != null) {
				return true;
			} else {
				System.err.println("Fail to update - " + updatedUser.getUserName());
				return false;
			}
		} else {
			System.err.println("Unable to change the userName for existed user - "  + name);
			return false;
		}
	}

	public boolean removeUserByName(String name) {
		try {
			userRepository.delete(name);
			return true;
		} catch (Exception e) {
			System.err.println("Fail to remove user called " + name);	
			return false;
		}
	}

	public ArrayList<User> getUserbyNationality(String nationality) {
		return userRepository.findByNationality(nationality);
	}
	
}
