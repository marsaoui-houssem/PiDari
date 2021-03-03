package com.esprit.dari.controller;

import com.esprit.dari.dao.TaskRepository;
import com.esprit.dari.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksRestController {
    @Autowired
    private TaskRepository taskRepository;

    // URL : http://localhost:8081/dari/tasks
    @GetMapping ("/tasks")
    @ResponseBody
    public List<Task> taskList(){
        return taskRepository.findAll();

    }
    @PostMapping ("/tasks")
    @ResponseBody
    public Task save(@RequestBody Task task){
        return taskRepository.save(task);
    }


}
