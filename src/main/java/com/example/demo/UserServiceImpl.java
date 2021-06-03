package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.IUserRepo;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo repo;
	@Override
	public Integer saveUser(User u) {
		// TODO Auto-generated method stub
		Integer id=repo.save(u).getUserId();
		return id;
	}

	@Override
	public void updateUser(User u,Integer userId) {
		// TODO Auto-generated method stub
		repo.save(u);

	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
    repo.deleteById(id);
	}

	@Override
	public User getOneUser(Integer id) {
		// TODO Auto-generated method stub
		Optional<User> opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
		}
		
	@Override
	public List<User> fetchAllUser() {
		// TODO Auto-generated method stub
		
		return repo.findAll();
	}

	

}
