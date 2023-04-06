package com.revature.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Service.PatientInfoService;
import com.revature.model.BasicPatientInfo;
import com.revature.pms.dto.BasicPatientInfoDto;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins	 =  "http://localhost:4200")
@Log4j2
public class PatientController {
	@Autowired
	private PatientInfoService patientInfoService; 
	

	
	@GetMapping("/patients")
	public ResponseEntity<?> getall(){
		List<BasicPatientInfo> bpi=null;
		try {
		bpi=patientInfoService.getPatientInfo();
		}
		catch (NullPointerException e){
			return new ResponseEntity<>(bpi,HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(NoSuchElementException e){
			return new ResponseEntity<>(bpi,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BasicPatientInfo>>(bpi,HttpStatus.OK);
	}
	@GetMapping("/patient/{id}")
	public ResponseEntity<BasicPatientInfo> getpatient(@PathVariable int id) {
		
		BasicPatientInfo bpi=null;
		try
		{
			bpi=patientInfoService.getPatientById(id);
		}
		catch(NullPointerException e)
		{
			return new ResponseEntity<>(bpi,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<BasicPatientInfo>(bpi,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BasicPatientInfo>(bpi,HttpStatus.OK);
	}
	
	@PutMapping("/patient/{id}")
	public ResponseEntity<BasicPatientInfo> updatePatient(@RequestBody @Valid BasicPatientInfo basic,@PathVariable int id) {	
		
		return ResponseEntity.ok(patientInfoService.updateById(basic, id));
	}
}
