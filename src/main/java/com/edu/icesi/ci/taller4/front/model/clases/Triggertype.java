package com.edu.icesi.ci.taller4.front.model.clases;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.edu.icesi.ci.taller4.front.validations.CrearTrigTy;
import com.edu.icesi.ci.taller4.front.validations.EditarTrigTy;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Triggertype {
	
	private long trigtypeId;

	@NotNull(groups= {CrearTrigTy.class,EditarTrigTy.class})
	private BigDecimal instInstId;

	@NotBlank(groups= {CrearTrigTy.class,EditarTrigTy.class})
	private String trigtypeName;
	
	private List<Triggerr> triggerrs;
	
	private FevInstitution fevinstitution;
	
	public Triggertype() {
	}

	public long getTrigtypeId() {
		return this.trigtypeId;
	}

	public void setTrigtypeId(long trigtypeId) {
		this.trigtypeId = trigtypeId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public String getTrigtypeName() {
		return this.trigtypeName;
	}

	public void setTrigtypeName(String trigtypeName) {
		this.trigtypeName = trigtypeName;
	}

	public List<Triggerr> getTriggerrs() {
		return this.triggerrs;
	}

	public void setTriggerrs(List<Triggerr> triggerrs) {
		this.triggerrs = triggerrs;
	}

	public Triggerr removeTriggerr(Triggerr triggerr) {
		getTriggerrs().remove(triggerr);
		triggerr.setTriggertype(null);

		return triggerr;
	}
	
	public FevInstitution getFevInstitution() {
		return fevinstitution;
	}
	
	public void setFevInstitution(FevInstitution fevinstitution) {
		this.fevinstitution = fevinstitution;
	}

}
