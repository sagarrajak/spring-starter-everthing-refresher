package com.springstarter.springstarterweb.repository;

import com.springstarter.springstarterweb.entity.CourseEntity;
import com.springstarter.springstarterweb.entity.CourseMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterialEntity, Long> {

}
