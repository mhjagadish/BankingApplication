package com.tech.BankingApp.mapper;

import com.tech.BankingApp.dto.AccountDto;
import com.tech.BankingApp.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto) {

//		Account account = new Account(
//				accountDto.getId(),
//				accountDto.getAccountHolderName(),
//				accountDto.getBalance()			
//				);
//		return account;	
		
		
		// report class is used hence get is removed 
		Account account = new Account(
				accountDto.id(),
				accountDto.accountHolderName(),
				accountDto.balance()
				);
				return account;			
	}
 
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				); 
		return accountDto;
	}
}