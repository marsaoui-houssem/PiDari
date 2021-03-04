package com.esprit.dari.dao;


import com.esprit.dari.entities.OffreService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOffreServiceRepository  extends CrudRepository<OffreService,Integer> {
}
