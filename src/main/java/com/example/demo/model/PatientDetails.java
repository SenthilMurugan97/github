package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	private String patientName;
	private String patientAddress;
	private String patientDisease;
	private int patientAge;

}
