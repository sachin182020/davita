package com.pms.vital.details.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.vital.details.exception.VitalDetailsException;
import com.pms.vital.details.model.VitalDetails;
import com.pms.vital.details.model.VitalDetailsSuccess;
import com.pms.vital.details.repository.VitalDetailsRepository;

@ExtendWith(MockitoExtension.class)
class VitalDetailsServiceImplTest {

	@InjectMocks
	private VitalDetailsServiceImpl vitalDetailsServiceImplTest;
	
	@Mock
	private VitalDetailsRepository vitalDetailsRepoMock;
	
	@Mock
	private VitalDetails vitalDetailsMock;
	
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
		
		when(vitalDetailsRepoMock.save(vitalDetailsTest)).thenReturn(vitalDetailsTest);
		
		VitalDetails vitalDetailsActual = vitalDetailsServiceImplTest.addVitalDetail(vitalDetailsTest);
		assertEquals(vitalDetailsTest,vitalDetailsActual);
		
	}
	
	@Test
	public void checkAddVisitId()
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
		vitalDetailsTest.setVisitId(null);
		Assertions.assertThrows(VitalDetailsException.class, () -> {
			vitalDetailsServiceImplTest.addVitalDetail(vitalDetailsTest);
		});
	}
	
	@Test
	public void checkAddPatientId()
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
		vitalDetailsTest.setVisitId("A0001");
		vitalDetailsTest.setPatientId(null);
		Assertions.assertThrows(VitalDetailsException.class, () -> {
			vitalDetailsServiceImplTest.addVitalDetail(vitalDetailsTest);
		});
	}
	
	@Test
	public void checkAddHeight()
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
		vitalDetailsTest.setVisitId("A0001");
		vitalDetailsTest.setHeight(-12);
		Assertions.assertThrows(VitalDetailsException.class, () -> {
			vitalDetailsServiceImplTest.addVitalDetail(vitalDetailsTest);
		});
	} 
	
	@Test
	public void checkAddWeight()
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
		vitalDetailsTest.setVisitId("A0001");
		vitalDetailsTest.setWeight(1234);;
		Assertions.assertThrows(VitalDetailsException.class, () -> {
			vitalDetailsServiceImplTest.addVitalDetail(vitalDetailsTest);
		});
	} 
	
	@Test
	public void checkAddSystolic()
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
		vitalDetailsTest.setVisitId("A0001");
		vitalDetailsTest.setSystolic(-89);;
		Assertions.assertThrows(VitalDetailsException.class, () -> {
			vitalDetailsServiceImplTest.addVitalDetail(vitalDetailsTest);
		});
	} 
	
	@Test
	public void checkAddDiastolic()
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
		vitalDetailsTest.setVisitId("A0001");
		vitalDetailsTest.setDiastolic(0);;
		Assertions.assertThrows(VitalDetailsException.class, () -> {
			vitalDetailsServiceImplTest.addVitalDetail(vitalDetailsTest);
		});
	} 
	
	@Test
	public void checkAddRespiratioRate()
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
	 	vitalDetailsTest.setVisitId("A0001");
		vitalDetailsTest.setRespirationRate(0);
		Assertions.assertThrows(VitalDetailsException.class, () -> {
			vitalDetailsServiceImplTest.addVitalDetail(vitalDetailsTest);
		});
	}  
	
	@Test
	public void checkAddBodyTemperature()
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
		vitalDetailsTest.setVisitId("A0001");
		vitalDetailsTest.setBodyTemperature(0);;
		Assertions.assertThrows(VitalDetailsException.class, () -> {
			vitalDetailsServiceImplTest.addVitalDetail(vitalDetailsTest);
		});
	} 
	
	@Test
	public void getVitalDetailsByIdTest() {
		
		//given
		String visitIdTest = "A0001";
//		Optional<VitalDetails> optionalvitalDetail = new Optional<>();
		VitalDetails vitalDetailsTest = new VitalDetails();
		vitalDetailsTest.setVisitId(visitIdTest);
		vitalDetailsTest.setPatientId("P0001");
		vitalDetailsTest.setHeight(160);
		vitalDetailsTest.setWeight(75);
		vitalDetailsTest.setSystolic(89);
		vitalDetailsTest.setDiastolic(120);
		vitalDetailsTest.setBodyTemperature(96);
		vitalDetailsTest.setRespirationRate(98);
		
		VitalDetailsSuccess vitalDetailsSuccessTest = new VitalDetailsSuccess();
		vitalDetailsSuccessTest.setSuccessflag(true);
		vitalDetailsSuccessTest.setVitalDetails(vitalDetailsTest);
		Optional<VitalDetails> optionalvitalDetail = Optional.ofNullable(vitalDetailsTest);
		//when
		when(vitalDetailsRepoMock.findById(visitIdTest)).thenReturn(optionalvitalDetail);
		
		//then
		VitalDetailsSuccess vitalDetailsActual = vitalDetailsServiceImplTest.getVitalDetailById(visitIdTest);
		assertEquals(vitalDetailsSuccessTest.getVitalDetails(), vitalDetailsActual.getVitalDetails());
	} 
	
	@Test
	public void getVitalDetailsById_basicException()
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
		Optional<VitalDetails> mockVitalDetails = Optional.empty();
		when(vitalDetailsRepoMock.findById(vitalDetailsTest.getVisitId())).thenReturn(mockVitalDetails);
		try {
			vitalDetailsServiceImplTest.getVitalDetailById(vitalDetailsTest.getVisitId());
		} catch (VitalDetailsException e) {
			assertNotNull(e);
		}
		
	} 
	
	@Test
	public void updateVitalDetailsTest() throws Exception
	{
		String visitIdTest = "A0001";
		VitalDetails vitalDetailsTest = new VitalDetails();
		vitalDetailsTest.setVisitId(visitIdTest);
		vitalDetailsTest.setPatientId("P0001");
		vitalDetailsTest.setHeight(160);
		vitalDetailsTest.setWeight(75);
		vitalDetailsTest.setSystolic(89);
		vitalDetailsTest.setDiastolic(120);
		vitalDetailsTest.setBodyTemperature(96);
		vitalDetailsTest.setRespirationRate(98);
		Optional<VitalDetails> optionalvitalDetail = Optional.ofNullable(vitalDetailsTest);
		when(vitalDetailsRepoMock.findById(visitIdTest)).thenReturn(optionalvitalDetail);
		when(vitalDetailsRepoMock.save(vitalDetailsTest)).thenReturn(vitalDetailsTest);
		
		VitalDetails vitalDetailsActual = vitalDetailsServiceImplTest.updatedVitalDetails(vitalDetailsTest);
		assertEquals(vitalDetailsTest, vitalDetailsActual);
	}  
	
	@Test
	public void checkVisitId() throws Exception
	{
		VitalDetails vitalDetailsTest = new VitalDetails();
		Optional<VitalDetails> mockVitalDetails = Optional.empty();
		when(vitalDetailsRepoMock.findById(vitalDetailsTest.getVisitId())).thenReturn(mockVitalDetails);
		try {
			vitalDetailsServiceImplTest.updatedVitalDetails(vitalDetailsTest);
		} catch (VitalDetailsException e) {
			assertNotNull(e);
		}	
	} 
	
	@Test
	public void getAllVitalDetails()
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
		
		List<VitalDetails> allVitalDetailsTest = new ArrayList<>();
		allVitalDetailsTest.add(vitalDetailsTest);
		
		//when
		when(vitalDetailsRepoMock.findAll()).thenReturn(allVitalDetailsTest);
		
		//then
		
		List<VitalDetails> allVitalDetailsActual = vitalDetailsServiceImplTest.getAllVitalDetails();
		assertEquals(allVitalDetailsTest, allVitalDetailsActual);
	}
	

}
