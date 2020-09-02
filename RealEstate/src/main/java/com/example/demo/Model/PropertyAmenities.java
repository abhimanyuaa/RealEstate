package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class PropertyAmenities {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	int amenityId;
	String amenityName;
	public PropertyAmenities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PropertyAmenities(int amenityId, String amenityName) {
		super();
		this.amenityId = amenityId;
		this.amenityName = amenityName;
	}
	public int getAmenityId() {
		return amenityId;
	}
	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}
	public String getAmenityName() {
		return amenityName;
	}
	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}
	@Override
	public String toString() {
		return "PropertyAmenities [amenityId=" + amenityId + ", amenityName=" + amenityName + "]";
	}

	

	
	
	
}
