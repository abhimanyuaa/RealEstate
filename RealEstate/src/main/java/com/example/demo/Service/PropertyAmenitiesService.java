package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.PropertyAmenities;
import com.example.demo.Repository.PropertyAmenitiesRepository;

@Service
@Transactional

public class PropertyAmenitiesService {


	@Autowired
	PropertyAmenitiesRepository amnRepo;

	
	
	public void savePropertyAmenites(PropertyAmenities pf) {
		amnRepo.save(pf);
	}

	// get All PackageFeatures
	public List<PropertyAmenities> showAllPropertyAmenities() {
		List<PropertyAmenities> amnlist = new ArrayList<PropertyAmenities>();
		for (PropertyAmenities ct : amnRepo.findAll()) {
			amnlist.add(ct);
		}
		return amnlist;
	}
	
	
	
}
