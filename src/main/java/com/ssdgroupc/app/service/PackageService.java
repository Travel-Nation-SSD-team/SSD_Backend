package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Package;
import com.ssdgroupc.app.repository.PackageRepository;

@Service
public class PackageService {

	/**
	 * Injects PackageRepository
	 */
	@Autowired
	private PackageRepository packageRepository;

	/**
	 * Method to add a Package
	 */
	public Package addPackage(Package Package) {
		return packageRepository.save(Package);
	}

	/**
	 * Method to get all Packages
	 */
	public List<Package> getAllPackages() {
		List<Package> Package = new ArrayList<>();
		packageRepository.findAll().forEach(Package::add);
		return Package;
	}

	/**
	 * Method to get a Package
	 */
	public Optional<Package> getPackage(int id) {
		return packageRepository.findById(id);
	}

	/**
	 * Method to update a Package
	 */
	public Package updatePackage(int id, Package Package) {
		return packageRepository.save(Package);
	}

	/**
	 * Method to delete a Package
	 */
	public void deletePackage(int id) {
		packageRepository.deleteById(id);
	}

}
