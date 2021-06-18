package com.edu.icesi.ci.taller4.front.model.clases;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Triggerr {

	private long trigId;

	private String trigName;

	private String trigScope;
	
	private Triggertype triggertype;

	@JsonIgnore
	private List<Userselect> userselects;
		
	public Triggerr() {
	}

	public long getTrigId() {
		return this.trigId;
	}

	public void setTrigId(long trigId) {
		this.trigId = trigId;
	}

	public String getTrigName() {
		return this.trigName;
	}

	public void setTrigName(String trigName) {
		this.trigName = trigName;
	}

	public String getTrigScope() {
		return this.trigScope;
	}

	public void setTrigScope(String trigScope) {
		this.trigScope = trigScope;
	}


	public Triggertype getTriggertype() {
		return this.triggertype;
	}

	public void setTriggertype(Triggertype triggertype) {
		this.triggertype = triggertype;
	}

	public List<Userselect> getUserselects() {
		return this.userselects;
	}

	public void setUserselects(List<Userselect> userselects) {
		this.userselects = userselects;
	}

	
}
