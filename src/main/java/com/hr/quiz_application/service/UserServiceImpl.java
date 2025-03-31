package com.hr.quiz_application.service;


import com.hr.quiz_application.entity.Users;
import com.hr.quiz_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void userRegistration(Users users) {
        users.setPsw(users.getPsw());
        userRepository.save(users);
    }


    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
