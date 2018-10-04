package com.gksoftware.processrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.gksoftware.processrestapi.service.ProcessService;

@RestController
@RequestMapping("/process")
public class ProcessController {
	
	@Autowired
	private ProcessRepository pRepository;
	
	@PostMapping
	public ProcessService add(@Valid @RequestBody ProcessService pService) {
		return this.pRepository.save(pService);
	}
	
	@GetMapping
	public List<ProcessService> getAll(){
		return pRepository.findAll();
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<ProcessService> search(@PathVariable String pid){
		ProcessService pService = pRepository.getOne(pid);
		if(pService == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pService);
	}
	
	@PutMapping("/{pid}")
	public ResponseEntity<ProcessService> update(@PathVariable String pid, @Valid @RequestBody ProcessService pService){
		ProcessService process = pRepository.getOne(pid);
		if(process == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(pService, process, "pid");
		process = pRepository.save(process);
		return ResponseEntity.ok(process);
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<Void> remover(@PathVariable String pid) {
		ProcessService process = pRepository.getOne(pid);
		
		if (process == null) {
			return ResponseEntity.notFound().build();
		}
		pRepository.delete(process);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	/*@RequestMapping(value="/getProcess", method=RequestMethod.GET)
	public ProcessService getProcess() {
		pService = new ProcessService("123", "Proceso 1", 0, "Hi i'm process one", "x", "o");
		return pService;
	}*/
}
