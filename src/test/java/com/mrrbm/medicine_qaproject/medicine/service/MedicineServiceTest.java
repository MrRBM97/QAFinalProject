package com.mrrbm.medicine_qaproject.medicine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.mrrbm.medicine_qaproject.medicine.domain.Medicine;
import com.mrrbm.medicine_qaproject.medicine.repo.MedicineRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MedicineServiceTest {

	@Autowired
	private MedicineService service;

	@MockBean
	private MedicineRepo repo;

	@Test
	public void testAddMedicine() {
		
		Medicine input = Medicine.builder()
				.commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();
		Medicine output = Medicine.builder()
				.id(1L)
				.commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();

		Mockito.when(this.repo.save(input)).thenReturn(output);

		assertEquals(output, this.service.addMedicine(input));

		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}

	@Test
	public void testGetAllMedicine() {

		List<Medicine> medicine = new ArrayList<>();
		medicine.add(Medicine.builder().commonName("Paracetamol").build());

		Mockito.when(this.repo.findAll()).thenReturn(medicine);

		assertEquals(medicine, this.service.getAllMedicine());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testUpdateMedicine() {
		
		Medicine existing = Medicine.builder()
				.id(1L).commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();
		Medicine update = Medicine.builder()
				.id(1L)
				.commonName("Paracetamol with Cocaine")
				.iupacName("N-(4-hydroxyphenyl)acetamide + methyl (1R,2R,3S,5S)-3- (benzoyloxy)-8-methyl-8-azabicyclo[3.2.1] octane-2-carboxylate")
				.chemicalFormula("C25H30NO6")
				.molecularWeight(403.4)
				.isApprovedByMhra(false)
				.isControlledDrug(true)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();

		Long id = 1L;

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(update)).thenReturn(update);

		assertEquals(update, this.service.updateMedicine(id, update));

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).save(update);
	}

	@Test
	public void testPosRemoveMedicine() {
		
		Mockito.when(this.repo.existsById(1L)).thenReturn(true, false);
		
		assertTrue(this.service.removeMedicine(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(2)).existsById(1L);
	}
	
	@Test
	public void testNegRemoveMedicine() {
		
		Mockito.when(this.repo.existsById(1L)).thenReturn(true,true);
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		
		assertFalse(this.service.removeMedicine(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}

}
