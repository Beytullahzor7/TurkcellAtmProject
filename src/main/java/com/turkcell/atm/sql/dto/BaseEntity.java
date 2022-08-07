package com.turkcell.atm.sql.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date createdDate;
	
	public BaseEntity() {
	}
	
	public BaseEntity(Long id) {
		this.id = id;
	}
	
}
