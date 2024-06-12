package com.migue.gestion_usuarios.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migue.gestion_usuarios.model.User;
import com.migue.gestion_usuarios.service.UserService;
import com.migue.gestion_usuarios.service.Imp.UserServiceImp;
import com.migue.gestion_usuarios.utils.MapperUtils;
import com.migue.gestion_usuarios.vo.UserVO;

@RestController
@RequestMapping("/security/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MapperUtils mpU;

	@GetMapping
	public List<UserVO> getAllUsers() throws JsonProcessingException {
		return mpU.map(userService.getAllUsers(), List.class);
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		return userService.updateUSer(user, id);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

}
