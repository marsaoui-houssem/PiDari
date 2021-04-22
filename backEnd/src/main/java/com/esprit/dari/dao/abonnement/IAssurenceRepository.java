package com.esprit.dari.dao.abonnement;


import com.esprit.dari.entities.abonnement.Assurence;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IAssurenceRepository extends CrudRepository<Assurence,Integer> {



    @Query(value="select * from assurence ass  , abonnement ab where ab.id_abon=:idAbon and ab.id_abon = ass.ass_abon_id_abon",nativeQuery=true)
    public List<Assurence> getAllAssubyAbon (@Param("idAbon") int idAbon );



    @Transactional
    @Modifying
    @Query("update Assurence assu set assu.prixAss=:prix where assu.idAssu=:idAssu")
    public void modifprix (@Param("idAssu") int idAssu ,@Param("prix") float  prix    );

}
