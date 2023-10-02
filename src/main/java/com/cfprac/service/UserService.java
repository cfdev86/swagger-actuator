package com.cfprac.service;

import com.cfprac.model.User;
import com.cfprac.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        userRepository.delete(user);
    }

    public User findUserByDob(LocalDate dob) {
        return userRepository.findByDob(dob).orElseThrow(RuntimeException::new);
    }
}
