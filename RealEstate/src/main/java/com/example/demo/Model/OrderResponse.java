package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int responseId;
	String orderId;
	String orderAmount;
	String referenceId ;
	String txStatus ;
	String paymentMode ;
	String txMsg ;
	String txTime ;
	
	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderResponse(String orderId, String orderAmount, String referenceId, String txStatus, String paymentMode,
			String txMsg, String txTime) {
		super();
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.referenceId = referenceId;
		this.txStatus = txStatus;
		this.paymentMode = paymentMode;
		this.txMsg = txMsg;
		this.txTime = txTime;
	}


	public OrderResponse(int responseId, String orderId, String orderAmount, String referenceId, String txStatus,
			String paymentMode, String txMsg, String txTime) {
		super();
		this.responseId = responseId;
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.referenceId = referenceId;
		this.txStatus = txStatus;
		this.paymentMode = paymentMode;
		this.txMsg = txMsg;
		this.txTime = txTime;
	}
	public int getResponseId() {
		return responseId;
	}
	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getTxStatus() {
		return txStatus;
	}
	public void setTxStatus(String txStatus) {
		this.txStatus = txStatus;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getTxMsg() {
		return txMsg;
	}
	public void setTxMsg(String txMsg) {
		this.txMsg = txMsg;
	}
	public String getTxTime() {
		return txTime;
	}
	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}
	@Override
	public String toString() {
		return "OrderResponse [responseId=" + responseId + ", orderId=" + orderId + ", orderAmount=" + orderAmount
				+ ", referenceId=" + referenceId + ", txStatus=" + txStatus + ", paymentMode=" + paymentMode
				+ ", txMsg=" + txMsg + ", txTime=" + txTime + "]";
	}
	
	
}
