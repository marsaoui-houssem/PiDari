package com.esprit.dari.dao.LouerAchat;

import com.esprit.dari.entities.LouerAchat.SellContract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SellContractRepository extends CrudRepository<SellContract, Integer>{

}
