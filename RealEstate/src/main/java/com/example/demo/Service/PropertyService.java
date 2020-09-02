package com.example.demo.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Property;
import com.example.demo.Model.SearchProperty;
import com.example.demo.Repository.PropertyRepository;

@Service
@Transactional
public class PropertyService {

	@Autowired
	PropertyRepository propertyRepository;
	
	

	public void saveProperty(Property property) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String todaysDate = format.format(date);
		property.setPropertyRgistrationDate(todaysDate);
		property.setPropertyUrl(property.getPropertyName().replace(" ", "-"));
		String search = property.getPropertyName().replaceAll("\\s", "")
				+ property.getPropertyCity().replaceAll("\\s", "")
				+ property.getPropertyLocation().replaceAll("\\s", "")
				+ property.getPropertyType().replaceAll("\\s", "");
		property.setSearchUrl(search.toLowerCase());
		Property p = propertyRepository.save(property);
		String id = Integer.toString(p.getPropertyId());
		property.setPropertyUrl(property.getPropertyName().replace(" ", "-") + id);

		propertyRepository.save(property);
	}

	public void saveEditedPropety(Property property) {
		Optional<Property> prop = propertyRepository.getByPropertyId(property.getPropertyId());
		System.out.println("In Service"+property.getPropertyImage4());
		if (prop.isPresent()) {
			Property editprd = prop.get();
			
			String search = property.getPropertyName().replaceAll("\\s", "")
					+ property.getPropertyCity().replaceAll("\\s", "")
					+ property.getPropertyLocation().replaceAll("\\s", "")
					+ property.getPropertyType().replaceAll("\\s", "");
		
			editprd.setAmenitiesList(property.getAmenitiesList());
			editprd.setPropertyBedroomes(property.getPropertyBedroomes());
			editprd.setPropertyCity(property.getPropertyCity());
			editprd.setPropertyDescription(property.getPropertyDescription());
			editprd.setPropertyRgistrationDate(property.getPropertyRgistrationDate());
			editprd.setPropertyType(property.getPropertyType());
			if(property.getPropertyImage1()!= null)
			{editprd.setPropertyImage1(property.getPropertyImage1());}
			if(property.getPropertyImage2()!= null)
			{editprd.setPropertyImage2(property.getPropertyImage2());}
			if(property.getPropertyImage3()!= null)
			{editprd.setPropertyImage3(property.getPropertyImage3());}
			if(property.getPropertyImage4()!= null)
			{System.out.println("in if ");editprd.setPropertyImage4(property.getPropertyImage4());}
			if(property.getPropertyImage5()!= null)
			{editprd.setPropertyImage5(property.getPropertyImage5());}
			if(property.getPropertyImage6()!= null)
			{editprd.setPropertyImage6(property.getPropertyImage6());}
			if(property.getPropertyImage7()!= null)
			{editprd.setPropertyImage7(property.getPropertyImage7());}
			if(property.getPropertyImage8()!= null)
			{editprd.setPropertyImage8(property.getPropertyImage8());}
			if(property.getPropertyImage9()!= null)
			{editprd.setPropertyImage9(property.getPropertyImage9());}
			if(property.getPropertyImage10()!= null)
			{editprd.setPropertyImage10(property.getPropertyImage10());}
			editprd.setPropertyLocation(property.getPropertyLocation());
			editprd.setPropertyName(property.getPropertyName());
			editprd.setPropertyPrice(property.getPropertyPrice());
			editprd.setPropertySize(property.getPropertySize());
			editprd.setPropertyTotalHall(property.getPropertyTotalHall());
			editprd.setSearchUrl(search.toLowerCase());
			editprd.setPropertyUrl(property.getPropertyName().replace(" ", "-") + property.getPropertyId());

			propertyRepository.save(editprd);
		} else {
			System.out.println("sorry");
		}

	}

	public Page<Property> findAll(Pageable pageable) {
		return propertyRepository.findAll(pageable);

	}

	// to display Single Property
	public Property getPropertyByPropertyUrl(String url) {
		Property property = propertyRepository.getByPropertyUrl(url);
		return property;
	}

	// Display All Properties of USerId
	public Page<Property> findAllPropertyByUserId(int userId, Pageable pageable) {
		return propertyRepository.findByuserId(userId, pageable);

	}

	// Display All Properties By Type Search
	public Page<Property> findAllPropertyByPropertyType(String url, Pageable pageable) {
		return propertyRepository.findByPropertyType(url, pageable);

	}

	// Delete Property by url
	public void deletePropertyByUrl(String url) {
		Property property = propertyRepository.getByPropertyUrl(url);
		propertyRepository.deleteById(property.getPropertyId());
	}

	// get Property by SearchUrl
	public Page<Property> findAllPropertyBySearchUrl(SearchProperty search, Pageable pageable) {
		String s = search.getPropertyName().replaceAll("\\s", "") + search.getPropertyCity().replaceAll("\\s", "")
				+ search.getPropertyLocation().replaceAll("\\s", "") + search.getPropetyType().replaceAll("\\s", "");
		return propertyRepository.getBySearchUrl(s, pageable);
	}
	
}
