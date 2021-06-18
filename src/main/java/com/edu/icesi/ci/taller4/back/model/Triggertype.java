package com.edu.icesi.ci.taller4.back.model;



import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.edu.icesi.ci.taller4.front.validations.CrearTrig;
import com.edu.icesi.ci.taller4.front.validations.CrearTrigTy;
import com.edu.icesi.ci.taller4.front.validations.EditarTrig;
import com.edu.icesi.ci.taller4.front.validations.EditarTrigTy;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TRIGGERTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="Triggertype.findAll", query="SELECT t FROM Triggertype t")
public class Triggertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRIGGERTYPE_TRIGTYPEID_GENERATOR", sequenceName="TRIGGERTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TRIGGERTYPE_TRIGTYPEID_GENERATOR")
	@Column(name="TRIGTYPE_ID")
	@NotNull(groups= {CrearTrig.class, EditarTrig.class})
	private long trigtypeId;

	@Column(name="INST_INST_ID")
	@NotNull(groups= {CrearTrigTy.class,EditarTrigTy.class})
	private BigDecimal instInstId;

	@Column(name="TRIGTYPE_NAME")
	@NotBlank(groups= {CrearTrigTy.class,EditarTrigTy.class})
	private String trigtypeName;

	//bi-directional many-to-one association to Triggerr
	@OneToMany(mappedBy="triggertype")
	private List<Triggerr> triggerrs;
	
	//Se agregan las siguientes relaciones de acuerdo al diagrama del enunciado
	//bi-directional many-to-one association to fevInstitution
	@ManyToOne	
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

	public Triggerr addTriggerr(Triggerr triggerr) {
		getTriggerrs().add(triggerr);
		triggerr.setTriggertype(this);

		return triggerr;
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