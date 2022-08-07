package com.turkcell.atm.sql.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.turkcell.atm.sql.dao.CustomerDao;
import com.turkcell.atm.sql.dto.BankDto;
import com.turkcell.atm.sql.dto.CustomerDto;

public class CustomerController implements IControllerBank<CustomerDto> {
	
	// object variable
	CustomerDao customerDao;
	
	// parametresiz constructor
	public CustomerController() {
		this.customerDao = new CustomerDao();
	}
	
	@Override
	public void create(CustomerDto customerDto) {
		customerDao.create(customerDto);
		
	}
	
	@Override
	public void update(CustomerDto customerDto) {
		customerDao.update(customerDto);
		
	}
	
	@Override
	public void delete(CustomerDto customerDto) {
		customerDao.delete(customerDto);
		
	}
	
	@Override
	public ArrayList<CustomerDto> list() {
		return customerDao.list();
	}
	
	public static void main(String[] args) {
		// 1- Bank Ekleyecegiz
		/*
		 * BankDto bankDto = new BankDto(5L, "VakifBank", "Atakum");
		 * BankController bankController = new BankController();
		 * bankController.create(bankDto);
		 * // 2- Customer 2 tane kayit
		 * CustomerController customerController = new CustomerController();
		 * CustomerDto customerDto = new CustomerDto("Merve", "Demir", "111111");
		 * customerDto.setBankDto(bankDto);
		 * CustomerDto customerDto2 = new CustomerDto("Gizem", "Sahin", "33333");
		 * customerDto2.setBankDto(bankDto);
		 * customerController.create(customerDto);
		 * customerController.create(customerDto2);
		 * // 3- inner joinler pgAdmin sorgusunun atalim
		 * // SELECT * FROM bank INNER JOIN customer ON bank.bank_id = customer.bank_id;
		 * // 4- Java Methodunda 3 adimi yazalim ?
		 */
		
		// insertBankController();
		deleteBankController();
		
	}
	
	// INSERT
	// CustomerDto customerDto = BankDto.builder().bankName("Banka
	// 44").branchName("Malatya").build();
	// bankController.create(customerDto);
	public static void insertBankController() {
		Scanner input = new Scanner(System.in);
		
		BankDto bankDto = new BankDto(input.nextLine(), input.nextLine());
		BankController bankController = new BankController();
		bankController.create(bankDto);
	}
	
	// UPDATE
	// Long id, Date createdDate, String bankName, String branchName
	// BankDto bankDto = new BankDto(1L, "Bank 23", "sube 23");
	// bankController.update(bankDto);
	public static void updateBankController() {
		Scanner input = new Scanner(System.in);
		
		BankDto bankDto = new BankDto(input.nextLine(), input.nextLine());
		BankController bankController = new BankController();
		bankController.update(bankDto);
	}
	
	// DELETE
	// BankDto bankDto = new BankDto();
	// bankDto.setId(2L);
	// bankController.delete(bankDto);
	public static void deleteBankController() {
		Scanner input = new Scanner(System.in);
		
		BankDto bankDto = new BankDto(6L, input.nextLine(), input.nextLine());
		System.out.println("BankName: " + bankDto.getBankName() + "\nBranchName: " + bankDto.getBranchName() + "\nId: "
				+ bankDto.getId());
		
		BankController bankController = new BankController();
		bankController.create(bankDto); // first create then delete
		bankController.delete(bankDto);
	}
	
}
