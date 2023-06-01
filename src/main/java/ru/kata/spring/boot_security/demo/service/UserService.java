package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void createUser(User user);

    public User getUser(Long id);

    public void update(Long id, User updateUser);

    public void delete(Long id);
}
