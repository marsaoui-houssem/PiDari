package com.esprit.dari.dao;


import com.esprit.dari.entities.Ads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsRepository extends JpaRepository<Ads,Long> {


}
