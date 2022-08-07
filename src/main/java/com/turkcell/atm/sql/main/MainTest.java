package com.turkcell.atm.sql.main;

import java.util.List;

import com.turkcell.atm.sql.controller.BankController;
import com.turkcell.atm.sql.dto.BankDto;

public class MainTest {
	
	public static void main(String[] args) {
		BankController bankController = new BankController();
		
		// INSERT
		// BankDto bankDto = BankDto.builder().bankName("Banka
		// 44").branchName("Malatya").build();
		// bankController.create(bankDto);
		
		// UPDATE
		// Long id, Date createdDate, String bankName, String branchName
		// BankDto bankDto = new BankDto(1L, "Bank 23", "şube 23");
		// bankController.update(bankDto);
		
		// DELETE
		// BankDto bankDto = new BankDto();
		// bankDto.setId(2L);
		// bankController.delete(bankDto);
		
		// LIST
		List<BankDto> listem = bankController.list();
		listem.forEach(System.out::println);
	}
	
}
