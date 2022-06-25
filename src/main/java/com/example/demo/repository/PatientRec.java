package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PatientDetails;
@Repository
public interface PatientRec extends JpaRepository<PatientDetails, Long> {

	PatientDetails patientName(String name);

	void deleteById(long id);

	Optional<PatientDetails> findById(long id);

}
