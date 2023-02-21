package com.example.spring.boot.dbtojson;

import java.io.File;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.spring.boot.dbtojson.data.UserDTO;
import com.example.spring.boot.dbtojson.service.UserService;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringBootDbJsonApplication {
	
	//Code read from/write to json file and write to/read from H2 Database
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDbJsonApplication.class, args);
	}

	
	@Bean
	CommandLineRunner runner(UserService userService) throws JsonProcessingException {
		return args -> { // statement of lamdba method
			ObjectMapper mapper = new ObjectMapper();
			
			// Code to read from Json file and write to H2 Database
			//http://localhost:8080/h2/login.do?jsessionid=ea78c6400bd3d7996c7e4dc1938810d5
			
			try {
				
				TypeReference<List<UserDTO>>  userList = new TypeReference<List<UserDTO>>() {
				};
				List<UserDTO>	usersR = mapper.readValue(new File("json/UserReader.json"), userList); // Read from JSon File and Write to List
                //TypeReference is class that can return the type we define for it spl. collections
				userService.saveAll(usersR); // Read from List and Write to H2 Database
				System.out.println("Saved Users");
				

			} catch (Exception e) {
				System.out.println("Unable to Save : " + e.getMessage());
			}

			try {
				// Code to read from H2 Database and write to JSON File
				//http://localhost:8080/users/list
				
				List<UserDTO> usersW = userService.list();
                //dao methods list() read from Database and Write to List
				
				JsonGenerator gen = mapper.createGenerator(new File("json/UserWriter.json"), JsonEncoding.UTF8);
                //JsonGenerator object create empty json file using objectmapper's createGenerator using two params file extension, character types capacity)
				
				gen.writeObject(usersW);
                // Write List to Json File
				
				gen.close();
                // Generator Object close is called so can use for single file also as not needed to re-use on multiple files.

			}
			

			// Note: we can add first gen.writeStartObject(); then
			// gen.writeFieldName("User"); before gen.writeObject(users); and after it
			// gen.writeEndObject();
			
			catch (Exception e) {
				System.out.println("The Exception in DB to Json is " + e);
			}

		};
	}

}
