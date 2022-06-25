package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.PatientDetails;
import com.example.demo.service.PatientInter;

@Controller
public class RecordControl {
	@Autowired
	private PatientInter imp;
	
	  @GetMapping("/")
	    public String viewHomePage(Model model) {
	        model.addAttribute("allPatientlist", imp.getAll());
	        return "starting";
	    }
	  
	  @GetMapping("/add")
	    public String addNewpatient(Model model) {
		  PatientDetails patient = new PatientDetails();
	        model.addAttribute("patient", patient);
	        return "newpatient";
	    }
	  
	  @PostMapping("/save")
	    public String savePatientDetails(@ModelAttribute("patient") PatientDetails patient) {
		  imp.Create(patient);
	        return "redirect:/";
	    }
	 
	    @GetMapping("/showFormUpdate/{id}")
	    public String updateForm(@PathVariable(value = "id") long id, Model model) {
	    	PatientDetails patient = imp.findPatientById(id);
	        model.addAttribute("patient", patient);
	        return "update";
	    }
	    
	    @GetMapping("/deletepatient/{id}")
	    public String deleteThroughId(@PathVariable(value = "id") long id) {
	    	imp.Deletepatient(id);
	        return "redirect:/";
	    }
	    } 

//=========RESTApi =================
//	@PostMapping(value = "/post")
//	public ResponseEntity<PatientDetails> Create(@RequestBody  PatientDetails patient) {
//		return new ResponseEntity<PatientDetails>(imp.Create(patient), HttpStatus.OK);
//	}
//
//	@GetMapping(value = "/getall")
//	public ResponseEntity<List<PatientDetails>> getAll() {
//		 ResponseEntity<List<PatientDetails>> responseEntity = new ResponseEntity<List<PatientDetails>>(imp.getAll(), HttpStatus.OK);
//		 
//		 return responseEntity;
//	}
//
//	@GetMapping(value = "/getbyid")
//	public ResponseEntity<PatientDetails> getPatientById(@RequestParam("patientid") int id) {
//		return new ResponseEntity<PatientDetails>(imp.getPatientById(id), HttpStatus.OK);
//	}
//
//	@GetMapping(value = "/getbyname/{name}")
//	public ResponseEntity<PatientDetails> getPatientName(@PathVariable String name) {
//		return new ResponseEntity<PatientDetails>(imp.name(name), HttpStatus.OK);
//	}
//
//	@PutMapping(value = "/put/{id}")
//	public ResponseEntity<PatientDetails> Update(@PathVariable int id, @RequestBody PatientDetails user) {
//		PatientDetails updatevar = imp.getPatientById(id);
//		updatevar.setPatientName(user.getPatientName());
//		updatevar.setPatientAddress(user.getPatientAddress());
//		updatevar.setPatientDisease(user.getPatientDisease());
//		updatevar.setPatientAge(user.getPatientAge());
//		PatientDetails createUser = imp.Update(updatevar);
//
//		return ResponseEntity.ok(createUser);
//
//	}
//
//	@DeleteMapping(value = "/delete/{id}")
//	public ResponseEntity<Integer> delete(@PathVariable int id) {
//		return new ResponseEntity<Integer>(imp.Deletepatient(id), HttpStatus.OK);
//
//	}




