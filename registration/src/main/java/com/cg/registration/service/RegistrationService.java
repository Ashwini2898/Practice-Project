package com.cg.registration.service;

import java.util.List;

import com.cg.registration.entity.RegisterForm;
import com.cg.registration.exception.RegistrationException;

public interface RegistrationService {

	public Integer newregistration(RegisterForm register)throws RegistrationException;
	
	public RegisterForm getRegistrationbyId(Integer id)throws RegistrationException;
	
	public Integer deleteRegisterationbyId(Integer id)throws RegistrationException;
	
	public List<RegisterForm> getAllRegisteration()throws RegistrationException;
	
	public RegisterForm updateregistration(RegisterForm register)throws RegistrationException;
}
