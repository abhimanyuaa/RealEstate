package com.example.demo.Model;

import java.util.Map;

public class OrderRequest {


	Map<String, String> postData;
	String signature;
	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderRequest(Map<String, String> postData, String signature) {
		super();
		this.postData = postData;
		this.signature = signature;
	}
	public Map<String, String> getPostData() {
		return postData;
	}
	public void setPostData(Map<String, String> postData) {
		this.postData = postData;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	

}
