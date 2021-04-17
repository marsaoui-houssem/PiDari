package com.eprit.dari.dao;

import com.eprit.dari.entities.Furniture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FurnitureRepository extends CrudRepository<Furniture,Long> {

    @Query("SELECT f FROM Furniture f WHERE f.furnitureId=:furnitureId")
    public Furniture getFurnitureById(@Param("furnitureId")Long furnitureId);
}
