package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.ExceptionHandler.NoSuchUserException;
import ru.kata.spring.boot_security.demo.ExceptionHandler.UserIncorrectData;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

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

//        @GetMapping("/{id}")
//    public User getUserById(@PathVariable ("id") Long id) {
//        User user = userServiceImpl.getUser(id);
//        return user;
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
            return new ResponseEntity<>(userServiceImpl.getUser(id), HttpStatus.OK);
    }

//    @PostMapping("")
//    public User addNewUser (@RequestBody User user) {
//        userServiceImpl.createUser(user);
//        return user;
//    }
    @PostMapping("")
    public ResponseEntity<HttpStatus> addNewUser(@RequestBody User user) {
        userServiceImpl.createUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> saveUpdateUser(@RequestBody User user, @PathVariable Long id) {
        userServiceImpl.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable Long id) {
        userServiceImpl.delete(id);
        return "User with ID = " + id + " was deleted";
    }


}


