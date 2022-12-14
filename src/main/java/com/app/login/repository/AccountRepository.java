package com.app.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.app.entity.Account;
import com.app.entity.Login;
import com.app.login.login.dto.LoginIn;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{

	Account findAccountByAccountId(Integer accountId);
	
	//function findBy 
	public Account findByUsername(String username);
	
	@Query(value="Delete From account",nativeQuery = true)
	public Account deleteAll(Account account);
	
	@Query(value="Select * From account",nativeQuery = true)
	public Account findAll(Account account);


}
