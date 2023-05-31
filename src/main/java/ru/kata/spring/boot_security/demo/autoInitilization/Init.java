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
    private final RoleServiceImpl roleService;

    @Autowired
    public Init(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, RoleServiceImpl roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.roleService = roleService;
    }

    @PostConstruct
       public void autoInit() {
//        Role adminRole;
//        Optional<Role> userRole = Optional.of(new Role());
//        adminRole = roleRepository.getById(1L);
//        userRole = roleRepository.findById(2L);
//        Role adminRole = new Role(roleService.getAllRoles().get((int)1).getRole());
//        Role userRole = new Role(roleService.getAllRoles().get((int)2).getRole());

//        roleRepository.save(adminRole);
//        roleRepository.save(userRole);

//        roleRepository.save(adminRole);
//        roleRepository.save(userRole);
 //      Set<Role> userR = new HashSet<>();
//        userR.add(new Role(new Role()));
//        userR.add(new Role("ROLE_USER"));
//        userR.add(roleService.getAllRoles().get(0));
//        Set<Role> adminR = new HashSet<>();
//        adminR.add(adminRole);
//        adminR.add(userRole);
//        adminR.add(roleService.getAllRoles().get(0));
//        adminR.add(roleService.getAllRoles().get(1));
//        User admin = new User("admins", "Administrator", 34, passwordEncoder.encode("admins"),adminR);
//        admin.setRoles(Set.of(roleService.getAllRoles().get(1)));
//        User user = new User("users", "UserUser", 23, passwordEncoder.encode("users"), userR);
//        user.setRoles();

//        Role adminRole = new Role("ROLE_ADMIN");
//        Role userRole = new Role("ROLE_USER");
//
//        roleRepository.save(adminRole);
//        roleRepository.save(userRole);
//
//        User adminUser = new User("admin", "Adminov",34, passwordEncoder.encode("admin"));
//        adminUser.setRoles(Set.of(adminRole, userRole));
//        userRepository.save(adminUser);
//
//        User regularUser = new User("user", "Userov", 23, passwordEncoder.encode("user"));
//        regularUser.setRoles(Set.of(userRole));
//        userRepository.save(regularUser);
//
//        userRepository.save(adminUser);
//        userRepository.save(regularUser);

    }
}
