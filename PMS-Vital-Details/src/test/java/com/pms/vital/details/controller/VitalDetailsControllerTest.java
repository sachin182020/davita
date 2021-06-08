package com.pms.vital.details.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.vital.details.model.VitalDetails;
import com.pms.vital.details.model.VitalDetailsSuccess;
import com.pms.vital.details.service.VitalDetailsService;


@ExtendWith(MockitoExtension.class)
public class VitalDetailsControllerTest {

	@InjectMocks
	private VitalDetailsController vitalDetailsController;
	
	@Mock
	private VitalDetailsService vitalDetailsService;
	
	@Mock
	private VitalDetails vitalDetails;
	
	@Mock
	private VitalDetailsSuccess vitalDetailsSuccess;
	
	
	@Test
	public void addVitalDetailsTest()
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
		vitalDetailsTest.setVisitId("A0001");
		vitalDetailsTest.setPatientId("P0001");
		vitalDetailsTest.setHeight(160);
		vitalDetailsTest.setWeight(75);
		vitalDetailsTest.setSystolic(89);
		vitalDetailsTest.setDiastolic(120);
		vitalDetailsTest.setBodyTemperature(96);
		vitalDetailsTest.setRespirationRate(98);
		
		when(vitalDetailsService.addVitalDetail(vitalDetails)).thenReturn(vitalDetailsTest);
		VitalDetails vitalDetailsActual = vitalDetailsController.addVitalDetails(vitalDetails).getBody();
		assertEquals(vitalDetailsTest,vitalDetailsActual);
		
	} 
	
	@Test
	public void updateVitalDetailsTest()
	{
		VitalDetails updatedvitalDetailsTest = new VitalDetails();
		updatedvitalDetailsTest.setVisitId("A0001");
		updatedvitalDetailsTest.setPatientId("P0001");
		updatedvitalDetailsTest.setHeight(160);
		updatedvitalDetailsTest.setWeight(75);
		updatedvitalDetailsTest.setSystolic(89);
		updatedvitalDetailsTest.setDiastolic(120);
		updatedvitalDetailsTest.setBodyTemperature(96);
		updatedvitalDetailsTest.setRespirationRate(98);
		
		when(vitalDetailsService.updatedVitalDetails(vitalDetails)).thenReturn(updatedvitalDetailsTest);
		
		VitalDetails updatedVitalDetailsActual = vitalDetailsController.updatedVitalDetails(vitalDetails).getBody();
		
		assertEquals(updatedvitalDetailsTest, updatedVitalDetailsActual);
	} 
	
	@Test
	public void getVitalDetailByIdTest()
	{
		String visitIdTest = "A101";
		
		VitalDetailsSuccess vitalDetailTest = new VitalDetailsSuccess();
		
		when(vitalDetailsService.getVitalDetailById(visitIdTest)).thenReturn(vitalDetailTest);
		
		VitalDetailsSuccess vitalDetailActual = vitalDetailsController.getVitalDetailById(visitIdTest).getBody();
		
		assertEquals(vitalDetailTest,vitalDetailActual);
	}
	
	@Test
	public void getAllVitalDetailsTest()
	{
		VitalDetails vitalDetailsTest = new VitalDetails(); 
		vitalDetailsTest.setVisitId("A0001");
		vitalDetailsTest.setPatientId("P0001");
		List<VitalDetails> vitalList = new ArrayList<>();
		vitalList.add(vitalDetailsTest);
		when(vitalDetailsService.getAllVitalDetails()).thenReturn(vitalList);
		List<VitalDetails> vitalListActual = vitalDetailsController.getAllVitalDetails().getBody();
		assertEquals(vitalList,vitalListActual);
	}
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
