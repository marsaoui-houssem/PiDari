package com.esprit.dari.dao.LouerAchat;

import com.esprit.dari.entities.userentity.UserDari;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserDari,Long>{


	@Query(value ="SELECT count(*) FROM User",nativeQuery = true)
    public int countUsers();
}
