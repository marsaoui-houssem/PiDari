package com.esprit.dari.dao.userrepository;



import com.esprit.dari.entities.userentity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    public List<Task> findAllByCallRequest (String etatRequest);
    public List<Task> findAllByDateTaskGreaterThanEqual (LocalDateTime minDate);
    public List<Task> findAllByDateTaskGreaterThanEqualAndCallRequest (LocalDateTime minDate,String etatRequest);
}
