package com.cg.registration.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.registration.entity.RegisterForm;
@Repository
public interface FormDao extends JpaRepository<RegisterForm,Integer>{

}
