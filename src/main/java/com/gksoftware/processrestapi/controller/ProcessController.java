package com.gksoftware.processrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gksoftware.processrestapi.service.ProcessService;

@RestController
public class ProcessController {
	
	@Autowired
	private ProcessService pService;
	
	@RequestMapping(value="/getProcess", method=RequestMethod.GET)
	public ProcessService getProcess() {
		pService = new ProcessService("123", "Proceso 1", 0, "Hi i'm process one", "x", "o");
		return pService;
	}
}
