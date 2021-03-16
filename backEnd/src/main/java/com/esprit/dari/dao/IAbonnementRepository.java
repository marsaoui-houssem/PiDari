package com.esprit.dari.dao;


import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAbonnementRepository  extends CrudRepository<Abonnement,Integer> {





}
