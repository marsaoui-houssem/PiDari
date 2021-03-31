package com.esprit.dari.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.jayway.jsonpath.Predicate;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.AdCriteria;
import tn.esprit.spring.entities.Ad_Etat;

public interface AdRepository extends JpaRepository<Ad, Integer>{


	@Query("SELECT AVG(A.taux_reduction) FROM Ad A")
	public float GetAVGReduction();
	
	@Query("select A from Ad A where A.taux_reduction > :C")
    public List<Ad> GetBestReduction(@Param("C") int C);
	
	
	@Query("SELECT A FROM Ad A WHERE A.etat LIKE :Etat")
	public List<Ad> GetAllAdsByEtat(@Param("Etat")Ad_Etat Etat);
	
	
	@Query("SELECT A FROM Ad A WHERE A.name LIKE %?1%")
	List<Ad> findByTextContainingIgnoreCase(String Text);

	
}
