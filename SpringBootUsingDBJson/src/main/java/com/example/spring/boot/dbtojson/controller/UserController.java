package com.example.spring.boot.dbtojson.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.boot.dbtojson.data.UserDTO;
import com.example.spring.boot.dbtojson.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
   private UserService userService;
   
   public UserController() {};
   
   public UserController(UserService userService) {
	    super();
		this.userService = userService;
	}

   
@GetMapping("/list")
public Iterable<UserDTO> list(){
	return userService.list();
}
  

}
