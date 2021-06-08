package com.pms.vital.details.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.vital.details.model.VitalDetails;
import com.pms.vital.details.model.VitalDetailsSuccess;
import com.pms.vital.details.repository.VitalDetailsRepository;
import com.pms.vital.details.service.VitalDetailsService;



@RestController
@RequestMapping("/healthcare/vitalDetails")
public class VitalDetailsController {
	
	@Autowired
	private VitalDetailsService vitalDetailsService;
	
	@Autowired
	VitalDetailsRepository vitalDetailsRepository;
	
	@Autowired
	VitalDetailsSuccess vitalDetailsSuccess;
	
	@PostMapping("/addVitalDetails")
	public ResponseEntity<VitalDetails> addVitalDetails(@Valid @RequestBody VitalDetails vitalDetails)
	{
		VitalDetails addVitalDetails = vitalDetailsService.addVitalDetail(vitalDetails);
		return new ResponseEntity<VitalDetails>(addVitalDetails,HttpStatus.CREATED); 
		
	}
	
	@PutMapping("/updateVitalDetails")
	public ResponseEntity<VitalDetails> updatedVitalDetails(@Valid @RequestBody VitalDetails vitalDetail ) {

		VitalDetails updateVitalDetails = vitalDetailsService.updatedVitalDetails(vitalDetail);
		return new ResponseEntity<VitalDetails>(updateVitalDetails, HttpStatus.OK); 
	}
	
	@GetMapping("/getVitalDetailById/{visitId}")
	public ResponseEntity<VitalDetailsSuccess> getVitalDetailById( @PathVariable("visitId") String visitId) {

			VitalDetailsSuccess vitalDetailSucess = vitalDetailsService.getVitalDetailById(visitId);
			return new ResponseEntity<VitalDetailsSuccess>(vitalDetailSucess, HttpStatus.OK);
	
	}
	
	@GetMapping("/getAllVitalDetails")
	public  ResponseEntity<List<VitalDetails>> getAllVitalDetails()
	{

			List<VitalDetails> allVitalDetailsList = vitalDetailsService.getAllVitalDetails();
			return new ResponseEntity<List<VitalDetails>>(allVitalDetailsList, HttpStatus.OK);
	}

}
