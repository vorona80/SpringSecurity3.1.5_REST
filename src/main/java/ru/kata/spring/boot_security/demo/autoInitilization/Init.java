package ru.kata.spring.boot_security.demo.autoInitilization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void autoInit() {
        Set<Role> userR = new HashSet<>();
        userR.add(new Role("ROLE_USER"));
        Set<Role> adminR = new HashSet<>();
        adminR.add(new Role("ROLE_USER"));
        adminR.add(new Role("ROLE_ADMIN"));
        User admin = new User("admins", "Administranor",34,passwordEncoder.encode("admins"),adminR);
        User user = new User("users","UserUser",23, passwordEncoder.encode("users"),userR);
        userRepository.save(admin);
        userRepository.save(user);
    }
}
