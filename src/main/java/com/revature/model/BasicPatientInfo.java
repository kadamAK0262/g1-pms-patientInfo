package com.revature.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PATIENT")
public class BasicPatientInfo {
	@Column(name  = "patient_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	
	@Column(name="email",nullable=false,unique=true)
	@Email(message="email is not valid")
	private String email;
	
	@Column(name="title")
	private String title;
	
	@Column(name="first_name")
	@NotBlank(message="first name is required")
	private String firstName;
	
	@NotBlank(message="last name is required")
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank(message = "Please provide a date.")
	private String dob;
	
	
	@Column(name="contact_number")
	@Pattern(regexp="^\\d{10}$" , message="invalid mobile number")
	private String contactNumber;
	
	@Column(name="password")
	private String password;
	
	@Column(name="gender")
	private String gender;

	@Column(name="address")
	@NotBlank(message="Address shouldn't be null")
	private String address;

}
