package io.ryanluoxu.springboot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.ryanluoxu.springboot.demo.model.User;
import io.ryanluoxu.springboot.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;	// get one time instance
	
	@RequestMapping("/users")			// default method = SET
	public ArrayList<User> getUserList(){
		ArrayList<User> userList = userService.getUserList();
		return userList;
	}
	
	@RequestMapping("/users/{name}")
	public User getUserByName(@PathVariable String name) {	// link {name} to name; {name1} X
		User user = userService.getUserByName(name);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public boolean addUser(@RequestBody User user) {	// transfer RequestBody to User instance
		boolean isSuccess = userService.addUser(user);
		return isSuccess;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{name}")
	public boolean updateUserByName(@RequestBody User user, @PathVariable String name) {	
		boolean isSuccess = userService.updateUserByName(user, name);
		return isSuccess;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{name}")
	public boolean removeUserByName(@PathVariable String name) {	
		boolean isSuccess = userService.removeUserByName(name);
		return isSuccess;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users/nationality/{nationality}")
	public ArrayList<User> getUserbyNationality(@PathVariable String nationality){
		return userService.getUserbyNationality(nationality);
	}
	
}
