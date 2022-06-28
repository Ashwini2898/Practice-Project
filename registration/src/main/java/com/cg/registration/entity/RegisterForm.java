package com.cg.registration.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="registration_details")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class RegisterForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="registration_Id")
	private Integer id;

	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mob_no")
	private String mob_no;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="DOB")
	private LocalDate dob;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pin")
	private String pin;
	
	@Column(name="state")
	private String state;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="specialization")
	private String specialization;

	@Override
	public String toString() {
		return "RegisterForm [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", mob_no=" + mob_no + ", gender=" + gender + ", dob=" + dob + ", address=" + address + ", city="
				+ city + ", pin=" + pin + ", state=" + state + ", qualification=" + qualification + ", specialization="
				+ specialization + "]";
	}
	
	
}
