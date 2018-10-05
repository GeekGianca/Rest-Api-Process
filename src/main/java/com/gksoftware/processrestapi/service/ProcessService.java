package com.gksoftware.processrestapi.service;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Service;
@Entity
@Service
@XmlRootElement(name = "Process")
@XmlAccessorType(XmlAccessType.NONE)
public class ProcessService {
	
	@XmlAttribute(name="pid")
	private String pid;
	@XmlElement(name="name")
    private String name;
	@XmlElement(name="priority")
    private int priority;
	@XmlElement(name="characters")
    private String characters;
	@XmlElement(name="charactersReplacement")
    private String charactersReplacement;
	@XmlElement(name="charactersReplaced")
    private String charactersReplaced;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCharactersReplacement() {
        return charactersReplacement;
    }

    public void setCharactersReplacement(String characters) {
        this.charactersReplacement = characters;
    }

    public String getCharactersReplaced() {
        return charactersReplaced;
    }

    public void setCharactersReplaced(String charactersReplaced) {
        this.charactersReplaced = charactersReplaced;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public ProcessService() {
    }

    public ProcessService(String pid, String name, int priority, String characters, String charactersReplacement, String charactersReplaced) {
        this.pid = pid;
        this.name = name;
        this.priority = priority;
        this.characters = characters;
        this.charactersReplacement = charactersReplacement;
        this.charactersReplaced = charactersReplaced;
    }
}
