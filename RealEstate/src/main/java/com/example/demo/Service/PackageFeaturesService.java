package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.PackageFeatures;
import com.example.demo.Repository.PackageFeatureRepository;

@Service
@Transactional
public class PackageFeaturesService {

	@Autowired
	PackageFeatureRepository pkgRepo;

	public void savePackageFeatures(PackageFeatures pf) {
		pkgRepo.save(pf);
	}

	// get All PackageFeatures
	public List<PackageFeatures> showAllPackageFeatures() {
		List<PackageFeatures> catlist = new ArrayList<PackageFeatures>();
		for (PackageFeatures ct : pkgRepo.findAll()) {
			catlist.add(ct);
		}
		return catlist;
	}

}
