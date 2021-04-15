package com.esprit.dari.dao;


import com.esprit.dari.entities.UserDari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDariRepository extends JpaRepository<UserDari,Long> {
    public UserDari findByUsername (String userName);
    public UserDari findByUserId(Long id);

}
