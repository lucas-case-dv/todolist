package com.lucascase.todolist.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

//Task modelling for database
@Entity
@Table(name = Task.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Task {
    public static final String TABLE_NAME = "tasks";

    //Id for task
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "description", length = 255, nullable = false)
    @NotBlank
    @Size(min = 1, max = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
