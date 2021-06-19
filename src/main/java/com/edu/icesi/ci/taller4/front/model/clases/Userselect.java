package com.edu.icesi.ci.taller4.front.model.clases;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.edu.icesi.ci.taller4.front.validations.CrearUssel;
import com.edu.icesi.ci.taller4.front.validations.EditarUssel;

public class Userselect {
	
	private long usselId;

	private String usselTablename;
	
	private String usselValuekeycolumn;

	@NotBlank(groups= {CrearUssel.class,EditarUssel.class})
	private String usselValueusercolumn;

	@NotBlank(groups= {CrearUssel.class,EditarUssel.class})
	private String usselWherestatement;

	@NotNull(groups= {CrearUssel.class,EditarUssel.class})
	private Triggerr triggerr;

	public Userselect() {
	}

	public long getUsselId() {
		return this.usselId;
	}

	public void setUsselId(long usselId) {
		this.usselId = usselId;
	}

	public String getUsselTablename() {
		return this.usselTablename;
	}

	public void setUsselTablename(String usselTablename) {
		this.usselTablename = usselTablename;
	}

	public String getUsselValuekeycolumn() {
		return this.usselValuekeycolumn;
	}

	public void setUsselValuekeycolumn(String usselValuekeycolumn) {
		this.usselValuekeycolumn = usselValuekeycolumn;
	}

	public String getUsselValueusercolumn() {
		return this.usselValueusercolumn;
	}

	public void setUsselValueusercolumn(String usselValueusercolumn) {
		this.usselValueusercolumn = usselValueusercolumn;
	}

	public String getUsselWherestatement() {
		return this.usselWherestatement;
	}

	public void setUsselWherestatement(String usselWherestatement) {
		this.usselWherestatement = usselWherestatement;
	}

	public Triggerr getTriggerr() {
		return this.triggerr;
	}

	public void setTriggerr(Triggerr triggerr) {
		this.triggerr = triggerr;
	}

}
