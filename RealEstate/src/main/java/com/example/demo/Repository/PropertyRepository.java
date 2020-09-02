package com.example.demo.Repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Property;
@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

	//to display Single Property  
	public Property getByPropertyUrl(String propertyUrl);
	
	//get property by propertyID
	public Optional<Property> getByPropertyId(int propertyId);
	
	//Display All Properties of USer
	public Page<Property> findByuserId(int userId,Pageable pageable);
	
	//Display property by TYpe Search
	public Page<Property> findByPropertyType(String propertyType,Pageable pageable);
	
	//Search propety by given url
		@Query("select new com.example.demo.Model.Property(p.propertyId,p.propertyName,p.propertyLocation,p.propertyCity,p.propertyPrice,"
				+ " p.propertyType,p.propertyImage1,p.propertyImage2,p.propertySize,p.propertyDescription)"
				+ " from Property p"
				+ " where p.searchUrl LIKE %:searchUrl% ")
		public Page<Property> getBySearchUrl(String searchUrl,Pageable pageable);
	
	
}
