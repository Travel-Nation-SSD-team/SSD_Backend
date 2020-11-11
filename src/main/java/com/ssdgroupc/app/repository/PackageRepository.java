package com.ssdgroupc.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssdgroupc.app.entity.Package;

public interface PackageRepository extends CrudRepository<Package, Integer> {

}
