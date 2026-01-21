package com.lucascase.todolist.services;

import com.lucascase.todolist.models.Task;
import com.lucascase.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    //Read operation
    public Task findById(Long id) {
        Optional<Task> task = this.taskRepository.findById(id); //Uses repository method
        return task.orElseThrow(() -> new RuntimeException(
                "Task not found. Id: " + id));
    }

    @Transactional
    public Task create(Task obj) {
        obj.setId(null); //Avoids overwriting an existing task
        return this.taskRepository.save(obj);
    }

    @Transactional
    public Task update(Task obj) {
        Task newObj = findById(obj.getId()); //Gets the current task
        newObj.setDescription(obj.getDescription()); //Sets the new description
        return this.taskRepository.save(newObj);
    }

    @Transactional
    public void delete(Long id) {
        try {
            this.taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("It was not possible to delete the task with id: " + id);
        }
    }
}
