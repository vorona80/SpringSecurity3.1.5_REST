package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import java.util.List;

@RestController
@RequestMapping("api/admin")
public class RestControllerAdmin {
    private UserServiceImpl userServiceImpl;
    @Autowired
    public RestControllerAdmin(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        List<User> getUsers = userServiceImpl.getAllUsers();
        return getUsers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userServiceImpl.getUser(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<HttpStatus> addNewUser(@RequestBody User user) {
        userServiceImpl.createUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> saveUpdateUser(@RequestBody User user) {
        userServiceImpl.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable Long id) {
        userServiceImpl.delete(id);
        return "User with ID = " + id + " was deleted";
    }
}


