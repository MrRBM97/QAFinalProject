package com.mrrbm.medicine_qaproject.medicine.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrrbm.medicine_qaproject.medicine.domain.Medicine;
import com.mrrbm.medicine_qaproject.medicine.service.MedicineService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MedicineUnitControllerTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	ObjectMapper mapper;

	@MockBean
	MedicineService service;

	@Test
	public void testGetAll() throws Exception {
		
		Medicine input = Medicine.builder()
				.commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();

		List<Medicine> meds = new ArrayList<>();
		meds.add(input);

		String inputAsJsonString = this.mapper.writeValueAsString(meds);

		Mockito.when(service.getAllMedicine()).thenReturn(meds);

		mvc.perform(get("/medicine/getAll"))
				.andExpect(status().isAccepted())
				.andExpect(content().json(inputAsJsonString));
	}

	@Test
	public void testPassCreate() throws Exception {
		
		Medicine entry = Medicine.builder()
				.commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();

		String entryAsJSON = this.mapper.writeValueAsString(entry);

		Mockito.when(service.addMedicine(entry)).thenReturn(entry);

		mvc.perform(post("/medicine/create")
				.contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(entryAsJSON));
	}

	@Test
	public void testFailCreate() throws Exception {
		mvc.perform(post("/medicine/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"Fake Entry\":\"Not real\"}"))
				.andExpect(status().isNotImplemented());
	}

	@Test
	public void testUpdate() throws Exception {
		Medicine update = Medicine.builder()
				.commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();
		
		String updateAsJSON = this.mapper.writeValueAsString(update);

		Mockito.when(service.updateMedicine(1L,update)).thenReturn(update);

		mvc.perform(put("/medicine/update/1")
				.contentType(MediaType.APPLICATION_JSON).content(updateAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(updateAsJSON));
	}
	
	@Test
	public void testPassDelete() throws Exception {
	
		Mockito.when(service.removeMedicine(1L)).thenReturn(true);

		mvc.perform(delete("/medicine/delete/1"))
				.andExpect(status().isNoContent());
	}
	
	@Test
	public void testFailDelete() throws Exception {
	
		Mockito.when(service.removeMedicine(1L)).thenReturn(false);

		mvc.perform(delete("/medicine/delete/1"))
				.andExpect(status().isExpectationFailed());
	}
}
