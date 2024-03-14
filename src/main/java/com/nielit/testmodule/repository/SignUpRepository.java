package com.nielit.testmodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nielit.testmodule.entities.SignUp;

@Repository
public interface SignUpRepository extends CrudRepository<SignUp, Long> {

	@Query(value = "SELECT * FROM signup WHERE userid =:userid", nativeQuery = true)
	public SignUp getUserdata(String userid);
}
