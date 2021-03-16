package com.esprit.dari.dao;


import com.esprit.dari.entities.Assurence;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IAssurenceRepository extends CrudRepository<Assurence,Integer> {



    @Query(value="select * from assurence ass , abonnement_assurences abs , abonnement ab where ab.id_abon=:idAbon and ab.id_abon = abs.ass_abon_id_abon and  abs.assurences_id_assu = ass.id_assu ",nativeQuery=true)
    public List<Assurence> getAllAssubyAbon (@Param("idAbon") int idAbon );


}
