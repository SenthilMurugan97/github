package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PatientDetails;
import com.example.demo.repository.PatientRec;

@Service
public class PatientImpl implements PatientInter {

	@Autowired
	private PatientRec record;

	@Override
	public void Create(PatientDetails patient) {
		 record.save(patient);
	}

	@Override
	public List<PatientDetails> getAll() {
		return record.findAll();
	}
	@Override
	public void Deletepatient(long id) {
		record.deleteById(id);
		
	}

	@Override
	public PatientDetails findPatientById(long id) {
	
		PatientDetails detail=null;
		Optional<PatientDetails> findById = record.findById(id);
		if(findById.isPresent()) {
			detail=findById.get();
		}
		
		return detail;
	}

}

//	@Override
//	public PatientDetails getPatientById(long id) {
//		PatientDetails var=null;
//		Optional<PatientDetails> findById = record.findById(id);
//		if(findById.isPresent()) {
//			var=findById.get();
//		}
//		
//		return var;
//	}

//	@Override
//	public PatientDetails name(String name) {
//		 PatientDetails findbypatientname = record.patientName(name);
//		
//		return findbypatientname;
//	}

//	@Override
//	public PatientDetails Update(PatientDetails updatevar) {
//		return record.save(updatevar);
//	}


