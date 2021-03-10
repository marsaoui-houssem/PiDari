package com.esprit.dari.dao;


import com.esprit.dari.entities.Abonnement;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IAbonnementRepository  extends CrudRepository<Abonnement,Integer> {


}
