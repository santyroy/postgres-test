package org.roy.postgrestest.controller;

import org.roy.postgrestest.model.Task;
import org.roy.postgrestest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping(value = "tasks/{id}", produces = "application/json")
    public Task getTask(@PathVariable("id") long id) {
        return taskRepository.getOne(id);
    }

    @GetMapping(value = "tasks", produces = "application/json")
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @PostMapping(value = "tasks", produces = "application/json")
    public Task saveTask(@RequestBody Task task) {
        task.setId(0);
        taskRepository.saveAndFlush(task);
        return task;
    }

    @PutMapping(value = "tasks/{id}", produces = "application/json")
    public Task updateTask(@PathVariable("id") long id, @RequestBody Task task) {
        Task t = taskRepository.getOne(id);
        task.setId(id);
        taskRepository.saveAndFlush(task);
        return task;
    }

    @DeleteMapping(value = "tasks/{id}")
    public String deleteTask(@PathVariable("id") long id) {
        taskRepository.deleteById(id);
        return "Task with id " + id + " has been deleted";
    }
}
