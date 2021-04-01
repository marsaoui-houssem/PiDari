package com.eprit.dari.dao;

import com.eprit.dari.entities.GiftPoints;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GiftPointsRepository extends CrudRepository<GiftPoints,Long> {


    @Query("select DISTINCT g from GiftPoints g "
            + "join g.users u "
            + "where u.userId=:userDariId "
    )
    public List<GiftPoints> getAllGiftPointsByUserDari(@Param("userDariId")Long userDariId);

    @Query("SELECT g FROM GiftPoints g WHERE g.code=:code")
    public GiftPoints getAllGiftPointsByCode(@Param("code")String code);



    @Query("select DISTINCT g from GiftPoints g "
            + "join g.users u "
            + "where u.userId=:userDariId and "
            + "g.etat=:etat"
    )
    public GiftPoints getAllGiftPointsByUserAndEtat(@Param("etat")String etat, @Param("userDariId")Long userDariId);

    @Query("select DISTINCT g from GiftPoints g "
            + "join g.users u "
            + "where u.userId=:userDariId and "
            + "g.code=:code"
    )
    public GiftPoints getAllGiftPointsByUserAndCode(@Param("code")String code, @Param("userDariId")Long userDariId);

}
