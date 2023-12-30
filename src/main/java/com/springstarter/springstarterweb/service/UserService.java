package com.springstarter.springstarterweb.service;


import com.springstarter.springstarterweb.entity.UserEntity;
import com.springstarter.springstarterweb.entity.VerificationToken;
import com.springstarter.springstarterweb.error.UserAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserEntity registerUser(UserEntity user) throws UserAlreadyExistException;

    VerificationToken saveVerificationTokenForUser(UserEntity user, String token);

    public String validateVerificationToken(String token);

    String resendVerificationToken(String email);
}
