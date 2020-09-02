package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderId;
	int uId;
	int packageId;
	String orderCode;
	String packagePrice;
	String packageName;
	String orderdate;
	String txStatus;
	String txTime;
	String firstName;
	String lastName;
	String Mobile;
	String startDate;
	String endDate;
	String packagePropertyCount;
	
	public OrderPackage() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	



	public OrderPackage(int orderId, int uId, int packageId, String orderCode, String packagePrice, String packageName,
			String orderdate, String txStatus, String txTime, String firstName, String lastName, String mobile,
			String startDate, String endDate, String packagePropertyCount) {
		super();
		this.orderId = orderId;
		this.uId = uId;
		this.packageId = packageId;
		this.orderCode = orderCode;
		this.packagePrice = packagePrice;
		this.packageName = packageName;
		this.orderdate = orderdate;
		this.txStatus = txStatus;
		this.txTime = txTime;
		this.firstName = firstName;
		this.lastName = lastName;
		Mobile = mobile;
		this.startDate = startDate;
		this.endDate = endDate;
		this.packagePropertyCount = packagePropertyCount;
	}








	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getuId() {
		return uId;
	}








	public void setuId(int uId) {
		this.uId = uId;
	}








	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getPackagePrice() {
		return packagePrice;
	}
	public void setPackagePrice(String packagePrice) {
		this.packagePrice = packagePrice;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getTxStatus() {
		return txStatus;
	}
	public void setTxStatus(String txStatus) {
		this.txStatus = txStatus;
	}
	public String getTxTime() {
		return txTime;
	}
	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
	
	public int getPackageId() {
		return packageId;
	}




	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}




	public String getPackagePropertyCount() {
		return packagePropertyCount;
	}




	public void setPackagePropertyCount(String packagePropertyCount) {
		this.packagePropertyCount = packagePropertyCount;
	}








	@Override
	public String toString() {
		return "OrderPackage [orderId=" + orderId + ", uId=" + uId + ", packageId=" + packageId + ", orderCode="
				+ orderCode + ", packagePrice=" + packagePrice + ", packageName=" + packageName + ", orderdate="
				+ orderdate + ", txStatus=" + txStatus + ", txTime=" + txTime + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", Mobile=" + Mobile + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", packagePropertyCount=" + packagePropertyCount + "]";
	}








	



}
