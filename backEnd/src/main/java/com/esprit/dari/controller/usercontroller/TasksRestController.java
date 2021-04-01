package com.esprit.dari.controller.usercontroller;

import com.esprit.dari.entities.CallEtats;
import com.esprit.dari.services.user.CallService;

import com.esprit.dari.entities.userentity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TasksRestController {
    @Autowired
    private CallService callService;

    // URL : http://localhost:8081/dari/tasks
    @GetMapping ("/tasks")
    @ResponseBody
    public List<Task> taskList(@RequestParam(value = "callEtats", required = false) CallEtats callEtats,@RequestParam(value = "minDate", required = false) LocalDateTime minDate ){
        return callService.find(callEtats,minDate);

    }
    @PostMapping ("/tasks")
    @ResponseBody
    public Task save(@RequestBody Task task, Authentication authentication){
        return callService.saveTask(task,authentication);
    }

    @PostMapping ("/tasks/treat/{id}/{status}")
    @ResponseBody
    public Task save(@PathVariable Long id, @PathVariable CallEtats status){

        return callService.treatTask(id,status);
    }


}
