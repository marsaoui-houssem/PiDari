package com.esprit.dari.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Sell;

@Repository
public interface SellAdRepository extends CrudRepository<Sell, Integer>{

}
