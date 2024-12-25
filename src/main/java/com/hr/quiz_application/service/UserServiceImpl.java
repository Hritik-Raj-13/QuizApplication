package com.hr.quiz_application.service;


import com.hr.quiz_application.entity.Users;
import com.hr.quiz_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void userRegistration(Users users) {
        users.setPsw(passwordEncoder.encode(users.getPsw()));
        userRepository.save(users);
    }


    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
