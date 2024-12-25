package com.hr.quiz_application.service;

import com.hr.quiz_application.entity.Users;

public interface UserService {
   public void userRegistration(Users users);
   public Users findByEmail(String email);
}
