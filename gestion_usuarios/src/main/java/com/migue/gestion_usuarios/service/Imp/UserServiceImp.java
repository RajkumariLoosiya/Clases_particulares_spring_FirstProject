package com.migue.gestion_usuarios.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migue.gestion_usuarios.dto.UserDTO;
import com.migue.gestion_usuarios.model.User;
import com.migue.gestion_usuarios.repository.UserRepository;
import com.migue.gestion_usuarios.service.UserService;
import com.migue.gestion_usuarios.utils.MapperUtils;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MapperUtils mapperUtils; 
	
	@Autowired
	private ObjectMapper objM; 
	
	public List<Object> getAllUsers() throws JsonProcessingException{
		return mapperUtils.map(userRepository.findAll(), List.class); 
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUSer(User user,Long id) {
		
		User userExists = userRepository.findById(id).orElse(null);
		
		if(userExists != null) {
			userExists.setNombre(user.getNombre());
			userExists.setEmail(user.getEmail());
			return userRepository.save(userExists);
		}
		
		return null; 
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	

}
