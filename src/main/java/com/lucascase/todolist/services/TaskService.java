package com.lucascase.todolist.services;

import com.lucascase.todolist.models.Task;
import com.lucascase.todolist.models.User;
import com.lucascase.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    //Read operation
    public Task findById(Long id) {
        Optional<Task> task = this.taskRepository.findById(id); //Uses repository method
        return task.orElseThrow(() -> new RuntimeException(
                "Task not found."));
    }

    public List<Task> findAllByUserId(Long userId) {
        List<Task> tasks = this.taskRepository.findByUser_Id(userId);
        return tasks;
    }

    @Transactional
    public Task create(Task obj) {
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null); //Avoids overwriting an existing task
        obj.setUser(user); //Avoids saving wrong user
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
