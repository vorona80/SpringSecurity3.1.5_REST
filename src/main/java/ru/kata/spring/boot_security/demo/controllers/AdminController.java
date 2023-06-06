package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import ru.kata.spring.boot_security.demo.model.User;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserServiceImpl userServiceImpl;
    private RoleServiceImpl roleService;

    @Autowired
    public AdminController(UserServiceImpl userServiceImpl, RoleServiceImpl roleService) {
        this.userServiceImpl = userServiceImpl;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String getAllUsers(Principal principal, Model model, @ModelAttribute("newUser") User newUser) {
        model.addAttribute("user", userServiceImpl.getAllUsers());
        model.addAttribute("username", userServiceImpl.findByUsername(principal.getName()));
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin";
    }

    @GetMapping("/new")
    public String getNewUser(Principal principal, Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("user", new User());
        model.addAttribute("username", userServiceImpl.findByUsername(principal.getName()));
        return "new";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") @Validated User user, BindingResult bindingResult) {
        userServiceImpl.createUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}")
    public String saveUpdateUser(@ModelAttribute("user") @Validated User user, BindingResult bindingResult, @PathVariable("id") Long id) {
        userServiceImpl.update(id, user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.delete(id);
        return "redirect:/admin";
    }
}


