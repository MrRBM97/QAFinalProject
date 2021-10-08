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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrrbm.medicine_qaproject.medicine.domain.Medicine;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void testGetAll() throws Exception {
		
		Medicine expected = Medicine.builder()
				.id(1L)
				.commonName("Ibuprofen")
				.iupacName("(RS)-2-(4-(2-methylpropyl)phenyl)propanoic acid")
				.chemicalFormula("C13H18O2")
				.molecularWeight(206.29)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25.2f).build();

		List<Medicine> meds = new ArrayList<>();
		meds.add(expected);

		String expectedAsJsonString = this.mapper.writeValueAsString(meds);

		mvc.perform(get("/medicine/getAll"))
				.andExpect(status().isAccepted())
				.andExpect(content().json(expectedAsJsonString));
	}
	
	@Test
	public void testCreate() throws Exception{
		Medicine entry = Medicine.builder()
				.commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();
		Medicine result = Medicine.builder()
				.id(2L)
				.commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();

		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		

		mvc.perform(post("/medicine/create")
				.contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void testUpdate() throws Exception {
		Medicine update = Medicine.builder()
				.id(1L).commonName("Paracetamol")
				.iupacName("N-(4-hydroxyphenyl)acetamide")
				.chemicalFormula("C8H9NO2")
				.molecularWeight(150.16)
				.isApprovedByMhra(true)
				.isControlledDrug(false)
				.minStoreTemp(null)
				.maxStoreTemp(25f).build();
		
		String updateAsJSON = this.mapper.writeValueAsString(update);

		mvc.perform(put("/medicine/update/1")
				.contentType(MediaType.APPLICATION_JSON).content(updateAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(updateAsJSON));
	}
	
	@Test
	public void testDelete() throws Exception {
	
		mvc.perform(delete("/medicine/delete/1"))
				.andExpect(status().isNoContent());
	}
}
