package com.nielit.testmodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nielit.testmodule.beans.LoginBean;
import com.nielit.testmodule.entities.LoginDetails;
import com.nielit.testmodule.entities.SignUp;

@Repository
public interface LoginRepository extends CrudRepository<LoginDetails, Long> {

	@Query(value = "SELECT * FROM login_details WHERE loginid =:loginid and password =:password", nativeQuery = true)
	public LoginDetails checkLogin(String loginid, String password);

	@Query(value = "SELECT * FROM login_details WHERE loginid =:userid", nativeQuery = true)
	public LoginDetails getUserdata(String userid);
}
