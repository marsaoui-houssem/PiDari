package com.esprit.dari.dao;


import com.esprit.dari.entities.OffreService;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceRepository extends CrudRepository<OffreService,Integer> {


    @Query(value="select * from  offre_service serv , abonnement abon , abonnement_services abonserv  where abon.id_abon=:idAbon and  abon.id_abon=abonserv.serv_abon_id_abon and abonserv.services_id_serv=serv.id_serv",nativeQuery = true)
    public List<OffreService> getAllServbyAbon (@Param("idAbon") int idAbon);
}
