package com.hr.quiz_application.service;


import com.hr.quiz_application.entity.Users;
import com.hr.quiz_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users userRegistration(Users users) {
        return userRepository.save(users);
    }
}
