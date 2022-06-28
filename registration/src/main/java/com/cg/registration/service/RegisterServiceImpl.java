package com.cg.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.registration.dao.FormDao;
import com.cg.registration.entity.RegisterForm;
import com.cg.registration.exception.RegistrationException;


@Service
@Transactional
public class RegisterServiceImpl implements RegistrationService {

	@Autowired 
	private FormDao FormDaoImpl;

	@Override
	public Integer newregistration(RegisterForm register) throws RegistrationException {
		// TODO Auto-generated method stub
		try{
			FormDaoImpl.save(register);
			return 1;
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new RegistrationException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception)
		{
			throw new RegistrationException(exception.getMessage(),exception);
		}
	}

	@Override
	public RegisterForm getRegistrationbyId(Integer id) throws RegistrationException {
		// TODO Auto-generated method stub
		try
		{
			Optional<RegisterForm> optional=FormDaoImpl.findById(id);
			if(optional.isPresent())
			{
				return optional.get();
			}
			else
			{
				return null;
			}
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new RegistrationException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception)
		{
			throw new RegistrationException(exception.getMessage(),exception);
		}
		
	}

	@Override
	public Integer deleteRegisterationbyId(Integer id) throws RegistrationException {
		// TODO Auto-generated method stub
		try {
			FormDaoImpl.deleteById(id);
			return id;
		}
		catch(DataAccessException dataAccessException) 
		{
			throw new RegistrationException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception)
		{
			throw new RegistrationException(exception.getMessage(),exception);
		}
		
	}

	@Override
	public List<RegisterForm> getAllRegisteration() throws RegistrationException {
		// TODO Auto-generated method stub
		try {
			List<RegisterForm>registerList=FormDaoImpl.findAll();
			return registerList;
		}
		
		catch(DataAccessException dataAccessException) 
		{
			throw new RegistrationException(dataAccessException.getMessage(),dataAccessException);
		}
		catch(Exception exception)
		{
			throw new RegistrationException(exception.getMessage(),exception);
		}
	}

	@Override
	public RegisterForm updateregistration(RegisterForm register) throws RegistrationException {
		// TODO Auto-generated method stub
		
			try {
				RegisterForm updateregister=FormDaoImpl.save(register);
				return updateregister;
			}
			catch(DataAccessException dataAccessException) 
			{
				throw new RegistrationException(dataAccessException.getMessage(),dataAccessException);
			}
			catch(Exception exception)
			{
				throw new RegistrationException(exception.getMessage(),exception);
			}
	}
	
	
}
