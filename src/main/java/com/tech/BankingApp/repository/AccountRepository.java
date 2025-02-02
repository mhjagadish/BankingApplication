package com.tech.BankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.BankingApp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
  