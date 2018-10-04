package com.gksoftware.processrestapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gksoftware.processrestapi.entity.*;;

public interface ProcessRepository extends JpaRepository<ProcessEntity, String> {

}
