package com.example.demo.Model;

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
public class Package {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int packageId;
	String packageName;
	String packagePrice;
	String packageDuration;
	String packagePropertyCount;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Package_And_Features", joinColumns={@JoinColumn(name="Pkg_ID", referencedColumnName="packageId")}
    , inverseJoinColumns={@JoinColumn(name="feature_Id", referencedColumnName="featureId")})
	List<PackageFeatures>pkgFeatureList;
	
	
	
	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Package(int packageId, String packageName, String packagePrice, String packageDuration,
			String packagePropertyCount, List<PackageFeatures> pkgFeatureList) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packagePrice = packagePrice;
		this.packageDuration = packageDuration;
		this.packagePropertyCount = packagePropertyCount;
		this.pkgFeatureList = pkgFeatureList;
	}



	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackagePrice() {
		return packagePrice;
	}
	public void setPackagePrice(String packagePrice) {
		this.packagePrice = packagePrice;
	}
	public String getPackageDuration() {
		return packageDuration;
	}
	public void setPackageDuration(String packageDuration) {
		this.packageDuration = packageDuration;
	}
	
	
	public String getPackagePropertyCount() {
		return packagePropertyCount;
	}



	public void setPackagePropertyCount(String packagePropertyCount) {
		this.packagePropertyCount = packagePropertyCount;
	}



	public List<PackageFeatures> getPkgFeatureList() {
		return pkgFeatureList;
	}
	public void setPkgFeatureList(List<PackageFeatures> pkgFeatureList) {
		this.pkgFeatureList = pkgFeatureList;
	}



	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", packagePrice=" + packagePrice
				+ ", packageDuration=" + packageDuration + ", packagePropertyCount=" + packagePropertyCount
				+ ", pkgFeatureList=" + pkgFeatureList + "]";
	}
	
	

	
	
	
}
