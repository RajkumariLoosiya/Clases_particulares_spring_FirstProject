package com.migue.gestion_usuarios.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.migue.gestion_usuarios.dto.UserDTO;
import com.migue.gestion_usuarios.model.User;


public interface UserService {
	
	public List<Object> getAllUsers() throws JsonProcessingException;
	
	public User getUserById(Long id);
	
	public User createUser(User user);

	public User updateUSer(User user,Long id);
	
	public void deleteUser(Long id);
	
}
