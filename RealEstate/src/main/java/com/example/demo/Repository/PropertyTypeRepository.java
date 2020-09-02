package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.PropertyType;


public interface PropertyTypeRepository extends JpaRepository<PropertyType, Integer> {

	public PropertyType getByTypeUrl(String typeUrl);

}
