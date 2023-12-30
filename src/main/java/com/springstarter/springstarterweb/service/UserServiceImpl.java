package com.springstarter.springstarterweb.service;


import com.springstarter.springstarterweb.entity.UserEntity;
import com.springstarter.springstarterweb.entity.VerificationToken;
import com.springstarter.springstarterweb.error.UserAlreadyExistException;
import com.springstarter.springstarterweb.event.RegistrationCompleteEvent;
import com.springstarter.springstarterweb.repository.UserRepository;
import com.springstarter.springstarterweb.repository.VerificationTokenResposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenResposiotry verificationTokenResposiotry;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public UserEntity registerUser(UserEntity user) throws UserAlreadyExistException {
        Optional<UserEntity> foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser.isPresent()) {
            throw new UserAlreadyExistException("User with this email already exist!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public VerificationToken saveVerificationTokenForUser(UserEntity user, String token) {
        return verificationTokenResposiotry.save(new VerificationToken(user, token));
    }

    @Override
    public String validateVerificationToken(String token) {
        if (Objects.isNull(token)) {
            return "Invalid token";
        }
        List<VerificationToken> tokens = verificationTokenResposiotry.findByToken(token);
        if (tokens.isEmpty()) return "Token not found!";
        VerificationToken verificationToken = tokens.get(0);
        Calendar calendarInstance = Calendar.getInstance();
        long diff = verificationToken.getDateOfExpire().getTime() - calendarInstance.getTime().getTime();
        if (diff <=0) return "Token expired";
        else {
            verificationToken.getUser().setEnabled(true);
            verificationTokenResposiotry.save(verificationToken);
            return "user verified";
        }
    }

    @Override
    public String resendVerificationToken(String email) {
        Optional<UserEntity> foundUser = userRepository.findByEmail(email);
        if (foundUser.isPresent()) {
            List<VerificationToken> byUser = verificationTokenResposiotry.findByUser(Long.toString(foundUser.get().getId()));
            verificationTokenResposiotry.deleteAll(byUser);
            applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(foundUser.get(), "someurl"));
            return "success";
        } else {
            return "User not found!";
        }

    }
}
