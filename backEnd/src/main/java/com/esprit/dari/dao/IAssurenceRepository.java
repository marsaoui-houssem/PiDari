package com.esprit.dari.dao;


import com.esprit.dari.entities.Assurence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssurenceRepository extends CrudRepository<Assurence,Integer> {
}
