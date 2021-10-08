package com.mrrbm.medicine_qaproject.medicine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mrrbm.medicine_qaproject.medicine.domain.Medicine;
import com.mrrbm.medicine_qaproject.medicine.repo.MedicineRepo;

@Service
public class MedicineService {

	private MedicineRepo repo;

	public MedicineService(MedicineRepo repo) {
		
		super();
		this.repo = repo;
	}

	public Medicine addMedicine(Medicine medicine) {
		
		return this.repo.save(medicine);
	}

	public List<Medicine> getAllMedicine() {
		
		return this.repo.findAll();
	}

	public Medicine updateMedicine(Long id, Medicine newMedicine) {
		
		Medicine existingMedicine = this.repo.findById(id).get();

		existingMedicine.setCommonName(newMedicine.getCommonName());
		existingMedicine.setIupacName(newMedicine.getIupacName());
		existingMedicine.setChemicalFormula(newMedicine.getChemicalFormula());
		existingMedicine.setMolecularWeight(newMedicine.getMolecularWeight());
		existingMedicine.setIsApprovedByMhra(newMedicine.getIsApprovedByMhra());
		existingMedicine.setIsControlledDrug(newMedicine.getIsControlledDrug());
		existingMedicine.setMinStoreTemp(newMedicine.getMinStoreTemp());
		existingMedicine.setMaxStoreTemp(newMedicine.getMaxStoreTemp());

		return this.repo.save(existingMedicine);
	}

	public boolean removeMedicine(Long id) {
		
		if (this.repo.existsById(id)) {
			this.repo.deleteById(id);
			return !this.repo.existsById(id);
		} else {
			return false;
		}
	}
}
