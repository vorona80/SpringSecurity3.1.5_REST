package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.ExceptionHandler.NoSuchUserException;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;


import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(Long id) {
        try {
            User user = userRepository.findById(id).orElseThrow();
            return user;
        } catch (Exception e) {
            throw new NoSuchUserException("There is no user with ID = " + id + " int Database");
        }
    }
    @Override
    public void createUser(User user) {
        String encoderPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encoderPassword);
        userRepository.save(user);
    }

    @Override
    public void update(User updateUser) {
        if(updateUser.getRoles().isEmpty()) {
            updateUser.setRoles(userRepository.findById(updateUser.getId()).get().getRoles());
        } else {
            updateUser.setRoles(updateUser.getRoles());
        }
        User userOld =userRepository.findById(updateUser.getId()).get();
        String passwordOld = userOld.getPassword();
        if(updateUser.getPassword() == null || updateUser.getPassword().isEmpty()) {
updateUser.setPassword(passwordOld);
        } else{
            updateUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        }
userRepository.save(updateUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not Found");
        }
        return user;
    }
}
