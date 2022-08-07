package com.turkcell.atm.sql.dto;

import java.util.Scanner;

import lombok.Data;

@Data
public class ThermoMetherDto extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private double number;
	Scanner klavye;
	
	public ThermoMetherDto() {
		super();
		klavye = new Scanner(System.in);
	}
	
	public ThermoMetherDto(double number) {
		super();
		this.number = number;
	}
	
	// Result isLogin
	public boolean isLogin() {
		System.out.println("Atesin derecesini giriniz");
		if (number <= 36.5)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		ThermoMetherDto dto = new ThermoMetherDto();
		dto.setNumber(38);
		boolean result = dto.isLogin();
		System.out.println(result);
	}
	
}
