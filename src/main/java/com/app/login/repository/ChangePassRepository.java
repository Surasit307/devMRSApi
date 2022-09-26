package com.app.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Change_Password;


@Repository
public interface ChangePassRepository extends JpaRepository<Change_Password,Integer>{
	
	Integer countByUsername(String username);
	
}
