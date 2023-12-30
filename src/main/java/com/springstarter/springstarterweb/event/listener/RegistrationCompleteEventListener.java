package com.springstarter.springstarterweb.event.listener;

import com.springstarter.springstarterweb.entity.UserEntity;
import com.springstarter.springstarterweb.entity.VerificationToken;
import com.springstarter.springstarterweb.event.RegistrationCompleteEvent;
import com.springstarter.springstarterweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create verification token of user with link
        UserEntity user = event.getUser();
        String token = UUID.randomUUID().toString();

        VerificationToken verificationToken = this.userService.saveVerificationTokenForUser(user, token);
        // send mail
        String applicationUrl = event.getApplicationUrl() + "verifyRegistration?token=" + token;
        // send mail
        log.info("link to verify account {}", applicationUrl);
    }
}
