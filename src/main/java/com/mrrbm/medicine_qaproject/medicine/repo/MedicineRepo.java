package com.mrrbm.medicine_qaproject.medicine.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrrbm.medicine_qaproject.medicine.domain.Medicine;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Long> {
}
