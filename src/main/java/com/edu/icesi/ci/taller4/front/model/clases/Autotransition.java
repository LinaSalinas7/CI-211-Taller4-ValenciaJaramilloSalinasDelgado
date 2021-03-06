package com.edu.icesi.ci.taller4.front.model.clases;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.edu.icesi.ci.taller4.front.validations.CrearAutotran;
import com.edu.icesi.ci.taller4.front.validations.EditarAutotran;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class Autotransition implements Serializable {
	
	private long autotranId;
	
	@NotBlank(groups = {CrearAutotran.class,EditarAutotran.class})
	private String autotranName;

	@NotBlank(groups = {CrearAutotran.class,EditarAutotran.class})
	private String autotranIsactive;

	@NotBlank(groups = {CrearAutotran.class,EditarAutotran.class})
	private String autotranLogicaloperand;
	
	@NotNull(groups = {CrearAutotran.class,EditarAutotran.class})
	private BigDecimal instInstId;

	public Autotransition() {
	}
	
	public long getAutotranId() {
		return this.autotranId;
	}

	public void setAutotranId(long autotranId) {
		this.autotranId = autotranId;
	}

	public String getAutotranIsactive() {
		return this.autotranIsactive;
	}

	public void setAutotranIsactive(String autotranIsactive) {
		this.autotranIsactive = autotranIsactive;
	}

	public String getAutotranLogicaloperand() {
		return this.autotranLogicaloperand;
	}

	public void setAutotranLogicaloperand(String autotranLogicaloperand) {
		this.autotranLogicaloperand = autotranLogicaloperand;
	}

	public String getAutotranName() {
		return this.autotranName;
	}

	public void setAutotranName(String autotranName) {
		this.autotranName = autotranName;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	

}