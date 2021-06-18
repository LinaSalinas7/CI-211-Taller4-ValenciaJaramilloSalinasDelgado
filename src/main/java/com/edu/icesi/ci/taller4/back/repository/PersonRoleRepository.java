package com.edu.icesi.ci.taller4.back.repository;

import com.edu.icesi.ci.taller4.back.model.PersonRole;
import com.edu.icesi.ci.taller4.back.model.PersonRolePK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRoleRepository extends CrudRepository<PersonRole, PersonRolePK>{
}
