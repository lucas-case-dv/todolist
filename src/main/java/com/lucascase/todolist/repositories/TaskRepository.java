package com.lucascase.todolist.repositories;

import com.lucascase.todolist.models.Task;
import com.lucascase.todolist.models.projection.TaskProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<TaskProjection> findByUser_Id(Long userId);
}
