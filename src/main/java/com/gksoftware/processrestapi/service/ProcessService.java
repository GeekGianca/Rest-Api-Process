package com.gksoftware.processrestapi.service;

import java.util.ArrayList;
import java.util.List;

import com.gksoftware.processrestapi.entity.ProcessEntity;
import com.gksoftware.processrestapi.model.Process;

public class ProcessService {
	
	public Process convertProcess(ProcessEntity process) {
		return new Process(process.getPid(), process.getName(), process.getPriority(), process.getCharacters(), process.getCharactersReplacement(), process.getCharactersReplaced());
	}
	
	public List<Process> getAllProcess(List<ProcessEntity> processEntityList){
		List<Process> processList = new ArrayList<>();
		for(ProcessEntity pEntity:processEntityList) {
			processList.add(new Process(pEntity.getPid(), pEntity.getName(), pEntity.getPriority(), pEntity.getCharacters(), pEntity.getCharactersReplacement(), pEntity.getCharactersReplaced()));
		}
		return processList;
	}
}
