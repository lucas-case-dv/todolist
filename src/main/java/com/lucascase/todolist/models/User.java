package com.lucascase.todolist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = User.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

    public interface CreateUser {}
    public interface UpdateUser {}

    public static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotBlank(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 2, max = 128)
    @Column(name = "username", nullable = false, length = 128)
    private String username;

    @NotBlank(groups = {CreateUser.class, UpdateUser.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 4, max = 128)
    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Task> tasks = new ArrayList<Task>();
}
