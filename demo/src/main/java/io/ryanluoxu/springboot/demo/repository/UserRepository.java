package io.ryanluoxu.springboot.demo.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import io.ryanluoxu.springboot.demo.model.User;

public interface UserRepository extends CrudRepository<User, String>{
	
	public ArrayList<User> findByNationality(String nationality);

}
