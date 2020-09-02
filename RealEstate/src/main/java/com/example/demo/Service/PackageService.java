package com.example.demo.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Model.Package;

import com.example.demo.Repository.PackageRepository;


@Service
@Transactional
public class PackageService {

	@Autowired
	PackageRepository packageRepository;
	
	
	public Package getPackageById(int packageId)
	{
		return packageRepository.getByPackageId(packageId);
	}	
	public void savePackage(Package pack) {
		packageRepository.save(pack);
	}

	public Page<Package> findAllPackage(Pageable pageable) {
		return packageRepository.findAll(pageable);
		}

	public List<Package> findAllPackage() {
		return packageRepository.findAll();
		}

	
}
