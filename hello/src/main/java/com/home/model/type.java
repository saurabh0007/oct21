package com.home.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="type")
public class type
{

	@Id
	@Column(name="S.NO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String BLOODGROUPID;
	
	private String BLOODGROUPNAME;
	private String BLOODUNIT;
	
	public int getId() {
		return id;
	}
	public String getBLOODGROUPID() {
		return BLOODGROUPID;
	}
	public void setBLOODGROUPID(String bLOODGROUPID) {
		BLOODGROUPID = bLOODGROUPID;
	}
	public String getBLOODGROUPNAME() {
		return BLOODGROUPNAME;
	}
	public void setBLOODGROUPNAME(String bLOODGROUPNAME) {
		BLOODGROUPNAME = bLOODGROUPNAME;
	}
	public String getBLOODUNIT() {
		return BLOODUNIT;
	}
	public void setBLOODUNIT(String bLOODUNIT) {
		BLOODUNIT = bLOODUNIT;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

}


	
	
