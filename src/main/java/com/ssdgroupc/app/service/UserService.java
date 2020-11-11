package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.User;
import com.ssdgroupc.app.repository.UserRepository;


@Service
public class UserService {

	/**
	 * Injects UserRepository
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Method to save a User.
	 */
	public User addUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * Method to get all Users
	 */
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	/**
	 * Method to get a User
	 */
	public Optional<User> getUser(long id) {
		return userRepository.findById(id);
	}

	/**
	 * Method to update a User
	 */
	public User updateUser(long id, User user) {
		return userRepository.save(user);
	}

	/**
	 * Method to delete a User
	 */
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

}
