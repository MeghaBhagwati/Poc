package com.example.demo;

import java.util.List;

import com.example.demo.model.User;



public interface IUserService {
	public  Integer saveUser(User u);
	//update method
	public void updateUser(User u,Integer userId);
	//delete method
	public void deleteUser(Integer id);
	//fatch employee
	public User getOneUser(Integer id);
	//particular emp fetch
	public List<User> fetchAllUser();
	

}
