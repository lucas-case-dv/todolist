package com.lucascase.todolist.services;

import com.lucascase.todolist.models.User;
import com.lucascase.todolist.repositories.UserRepository;
import com.lucascase.todolist.services.exceptions.DataBindingViolationException;
import com.lucascase.todolist.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException(
                "User not found."));
    }

    @Transactional
    public User create(User obj) {
        obj.setId(null);
        return this.userRepository.save(obj);
    }

    @Transactional
    public User update(User obj) {
        User newObj = this.findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    @Transactional
    public void delete(Long id) {
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBindingViolationException("Could not delete user.");
        }
    }
}
