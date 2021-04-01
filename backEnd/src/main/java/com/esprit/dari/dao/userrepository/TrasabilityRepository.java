package com.esprit.dari.dao.userrepository;

import com.esprit.dari.entities.userentity.Trasability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasabilityRepository extends JpaRepository<Trasability,String> {
}
