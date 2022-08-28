package com.app.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.login.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer>{


	Login findLoginByLoginId(Integer loginId);

	Login findByUsername(String username);

}
