package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PackageFeatures {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	int featureId;
	String featureName;
	public PackageFeatures() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PackageFeatures(int featureId, String featureName) {
		super();
		this.featureId = featureId;
		this.featureName = featureName;
	}
	public int getFeatureId() {
		return featureId;
	}
	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	@Override
	public String toString() {
		return "PackageFeatures [featureId=" + featureId + ", featureName=" + featureName + "]";
	}
	
	
	
	
	
	
	
	
	
}
