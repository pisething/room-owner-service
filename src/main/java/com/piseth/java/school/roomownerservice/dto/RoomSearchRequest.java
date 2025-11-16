package com.piseth.java.school.roomownerservice.dto;

import lombok.Data;

@Data
public class RoomSearchRequest {
	private String name;
	private String ownerId;
	private String status;
	private String roomType;
	private String propertyType;
	private Double priceMin;
	private Double priceMax;
	private String provinceCode;
	private String districtCode;
	private String communeCode;
	private String villageCode;
}
