package com.esprit.dari.dao.creditrepository;


import com.esprit.dari.entities.creditentitie.Bank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankRepository  extends CrudRepository<Bank, Integer> {
//    @Query("Select * from Bank where offre=:offree")
//    public List<Bank> getBankByOffre(@Param("offree") double offre);
//    @Query("select offre from Bank where id=:idbank")
//    public Bank GetoffreBank(@Param("id") int idbank);
//    @Query("select * from Bank where approuvation=:'true'")
//    public Bank getBankApprouver();

}

