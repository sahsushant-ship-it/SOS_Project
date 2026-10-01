package com.sos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NearestHospitalResponse {
	
	private Integer hospitalId;
	
	private String hospitalName;
	
	private String hospitalPhone;
	
	private Integer availableBed;
	
	private Boolean emergencyAvailable;
	
	private Double distanceKm;
	
	private Double lalitude;
	
	private Double longitude;
	
	private String address;

}
