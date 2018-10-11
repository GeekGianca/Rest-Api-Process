package com.gksoftware.processrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gksoftware.processrestapi.entity.ProcessEntity;
import com.gksoftware.processrestapi.model.ProcessList;
import com.gksoftware.processrestapi.repository.ListRepository;

@RestController
@RequestMapping("/")
public class ListController {
	@Autowired
	ListRepository lRepository;
	
	@PostMapping(produces = {MediaType.APPLICATION_XML_VALUE})
	public ProcessList add(@Valid @RequestBody ProcessList pList) {
		lRepository.save(pList);
		return pList;
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE})
	public List<ProcessList> getAll(){
		List<ProcessList> listProcess = lRepository.findAll();
		return listProcess;
	}
	
	/*@GetMapping(path = "/{pid}", produces = {MediaType.APPLICATION_XML_VALUE})
	public ProcessEntity search(@PathVariable String pid){
		ProcessEntity pService = pRepository.getOne(pid);
		return pService;
	}*/
}
