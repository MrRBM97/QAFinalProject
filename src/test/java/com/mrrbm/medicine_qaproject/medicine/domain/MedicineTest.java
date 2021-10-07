package com.mrrbm.medicine_qaproject.medicine.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.meanbean.test.BeanTester;
import org.meanbean.test.HashCodeMethodTester;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MedicineTest {

	Medicine medicine;

	@BeforeEach
	public void setUp() {
		
		this.medicine = Medicine.builder()
				.id(1L).commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();
	}

	@Test
	public void TestMedicine() {
		
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(Medicine.class);
	}

	@Test
	public void HashCodeTest() {
		
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.testHashCodeMethod(Medicine.class);
	}

	@Test
	void EqualsTest() {
		
		Medicine first = Medicine.builder()
				.commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();

		assertEquals(true, first.equals(first));
	}
}
