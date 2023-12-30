package com.springstarter.springstarterweb.repository;

import com.springstarter.springstarterweb.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VerificationTokenResposiotry extends JpaRepository<VerificationToken, Long> {
    List<VerificationToken> findByToken(String token);

    @Query("select vt from VerificationToken vt where vt.user.id = ?1")
    List<VerificationToken> findByUser(String id);
}
