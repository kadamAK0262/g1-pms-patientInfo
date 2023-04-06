package com.revature.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.BasicPatientInfo;

@Repository
public interface PatientRepository extends JpaRepository<BasicPatientInfo, Integer>{
	
}
