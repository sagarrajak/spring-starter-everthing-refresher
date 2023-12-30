package com.springstarter.springstarterweb.controllers;

import com.springstarter.springstarterweb.entity.UserEntity;
import com.springstarter.springstarterweb.error.UserAlreadyExistException;
import com.springstarter.springstarterweb.event.RegistrationCompleteEvent;
import com.springstarter.springstarterweb.pojo.RegistrationRequestModel;
import com.springstarter.springstarterweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequestModel body) throws UserAlreadyExistException {
        UserEntity userEntity = userService.registerUser(body.getUser());
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(userEntity, "someurl"));
        return "success";
    }

    @GetMapping("/verify/{token}")
    public String verifyUser(@PathVariable("token") String token) {
        return userService.validateVerificationToken(token);
    }

    @GetMapping("/resend-verify-token/{email}")
    public String resendVerificationToken(@PathVariable("email") String email)  {
        return userService.resendVerificationToken(email);
    }


}
