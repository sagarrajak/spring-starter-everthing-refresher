package com.springstarter.springstarterweb.repository;

import com.springstarter.springstarterweb.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {}
