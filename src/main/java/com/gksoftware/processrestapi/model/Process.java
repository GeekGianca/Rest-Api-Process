package com.gksoftware.processrestapi.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Service;

@Service
@XmlRootElement
public class Process {
	private String pid;
    private String name;
    private int priority;
    private String characters;
    private String charactersReplacement;
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

    public Process() {
    }

    public Process(String pid, String name, int priority, String characters, String charactersReplacement, String charactersReplaced) {
        this.pid = pid;
        this.name = name;
        this.priority = priority;
        this.characters = characters;
        this.charactersReplacement = charactersReplacement;
        this.charactersReplaced = charactersReplaced;
    }
}
