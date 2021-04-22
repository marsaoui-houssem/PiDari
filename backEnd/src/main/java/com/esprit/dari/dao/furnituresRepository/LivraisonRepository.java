package com.esprit.dari.dao.furnituresRepository;

import com.esprit.dari.entities.furnituresEntities.Livraison;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LivraisonRepository extends CrudRepository<Livraison, Long> {


    @Query("SELECT count(id) FROM Livraison")
    public int countLivraison();

    @Query("SELECT l from Livraison l")
    public Livraison findLivraison();

}
