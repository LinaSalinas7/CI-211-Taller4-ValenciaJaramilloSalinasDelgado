package com.edu.icesi.ci.taller4.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.icesi.ci.taller4.back.model.Userselect;

@Repository
public interface UserselectRepository extends CrudRepository<Userselect,Long>{
}
