package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserServiceImpl;
import com.example.demo.model.User;


@RestController
@RequestMapping("/rest/user")
public class UserRestController {
	@Autowired
	private UserServiceImpl usi;
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		ResponseEntity<String> resp=null; 
		try {
			Integer id=usi.saveUser(user);
			resp=new ResponseEntity<String>("user saved with"+id,HttpStatus.CREATED);
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>("unable to save",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	//display all
	@GetMapping("/all")
	public ResponseEntity<?> allUser(){
		ResponseEntity<?> resp=null;
		try {
			List<User> list=usi.fetchAllUser();
			resp=new ResponseEntity<List<User>>(list,HttpStatus.OK);
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>("unable to fetch data",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return   resp;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getOneUser(@PathVariable Integer id){
		User user=usi.getOneUser(id);
		ResponseEntity<?> resp=null;
		try {
			
			resp=new ResponseEntity<User>(user,HttpStatus.OK);
		}
		
		catch(Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>("not found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeById(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		try {
			usi.deleteUser(id);
			resp=new ResponseEntity<String>("user deleted",HttpStatus.OK);
		}
		
			
			
		catch(Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(" user not deleted",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	@PutMapping("/put/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody User u,@PathVariable Integer userId){
		ResponseEntity<String> resp=null;
		try {
			
		
		usi.updateUser(u, userId);
		resp=new ResponseEntity<String>("updated succefully",HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			resp=new ResponseEntity<String>("unable to update",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return resp;
	}
	
	
	
}
