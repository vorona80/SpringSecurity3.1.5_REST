package ru.kata.spring.boot_security.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;
@Controller
public class AdminController {
    private final UserServiceImpl userServiceImp;
    private final RoleServiceImpl roleServiceImp;
@Autowired
    public AdminController(UserServiceImpl userServiceImp, RoleServiceImpl roleServiceImp) {
        this.userServiceImp = userServiceImp;
        this.roleServiceImp = roleServiceImp;
    }




    @GetMapping("/admin")
    public String getAllUsers(Model model, Principal principal) {
        model.addAttribute("allUsers", userServiceImp.getAllUsers());
        User princ = userServiceImp.findByUsername(principal.getName());
        model.addAttribute("princ", princ);
        model.addAttribute("newUser", new User());
        model.addAttribute("allRoles", roleServiceImp.getAllRoles());
        model.addAttribute("titleTable", "Список всех пользователей:");
        return "admin";
    }

    @GetMapping("/currentUser")
    public String getUsers(Model model, Principal principal) {
        User princ = userServiceImp.findByUsername(principal.getName());
        model.addAttribute("princ", princ);
        return "user";
    }
}
