package com.gksoftware.processrestapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gksoftware.processrestapi.service.ProcessService;

public interface ProcessRepository extends JpaRepository<ProcessService, String> {

}
