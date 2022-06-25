package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.PatientDetails;

public interface PatientInter {

	void Create(PatientDetails patient);

	List<PatientDetails> getAll();

	void Deletepatient(long id);

	PatientDetails findPatientById(long id);

}

// PatientDetails getPatientById(long id);

// PatientDetails name(String name);

// PatientDetails Update(PatientDetails updatevar);
