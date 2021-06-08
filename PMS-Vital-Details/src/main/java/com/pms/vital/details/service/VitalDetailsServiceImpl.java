package com.pms.vital.details.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.vital.details.exception.VitalDetailsException;
import com.pms.vital.details.model.VitalDetails;
import com.pms.vital.details.model.VitalDetailsSuccess;
import com.pms.vital.details.repository.VitalDetailsRepository;

@Service
public class VitalDetailsServiceImpl implements VitalDetailsService  
{
	@Autowired
	private VitalDetailsRepository vitalDetailsRepository;

	@Override
	public VitalDetails addVitalDetail(VitalDetails vitalDetail) {
		
		if (Objects.isNull(vitalDetail.getVisitId())) { 
			throw new VitalDetailsException("Visit Id cannot be Null");
		} else if (Objects.isNull(vitalDetail.getPatientId())) {
			throw new VitalDetailsException(" Patient Id cannot be Null");
		} else if (Objects.isNull(vitalDetail.getHeight())) {
			throw new VitalDetailsException("Height cannot be Null ");
		}
		 else if (Objects.isNull(vitalDetail.getWeight())) {
				throw new VitalDetailsException("Weight cannot be Null ");
		}
		 else if (Objects.isNull(vitalDetail.getSystolic())) {
				throw new VitalDetailsException("Systolic cannot be Null ");
		}
		 else if (Objects.isNull(vitalDetail.getDiastolic())) {
				throw new VitalDetailsException("Diastolic cannot be Null ");
		}
		 else if (Objects.isNull(vitalDetail.getRespirationRate())) {
				throw new VitalDetailsException("Respiration Rate cannot be Null ");
		} 
		 else if (Objects.isNull(vitalDetail.getBodyTemperature())) {
				throw new VitalDetailsException("Body Temperature cannot be Null ");
		} 
		VitalDetails savedVitalDetail = vitalDetailsRepository.save(vitalDetail);
		return savedVitalDetail; 
	} 
	
/************************************************************************************************/
	@Override
	public VitalDetails updatedVitalDetails(VitalDetails vitalDetail) {
		Optional<VitalDetails> findById = vitalDetailsRepository.findById(vitalDetail.getVisitId()); 
		if(!findById.isPresent())
			throw new VitalDetailsException("Vital details for this VISIT ID is not present");
		VitalDetails updatedVitalDetails = vitalDetailsRepository.save(vitalDetail);
		return updatedVitalDetails;
	}  
	
/************************************************************************************************/
	
	@Override
	public VitalDetailsSuccess getVitalDetailById(String visitId) 
	{
		
		Optional<VitalDetails> optionalvitalDetail = vitalDetailsRepository.findById(visitId);
		if(!optionalvitalDetail.isPresent())
		{
			throw new VitalDetailsException("Vital details for this VISIT ID is not present");
		}
		VitalDetails vitalDetail = optionalvitalDetail.get();
		VitalDetailsSuccess vitalDetailsSuccess = new VitalDetailsSuccess();
		vitalDetailsSuccess.setSuccessflag(Boolean.TRUE);
		vitalDetailsSuccess.setVitalDetails(vitalDetail);  
		return vitalDetailsSuccess;
	}
	
/************************************************************************************************/
	@Override
	public List<VitalDetails> getAllVitalDetails() {
		
		List<VitalDetails> allVitalDetails = vitalDetailsRepository.findAll();
		return allVitalDetails;
	}

	
}
