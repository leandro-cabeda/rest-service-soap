package com.restsoap.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restsoap.cliente.UserCliente;
import com.restsoap.model.User;
import com.restsoap.wsdl.GetUsersResponse;
import com.restsoap.wsdl.Users;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserCliente cliente;

	@GetMapping
	public ResponseEntity<?> getAllUser() {

		List<User> userrs = new ArrayList<User>();

		List<Users> users = cliente.getAllUsers().getUser();
		
		users.stream()
		.forEach(use-> userrs.add(
			new User(use.getId(), use.getName(), use.getEmail(), use.getPhone()) )
		 );

		return ResponseEntity.ok(userrs);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") int id) {

		User use = new User();

		try {

			Users user = cliente.getUser(id).getUser();
			use.setId(user.getId());
			use.setNome(user.getName());
			use.setEmail(user.getEmail());
			use.setTelefone(user.getPhone());

		} catch (Exception e) {

			return ResponseEntity.badRequest().body("Inválido o usuário com o Id: "+id);

		}

		return ResponseEntity.ok(use);

	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {

		User use = new User();

		try {

			Users user = cliente.getUser(id).getUser();
			use.setId(user.getId());
			use.setNome(user.getName());
			use.setEmail(user.getEmail());
			use.setTelefone(user.getPhone());
			cliente.deleteUsers(use.getId());

		} catch (Exception e) {

			return ResponseEntity.badRequest().body("Inválido ao deletar usuário com o Id: "+id);

		}

		return ResponseEntity.ok("Usuario deletado:  "+use);

	}

}
