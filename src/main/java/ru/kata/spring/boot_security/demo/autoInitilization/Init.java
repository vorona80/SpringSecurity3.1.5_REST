package ru.kata.spring.boot_security.demo.autoInitilization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Configuration
//@Transactional
public class Init {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public Init(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void autoInit() {
        Role roleUs = new Role("ROLE_USER");
        Role roleAd = new Role("ROLE_ADMIN");
        roleRepository.save(roleUs);
        roleRepository.save(roleAd);
        Set<Role> rAd = new HashSet<>();
        rAd.add(roleAd);
        rAd.add(roleUs);
        Set<Role> rUs = new HashSet<>();
        rUs.add(roleUs);
        User admin = new User("admin", "Adminov", 35, passwordEncoder.encode("admin"), rAd);
        User normalUser = new User("user", "Userov", 25, passwordEncoder.encode("user"), rUs);
        userRepository.save(admin);
        userRepository.save(normalUser);

    }
}
