package com.esprit.dari.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.RentContract;
import tn.esprit.spring.entities.SellContract;

@Repository
public interface SellContractRepository extends CrudRepository<SellContract, Integer>{

}
