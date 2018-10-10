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
import org.springframework.web.bind.annotation.RestController;

import com.gksoftware.processrestapi.repository.ProcessRepository;
import com.gksoftware.processrestapi.service.ProcessService;
import com.gksoftware.processrestapi.entity.*;
import com.gksoftware.processrestapi.model.Process;

@RestController
@RequestMapping("/process")
public class ProcessController {
	
	@Autowired
	private ProcessRepository pRepository;
	
	private ProcessService serviceP = new ProcessService();
	
	@PostMapping(produces = {MediaType.APPLICATION_XML_VALUE})
	public ProcessEntity add(@Valid @RequestBody ProcessEntity pService) {
		this.pRepository.save(pService);
		return pService;
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE})
	public List<ProcessEntity> getAll(){
		List<ProcessEntity> listProcess = pRepository.findAll();
		return listProcess;
	}
	
	@GetMapping(path = "/{pid}", produces = {MediaType.APPLICATION_XML_VALUE})
	public ProcessEntity search(@PathVariable String pid){
		ProcessEntity pService = pRepository.getOne(pid);
		return pService;
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
	public ResponseEntity<Void> remover(@PathVariable String pid) {
		ProcessEntity pprocess = pRepository.getOne(pid);
		if (pprocess == null) {
			return ResponseEntity.notFound().build();
		}
		pRepository.delete(pprocess);
		return ResponseEntity.noContent().build();;
	}
	
}
