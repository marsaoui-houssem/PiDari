package com.esprit.dari.dao.abonnement;


import com.esprit.dari.entities.abonnement.OffreService;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IServiceRepository extends CrudRepository<OffreService,Integer> {


    @Query(value="select * from  offre_service serv , abonnement abon  where abon.id_abon=:idAbon and abon.id_abon=serv.serv_abon_id_abon ",nativeQuery = true)
    public List<OffreService> getAllServbyAbon (@Param("idAbon") int idAbon);


    @Transactional
    @Modifying
    @Query("update OffreService serv set serv.prixServ=:prix where serv.idServ=:idServ")
    public void mettreAjourPrixService(@Param("idServ") int idServ ,@Param("prix") float prix );
}
