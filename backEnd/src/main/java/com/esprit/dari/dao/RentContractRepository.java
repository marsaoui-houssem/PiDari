package com.esprit.dari.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.RentContract;


@Repository
public interface RentContractRepository extends CrudRepository<RentContract, Integer>{

}
