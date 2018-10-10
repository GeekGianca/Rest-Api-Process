package com.gksoftware.processrestapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.gksoftware.processrestapi.entity.ProcessEntity;

@JacksonXmlRootElement(localName = "ProcessList")
public class ProcessList implements Serializable {

	/**
	 * @serialVersion
	 */
	private static final long serialVersionUID = 1L;
	@JacksonXmlProperty(localName = "ProcessList")
    @JacksonXmlElementWrapper(useWrapping = false)
	private List<ProcessEntity> processList = new ArrayList<>();
	
	public List<ProcessEntity> getProcessList() {
		return processList;
	}
	public void setProcessList(List<ProcessEntity> processList) {
		this.processList = processList;
	}
	
	public ProcessList(List<ProcessEntity> processList) {
		super();
		this.processList = processList;
	}
	
	public ProcessList() {
	}
}
