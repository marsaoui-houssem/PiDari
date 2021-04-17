package com.eprit.dari.dao;

import com.eprit.dari.entities.Basket;
import com.eprit.dari.entities.Livraison;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivraisonRepository extends CrudRepository<Livraison, Long> {


    @Query("SELECT count(id) FROM Livraison")
    public int countLivraison();

    @Query("SELECT l from Livraison l")
    public Livraison findLivraison();

}
