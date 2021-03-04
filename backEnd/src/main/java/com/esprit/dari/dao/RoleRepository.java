package com.esprit.dari.dao;


import com.esprit.dari.entities.RoleDari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleDari,Long> {
    public RoleDari findByName (String roleName);

}
