package com.pms.vital.details.model;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VitalDetailsSuccess {

	private String message;
	private boolean successflag;
	private VitalDetails vitalDetails;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccessflag() {
		return successflag;
	}
	public void setSuccessflag(boolean successflag) {
		this.successflag = successflag;
	}
	public VitalDetails getVitalDetails() {
		return vitalDetails;
	}
	public void setVitalDetails(VitalDetails vitalDetails) {
		this.vitalDetails = vitalDetails;
	}
	
}
