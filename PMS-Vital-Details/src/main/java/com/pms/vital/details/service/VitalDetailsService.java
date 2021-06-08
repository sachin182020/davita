package com.pms.vital.details.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pms.vital.details.model.VitalDetails;
import com.pms.vital.details.model.VitalDetailsSuccess;

@Service
public interface VitalDetailsService {
	
	VitalDetails addVitalDetail(VitalDetails vitalDetail);
	List<VitalDetails> getAllVitalDetails();
	VitalDetailsSuccess getVitalDetailById(String visitId);
	VitalDetails updatedVitalDetails(VitalDetails vitalDetail);
	
}
