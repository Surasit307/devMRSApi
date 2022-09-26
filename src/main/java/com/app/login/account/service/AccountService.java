package com.app.login.account.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.entity.Account;
import com.app.entity.Login;
import com.app.login.account.dto.AccountIn;
import com.app.login.account.dto.NewpasswordIn;
import com.app.login.auction.entity.ListAuction;
import com.app.login.login.dto.LoginIn;
import com.app.login.login.dto.LogoutIn;

@Service
public interface AccountService {

	Map<String, Object> create(AccountIn accountIn) throws Exception;
	
	Map<String, Object> read(int accountId) throws Exception;
	
	Map<String, Object> update(AccountIn accountIn) throws Exception;

	Map<String, Object> delete(int accountId) throws Exception;

	Map<String, Object> userlogin(LoginIn loginIn) throws Exception;

	Map<String, Object> userlogout(LogoutIn logoutIn) throws Exception;

	Map<String, Object> newpass(NewpasswordIn newpasswordIn) throws Exception;

	Map<String, Object> changepass(NewpasswordIn newpasswordIn) throws Exception;

	List<Account> getAllAccount();

	void DeleteAllAccount(Account account) throws Exception;

	List<ListAuction> getAllListAuction();




	



}
