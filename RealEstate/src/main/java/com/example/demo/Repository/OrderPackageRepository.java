package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.OrderPackage;

public interface OrderPackageRepository extends JpaRepository<OrderPackage, Integer> {

	
	OrderPackage getByOrderCode(String orderCode);
	
	OrderPackage getByuId(int uId);
}
