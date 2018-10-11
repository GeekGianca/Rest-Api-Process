package com.gksoftware.processrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gksoftware.processrestapi.model.ProcessList;

public interface ListRepository extends JpaRepository<ProcessList, Integer> {

}
