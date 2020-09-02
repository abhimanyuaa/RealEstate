package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.PropertyType;
import com.example.demo.Repository.PropertyTypeRepository;

@Service
@Transactional
public class PropertyTypeService {

	@Autowired
	PropertyTypeRepository typeRepository;
	
	
	public void savePropertyType(PropertyType type )
	{
		typeRepository.save(type);
	}
	
	
	// get All Type
		public List<PropertyType> showAllPropertyType() {
			List<PropertyType> typelist = new ArrayList<PropertyType>();
			for (PropertyType ct : typeRepository.findAll()) {
				typelist.add(ct);
			}
			return typelist;
		}
	
		//get Category
		public PropertyType getCategoryByPropertyTypeUrl(String typeUrl) {
			PropertyType type = typeRepository.getByTypeUrl(typeUrl);
			return type;
		}
	
}
