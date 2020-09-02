package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PropertyType")
public class PropertyType {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	int typeId;
	String typeName;
	String typeUrl;
	
	
	public PropertyType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PropertyType(int typeId, String typeName, String typeUrl) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeUrl = typeUrl;
	}


	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getTypeUrl() {
		return typeUrl;
	}


	public void setTypeUrl(String typeUrl) {
		this.typeUrl = typeUrl;
	}


	@Override
	public String toString() {
		return "PropertyType [typeId=" + typeId + ", typeName=" + typeName + ", typeUrl=" + typeUrl + "]";
	}
	
	
	
	
}
