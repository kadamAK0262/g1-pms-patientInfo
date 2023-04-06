package com.revature.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Repository.PatientRepository;
import com.revature.model.BasicPatientInfo;
import com.revature.pms.dto.BasicPatientInfoDto;

@Service
public class PatientInfoService {
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	public List<BasicPatientInfo> getPatientInfo(){
		List<BasicPatientInfo> dtoList = patientRepo.findAll().stream()
			    .map(entity -> modelMapper.map(entity, BasicPatientInfo.class))
			    .collect(Collectors.toList());
	return dtoList;
}

	public BasicPatientInfo getPatientById(int id){
		return modelMapper.map(patientRepo.findById(id).get(),BasicPatientInfo.class);
	}
	
	public BasicPatientInfo updateById(BasicPatientInfo basicpatientinfo, int id) {
		
		BasicPatientInfo basicInfo = patientRepo.findById(id).orElse(null);
		basicInfo.setEmail(basicpatientinfo.getEmail());
		basicInfo.setGender(basicpatientinfo.getGender());
		basicInfo.setFirstName(basicpatientinfo.getFirstName());
		basicInfo.setLastName(basicpatientinfo.getLastName());
		return modelMapper.map(patientRepo.saveAndFlush(basicInfo),BasicPatientInfo.class);	
	}
	
}
