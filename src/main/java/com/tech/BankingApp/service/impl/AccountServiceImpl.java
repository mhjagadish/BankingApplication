package com.tech.BankingApp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.BankingApp.dto.AccountDto;
import com.tech.BankingApp.entity.Account;
import com.tech.BankingApp.exception.AccountException;
import com.tech.BankingApp.mapper.AccountMapper;
import com.tech.BankingApp.repository.AccountRepository;
import com.tech.BankingApp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	
	// inject Dependency
	private  AccountRepository accountRepository;
	
 	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account saveAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new AccountException("Account Does not exists"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new AccountException("Account not exists"));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account saveaccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(saveaccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new AccountException("Account not exists"));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient ammount");
		}
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
		.collect((Collectors.toList()));
	
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account not Exist"));	
		accountRepository.deleteById(id);
	}

}
