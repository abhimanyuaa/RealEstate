package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SearchProperty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int searchId;
	String propertyName;
	String propetyType;
	String propertyLocation;
	String PropertyCity;
	public SearchProperty() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchProperty(int searchId, String propertyName, String propetyType, String propertyLocation,
			String propertyCity) {
		super();
		this.searchId = searchId;
		this.propertyName = propertyName;
		this.propetyType = propetyType;
		this.propertyLocation = propertyLocation;
		PropertyCity = propertyCity;
	}
	public int getSearchId() {
		return searchId;
	}
	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropetyType() {
		return propetyType;
	}
	public void setPropetyType(String propetyType) {
		this.propetyType = propetyType;
	}
	public String getPropertyLocation() {
		return propertyLocation;
	}
	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}
	public String getPropertyCity() {
		return PropertyCity;
	}
	public void setPropertyCity(String propertyCity) {
		PropertyCity = propertyCity;
	}
	@Override
	public String toString() {
		return "SearchProperty [searchId=" + searchId + ", propertyName=" + propertyName + ", propetyType="
				+ propetyType + ", propertyLocation=" + propertyLocation + ", PropertyCity=" + PropertyCity + "]";
	}
	
	
	
	
}
