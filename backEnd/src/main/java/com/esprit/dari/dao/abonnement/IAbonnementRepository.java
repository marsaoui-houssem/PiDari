package com.esprit.dari.dao.abonnement;


import com.esprit.dari.entities.abonnement.Abonnement;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface IAbonnementRepository  extends CrudRepository<Abonnement,Integer> {


    @Query( "Select Datefint  from Abonnement ")
    public List<Date> getAllDatefint ();


    @Transactional
    @Modifying
    @Query("update Abonnement ab set ab.Datefint=:datefint where ab.idAbon=:idAbon")
    public void mettreAjourdatefinByAbon(@Param("datefint") Date datefint ,@Param("idAbon") int idAbon );


    @Transactional
    @Modifying
    @Query ("update Abonnement  ab set ab.prix=:prix where  ab.idAbon=:id")
    public void mettreAjourPrixRemise(@Param("id") int id ,@Param("prix") float prix );

    @Query(value =" select count(*) from abonnement ab  where  ab.type_abon = 'Server' ",nativeQuery = true)
    public int countAbonserver ();

    @Query(value = "select count(*) from abonnement ab where ab.type_abon ='Gold' ",nativeQuery = true)
    public int countAbonGold();

    @Query(value = "select count(*) from abonnement ab where ab.type_abon = 'Premium' ",nativeQuery = true)
    public int ContAbonPremium();

}
