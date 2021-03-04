package com.esprit.dari.dao;

import com.esprit.dari.entities.Furnitures;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnituresRepository extends CrudRepository<Furnitures, Long> {
}
