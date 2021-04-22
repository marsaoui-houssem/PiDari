package com.esprit.dari.dao.LouerAchat;

import com.esprit.dari.entities.LouerAchat.RentContract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RentContractRepository extends CrudRepository<RentContract, Integer>{

}
