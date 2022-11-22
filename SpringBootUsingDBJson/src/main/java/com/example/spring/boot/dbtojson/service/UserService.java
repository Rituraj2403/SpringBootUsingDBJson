package com.example.spring.boot.dbtojson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.boot.dbtojson.data.UserDTO;
import com.example.spring.boot.dbtojson.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserService(){};
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public List<UserDTO> list(){
		return userRepository.findAll();
	}
	
	public UserDTO save(UserDTO userDTO) throws Exception, JsonProcessingException {
		return userRepository.save(userDTO);
	}

	
	public List<UserDTO> saveAll(List<UserDTO> userDTOList) throws Exception, JsonProcessingException{
		return userRepository.saveAll(userDTOList);
	}
}
