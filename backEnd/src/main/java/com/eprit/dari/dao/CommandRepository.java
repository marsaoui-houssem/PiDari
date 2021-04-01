package com.eprit.dari.dao;

import com.eprit.dari.entities.Command;
import org.springframework.data.repository.CrudRepository;

public interface CommandRepository extends CrudRepository<Command,Long> {
}
