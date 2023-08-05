package com.learn.first.restapi.repository;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.model.CWard;

public interface IWardRepository extends JpaRepository<CWard, Integer> {

    // Optional<CWard> findById(Integer id);

    // void deleteById(Integer id);

}
