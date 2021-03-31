package com.esprit.dari.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("SELECT count(*) FROM User")
    public int countUsers();
}
