package com.eprit.dari.dao;

import com.eprit.dari.entities.Basket;
import com.eprit.dari.entities.SoldFurniture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SoldFurnitureRepository extends CrudRepository<SoldFurniture, Long> {

    @Query("select DISTINCT s from SoldFurniture s "
            + "join s.commands c "
            + "where c.commandId=:commandId "
    )
    public List<SoldFurniture> getAllSoldFurnitureByCommands(@Param("commandId") Long commandId);
}
