package com.learn.first.restapi.regions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.regions.model.CWard;

public interface IWardRepository extends JpaRepository<CWard, Long> {

}
