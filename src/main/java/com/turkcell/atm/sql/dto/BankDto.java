package com.turkcell.atm.sql.dto;

import java.util.List;

import lombok.Data;

@Data
public class BankDto extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	// Object Variable
	private String bankName;
	private String branchName;
	
	// composition
	List<CustomerDto> customerList;
	
	public BankDto() {
	}
	
	public BankDto(String bankName, String branchName) {
		super();
		this.bankName = bankName;
		this.branchName = branchName;
	}
	
	public BankDto(Long id, String bankName, String branchName) {
		super(id);
		this.bankName = bankName;
		this.branchName = branchName;
	}
	
}
