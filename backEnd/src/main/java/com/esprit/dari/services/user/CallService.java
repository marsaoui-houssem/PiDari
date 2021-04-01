package com.esprit.dari.services.user;


import com.esprit.dari.entities.CallEtats;
import com.esprit.dari.entities.userentity.RoleDari;
import com.esprit.dari.entities.userentity.Task;
import com.esprit.dari.entities.userentity.UserDari;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

public interface CallService {


    void makeCall(String numPhonne) throws URISyntaxException;
     Task saveTask(Task task, Authentication authentication);
    Task treatTask(Long taskId, CallEtats callEtats);
    List<Task> find(CallEtats callEtats, LocalDateTime minDate);

}
