package com.pms.vital.details.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.pms.vital.details.utilities.Auditable;


@Entity
public class VitalDetails extends Auditable<String> {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(nullable = false)
	private String visitId;

	@NotNull
	@Column(nullable = false)
	private String patientId;
	
	@Digits(integer=3, fraction=2)
	@NotNull(message = "Please fill the Height field")
	@Positive(message = "Please provide proper height")
	@Column(nullable = false)
	private int height; // in cm

	@Digits(integer=3, fraction=2)
	@NotNull(message = "Please fill the weight field")
	@Positive(message = "Please provide proper weight")
	@Column(nullable = false)						
	private int weight; // in kg
	
	@Digits(integer=3, fraction = 0)
	@NotNull(message = "Please fill the systolic field")
	@Positive(message = "Please provide proper systolic")
	@Column(nullable = false)
	private int systolic; // mm hg
	
	@Digits(integer=3, fraction = 0)
	@NotNull(message = "Please fill the diastolic field")
	@Positive(message = "Please provide proper diastolic")
	@Column(nullable = false)
	private int diastolic; // mm hg
	
	@Digits(integer=3, fraction = 0)
	@NotNull(message = "Please fill the bodyTemprature field")
	@Positive(message = "Please provide proper bodyTemperature")
	@Column(nullable = false)
	private int bodyTemperature; // in Fahrenheit
	
	@Digits(integer=2, fraction = 0)
	@NotNull(message = "Please fill the respirationRate field")
	@Positive(message = "Please provide proper respirationRate")
	@Column(nullable = false)
	private int respirationRate; // per minute

	

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public int getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(int bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public int getRespirationRate() {
		return respirationRate;
	}

	public void setRespirationRate(int respirationRate) {
		this.respirationRate = respirationRate;
	}


	public VitalDetails() {
		
	}
	
	
}
