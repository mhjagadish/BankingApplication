package com.tech.BankingApp.dto;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data
//@AllArgsConstructor
//public class AccountDto {
//	private Long id;
//	private String accountHolderName;
//	private double balance;
//	}


//java 16 feature : record class is used because it has getter setter methods we need not to call get methods, just call variable name(), also variables are final cannot be altered 
public record AccountDto(Long id,
						String accountHolderName,
						double balance) {
	
}