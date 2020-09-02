package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;




@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int propertyId;
	int userId;
	String propertyName;
	String propertyUrl;
	String propertyLocation;
	String propertyCity;
	String  propertyPrice;
	String propertyType;
	String propertyImage1;String propertyImage2;String propertyImage3;String propertyImage4;
	String propertyImage5;String propertyImage6;String propertyImage7;String propertyImage8;
	String propertyImage9;String propertyImage10;
	String propertySize;
	String propertyTotalHall;
	String propertyBedroomes;
	String propertyDescription;
	String propertyRgistrationDate;
	String searchUrl;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="PropertyAndPropertyAmenities", joinColumns={@JoinColumn(name="property_ID", referencedColumnName="propertyId")}
    , inverseJoinColumns={@JoinColumn(name="amenity_Id", referencedColumnName="amenityId")})
	List<PropertyAmenities>amenitiesList = new ArrayList<PropertyAmenities>();
	
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Search Url Const
	public Property(int propertyId, String propertyName, String propertyLocation, String propertyCity,
			String propertyPrice, String propertyType, String propertyImage1, String propertyImage2,
			String propertySize, String propertyDescription) {
		super();
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.propertyLocation = propertyLocation;
		this.propertyCity = propertyCity;
		this.propertyPrice = propertyPrice;
		this.propertyType = propertyType;
		this.propertyImage1 = propertyImage1;
		this.propertyImage2 = propertyImage2;
		this.propertySize = propertySize;
		this.propertyDescription = propertyDescription;
	}
	
	  //Default parameterized

	public int getPropertyId() {
		return propertyId;
	}

	public Property(int propertyId, int userId, String propertyName, String propertyUrl, String propertyLocation,
			String propertyCity, String propertyPrice, String propertyType, String propertyImage1,
			String propertyImage2, String propertyImage3, String propertyImage4, String propertyImage5,
			String propertyImage6, String propertyImage7, String propertyImage8, String propertyImage9,
			String propertyImage10, String propertySize, String propertyTotalHall, String propertyBedroomes,
			String propertyDescription, String propertyRgistrationDate, String searchUrl,
			List<PropertyAmenities> amenitiesList) {
		super();
		this.propertyId = propertyId;
		this.userId = userId;
		this.propertyName = propertyName;
		this.propertyUrl = propertyUrl;
		this.propertyLocation = propertyLocation;
		this.propertyCity = propertyCity;
		this.propertyPrice = propertyPrice;
		this.propertyType = propertyType;
		this.propertyImage1 = propertyImage1;
		this.propertyImage2 = propertyImage2;
		this.propertyImage3 = propertyImage3;
		this.propertyImage4 = propertyImage4;
		this.propertyImage5 = propertyImage5;
		this.propertyImage6 = propertyImage6;
		this.propertyImage7 = propertyImage7;
		this.propertyImage8 = propertyImage8;
		this.propertyImage9 = propertyImage9;
		this.propertyImage10 = propertyImage10;
		this.propertySize = propertySize;
		this.propertyTotalHall = propertyTotalHall;
		this.propertyBedroomes = propertyBedroomes;
		this.propertyDescription = propertyDescription;
		this.propertyRgistrationDate = propertyRgistrationDate;
		this.searchUrl = searchUrl;
		this.amenitiesList = amenitiesList;
	}


	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyUrl() {
		return propertyUrl;
	}

	public void setPropertyUrl(String propertyUrl) {
		this.propertyUrl = propertyUrl;
	}

	public String getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	public String getPropertyCity() {
		return propertyCity;
	}

	public void setPropertyCity(String propertyCity) {
		this.propertyCity = propertyCity;
	}

	public String getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(String propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyImage1() {
		return propertyImage1;
	}

	public void setPropertyImage1(String propertyImage1) {
		this.propertyImage1 = propertyImage1;
	}

	public String getPropertyImage2() {
		return propertyImage2;
	}

	public void setPropertyImage2(String propertyImage2) {
		this.propertyImage2 = propertyImage2;
	}

	public String getPropertyImage3() {
		return propertyImage3;
	}

	public void setPropertyImage3(String propertyImage3) {
		this.propertyImage3 = propertyImage3;
	}

	public String getPropertyImage4() {
		return propertyImage4;
	}

	public void setPropertyImage4(String propertyImage4) {
		this.propertyImage4 = propertyImage4;
	}

	public String getPropertyImage5() {
		return propertyImage5;
	}

	public void setPropertyImage5(String propertyImage5) {
		this.propertyImage5 = propertyImage5;
	}

	public String getPropertyImage6() {
		return propertyImage6;
	}

	public void setPropertyImage6(String propertyImage6) {
		this.propertyImage6 = propertyImage6;
	}

	public String getPropertyImage7() {
		return propertyImage7;
	}

	public void setPropertyImage7(String propertyImage7) {
		this.propertyImage7 = propertyImage7;
	}

	public String getPropertyImage8() {
		return propertyImage8;
	}

	public void setPropertyImage8(String propertyImage8) {
		this.propertyImage8 = propertyImage8;
	}

	public String getPropertyImage9() {
		return propertyImage9;
	}

	public void setPropertyImage9(String propertyImage9) {
		this.propertyImage9 = propertyImage9;
	}

	public String getPropertyImage10() {
		return propertyImage10;
	}

	public void setPropertyImage10(String propertyImage10) {
		this.propertyImage10 = propertyImage10;
	}

	public String getPropertySize() {
		return propertySize;
	}

	public void setPropertySize(String propertySize) {
		this.propertySize = propertySize;
	}

	public String getPropertyTotalHall() {
		return propertyTotalHall;
	}

	public void setPropertyTotalHall(String propertyTotalHall) {
		this.propertyTotalHall = propertyTotalHall;
	}

	public String getPropertyBedroomes() {
		return propertyBedroomes;
	}

	public void setPropertyBedroomes(String propertyBedroomes) {
		this.propertyBedroomes = propertyBedroomes;
	}

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	public String getPropertyRgistrationDate() {
		return propertyRgistrationDate;
	}

	public void setPropertyRgistrationDate(String propertyRgistrationDate) {
		this.propertyRgistrationDate = propertyRgistrationDate;
	}

	public String getSearchUrl() {
		return searchUrl;
	}

	public void setSearchUrl(String searchUrl) {
		this.searchUrl = searchUrl;
	}

	public List<PropertyAmenities> getAmenitiesList() {
		return amenitiesList;
	}

	public void setAmenitiesList(List<PropertyAmenities> amenitiesList) {
		this.amenitiesList = amenitiesList;
	}


	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", userId=" + userId + ", propertyName=" + propertyName
				+ ", propertyUrl=" + propertyUrl + ", propertyLocation=" + propertyLocation + ", propertyCity="
				+ propertyCity + ", propertyPrice=" + propertyPrice + ", propertyType=" + propertyType
				+ ", propertyImage1=" + propertyImage1 + ", propertyImage2=" + propertyImage2 + ", propertyImage3="
				+ propertyImage3 + ", propertyImage4=" + propertyImage4 + ", propertyImage5=" + propertyImage5
				+ ", propertyImage6=" + propertyImage6 + ", propertyImage7=" + propertyImage7 + ", propertyImage8="
				+ propertyImage8 + ", propertyImage9=" + propertyImage9 + ", propertyImage10=" + propertyImage10
				+ ", propertySize=" + propertySize + ", propertyTotalHall=" + propertyTotalHall + ", propertyBedroomes="
				+ propertyBedroomes + ", propertyDescription=" + propertyDescription + ", propertyRgistrationDate="
				+ propertyRgistrationDate + ", searchUrl=" + searchUrl + ", amenitiesList=" + amenitiesList + "]";
	}


	

}
