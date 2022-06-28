package com.cg.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.cg.registration.entity.RegisterForm;
import com.cg.registration.service.RegistrationService;
import com.cg.registration.exception.RegistrationException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/registration")
@Slf4j
public class RegistrationController {

	@Autowired (required=false)
	private RegistrationService register;
	@ApiOperation(value = "Get registration by Id",
			response = RegisterForm.class,tags="get-registration-by-id",consumes="id",httpMethod = "GET")
	
	@GetMapping("/{id}")
	public ResponseEntity<RegisterForm> getRegistrationbyId(@PathVariable Integer id){
		try {
			RegisterForm registerForm= register.getRegistrationbyId(id);
			log.info("Registration added"+ register);
			return new ResponseEntity<>(registerForm,HttpStatus.OK); 
		}catch(RegistrationException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			
			}
	}
	
	@ApiOperation(value = "Get all registration",
			response = RegisterForm.class,tags="get-all-registration",httpMethod = "GET")
	@GetMapping("/")
	
	public ResponseEntity <List<RegisterForm>> getAllRegistration(){
		try {
			List<RegisterForm>registerFormList= register.getAllRegisteration();
			log.info("All Registration details");
			return new ResponseEntity<>(registerFormList,HttpStatus.OK); 
		}catch(RegistrationException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			
			}
	}
	
	
	@ApiOperation(value = "New Registration",
	consumes = "receives new-registration object as request body",
	response =String.class)
	@PostMapping("/")
	public String newregistration(@Validated @RequestBody RegisterForm registerForm){
		try {
			Integer status=register.newregistration(registerForm);
			if(status==1) {
			log.info("New Registration added" + registerForm.getFirst_name() );
			return "New Registration added" + registerForm.getFirst_name();
			}
			else {
				log.debug("Unable to add new registration");
				return "Unable to add new registration to database";
			}
		}catch(RegistrationException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			
			}
	}
	
	@ApiOperation(value = "Delete registration by Id",
			response = String.class,tags="delete-registration-by-id",consumes="id",httpMethod = "DELETE")
	
	@DeleteMapping("/{id}")
	public String deleteRegistrationbyId(@PathVariable Integer id){
		try {
			Integer status= register.deleteRegisterationbyId(id);
			if(status==1) {
			log.info("Registration: "+id+" deleted from database");
			return "Registration: "+id+ " deleted from database"; 
			}
			else {
				log.debug("Unable to delete Registration from database");
				return "Unable to delete  Registration from database";
				}
			}catch(RegistrationException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			
			}
	}
	
	@ApiOperation(value = "Update registration",
			response = RegisterForm.class,tags="update-registration",consumes="receives Registration object as request body")
	
	@PutMapping("/")
	public ResponseEntity<RegisterForm>updateRegistrationbyId(@RequestBody RegisterForm registerForm){
		try {
			RegisterForm updatedregisterForm= register.updateregistration(registerForm);
			log.info("Registration "+registerForm.getId()+" is updated");
			return new ResponseEntity<>(updatedregisterForm,HttpStatus.OK); 
		}catch(RegistrationException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			
			}
	}
}

