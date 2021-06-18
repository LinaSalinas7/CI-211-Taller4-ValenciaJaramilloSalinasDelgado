package com.edu.icesi.ci.taller4.back.repository;

import org.springframework.data.repository.CrudRepository;

import com.edu.icesi.ci.taller4.back.model.Userr;

public interface UserrRepository extends CrudRepository<Userr,Long>{
	public Userr findByUserName(String username);
}
