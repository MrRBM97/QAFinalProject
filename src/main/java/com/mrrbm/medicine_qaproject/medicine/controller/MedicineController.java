package com.mrrbm.medicine_qaproject.medicine.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrrbm.medicine_qaproject.medicine.domain.Medicine;
import com.mrrbm.medicine_qaproject.medicine.service.MedicineService;

@RequestMapping("/medicine")
@RestController
public class MedicineController {

	@Autowired
	private MedicineService service;

	public MedicineController(MedicineService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) {
		
		Medicine result = this.service.addMedicine(medicine);
		
		return result != null ? new ResponseEntity<>(result, HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<Iterable<Medicine>> getAllPeople() {
		
		return new ResponseEntity<Iterable<Medicine>>(this.service.getAllMedicine(), HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine Medicine) {
		
		return new ResponseEntity<Medicine>(this.service.updateMedicine(id, Medicine), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Medicine> delete(@PathVariable Long id) {
		
		return this.service.removeMedicine(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
}
