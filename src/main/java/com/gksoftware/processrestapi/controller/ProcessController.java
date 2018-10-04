package com.gksoftware.processrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gksoftware.processrestapi.repository.ProcessRepository;
import com.gksoftware.processrestapi.entity.*;;

@RestController
@RequestMapping(path = "/process", produces = {MediaType.APPLICATION_XML_VALUE})
public class ProcessController {
	
	@Autowired
	private ProcessRepository pRepository;
	
	@PostMapping(produces = {MediaType.APPLICATION_XML_VALUE})
	public ProcessEntity add(@Valid @RequestBody ProcessEntity pService) {
		return this.pRepository.save(pService);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE})
	public List<ProcessEntity> getAll(){
		return pRepository.findAll();
	}
	
	@GetMapping(path = "/{pid}", produces = {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProcessEntity> search(@PathVariable String pid){
		ProcessEntity pService = pRepository.getOne(pid);
		if(pService == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pService);
	}
	
	@PutMapping(path = "/{pid}", produces = {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProcessEntity> update(@PathVariable String pid, @Valid @RequestBody ProcessEntity pService){
		ProcessEntity process = pRepository.getOne(pid);
		if(process == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(pService, process, "pid");
		process = pRepository.save(process);
		return ResponseEntity.ok(process);
	}
	
	@DeleteMapping(path = "/{pid}", produces = {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProcessEntity> remover(@PathVariable String pid) {
		ProcessEntity process = pRepository.getOne(pid);
		
		if (process == null) {
			return ResponseEntity.notFound().build();
		}
		pRepository.delete(process);
		return ResponseEntity.noContent().build();
	}
	
}
