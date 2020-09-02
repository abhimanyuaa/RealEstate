package com.example.demo.Service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.OrderPackage;
import com.example.demo.Model.OrderRequest;
import com.example.demo.Model.OrderResponse;
import com.example.demo.Model.User;
import com.example.demo.Repository.OrderPackageRepository;
import com.example.demo.Repository.PackageRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Model.Package;

@Service
@Transactional

public class OrderPackageService {

	@Autowired
	OrderPackageRepository orderPackageRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PackageRepository packageRepository;

	public OrderPackage getOrderByUId(int uid) {
		return orderPackageRepository.getByuId(uid);

	}

	public String calculateEndDate(String packageName) {

		DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Package pck = packageRepository.getByPackageName(packageName);
		String duration = pck.getPackageDuration();
		int days = Integer.parseInt(duration);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String EndDate = dateformat.format(cal.getTime());
		return EndDate;

	}

	public OrderRequest saveOrder(OrderPackage order, int uid) throws InvalidKeyException, NoSuchAlgorithmException {
		/*OrderPackage ord = getOrderByUId(uid);
		int count = Integer.parseInt(ord.getPackagePropertyCount());
		if (count >0){
			System.out.println("in if condition");
			orderPackageRepository.save(order);
			return null;
		}*/
		
		
			  User u1 = null;
			Optional<User> u = userRepository.findById(uid);
			if (u != null) {
				u1 = u.get();
			}
			String endDate = calculateEndDate(order.getPackageName());
			Date date = new Date();
			DateFormat FormatofOrderCode = new SimpleDateFormat("yyyyMMddHHmmss");
			DateFormat FormatOrderDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String ordercode = "OC" + uid + FormatofOrderCode.format(date);
			order.setOrderCode(ordercode);
			order.setOrderdate(FormatOrderDate.format(date));
			order.setuId(uid);
			order.setFirstName(u1.getFirstName());
			order.setLastName(u1.getLastName());
			order.setMobile(u1.getMobile());
			order.setStartDate(FormatOrderDate.format(date));
			order.setEndDate(endDate);
			orderPackageRepository.save(order);

			// if count is zero then go for purchase
		
			// Cash Free Call with data
			Map<String, String> postData = new HashMap<String, String>();
			postData.put("appId", "234919b0257d323050ceee5b919432");
			postData.put("orderId", order.getOrderCode());
			postData.put("orderAmount", order.getPackagePrice());
			postData.put("orderCurrency", "INR");
			postData.put("orderNote", "test");
			postData.put("customerName", u1.getFirstName());
			postData.put("customerEmail", u1.getUsername());
			postData.put("customerPhone", u1.getMobile());
			postData.put("returnUrl", "http://localhost:8811/OrderResponse");
			postData.put("notifyUrl", "http://localhost:8811/OrderResponse");

			String data = "";
			SortedSet<String> keys = new TreeSet<String>(postData.keySet());
			for (String key : keys) {
				data = data + key + postData.get(key);
			}
			String secretKey = "bf029b594e683c101cac0a23e44194eeb62908d6";
			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key_spec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
			sha256_HMAC.init(secret_key_spec);
			String signature = Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(data.getBytes()));
			OrderRequest ordReq = new OrderRequest(postData, signature);
			orderPackageRepository.save(order);
			return ordReq;
			
		
	

	}

	public String getCoumputedSignature(OrderResponse responseOrder, String sign)
			throws NoSuchAlgorithmException, InvalidKeyException {
		String orderId = responseOrder.getOrderId();
		String orderAmount = responseOrder.getOrderAmount();
		String referenceId = responseOrder.getReferenceId();
		String txStatus = responseOrder.getTxStatus();
		String paymentMode = responseOrder.getPaymentMode();
		String txMsg = responseOrder.getTxMsg();
		String txTime = responseOrder.getTxTime();

		LinkedHashMap<String, String> postData = new LinkedHashMap<String, String>();

		postData.put("orderId", orderId);
		postData.put("orderAmount", orderAmount);
		postData.put("referenceId", referenceId);
		postData.put("txStatus", txStatus);
		postData.put("paymentMode", paymentMode);
		postData.put("txMsg", txMsg);
		postData.put("txTime", txTime);

		String data = orderId + orderAmount + referenceId + txStatus + paymentMode + txMsg + txTime;
		Set<String> keys = postData.keySet();

		for (String key : keys) {
			data = data + postData.get(key);
		}
		String secretKey = "bf029b594e683c101cac0a23e44194eeb62908d6"; // Get secret key from config;
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key_spec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
		sha256_HMAC.init(secret_key_spec);

		String computedsignature = Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(data.getBytes()));

		return computedsignature;
	}

}
