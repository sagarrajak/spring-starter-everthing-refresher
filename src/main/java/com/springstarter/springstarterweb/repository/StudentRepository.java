package com.springstarter.springstarterweb.repository;

import com.springstarter.springstarterweb.entity.StudentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    public List<StudentEntity> findByFirstNameIgnoreCase(String firstName);

    public List<StudentEntity> findByFirstNameStartingWith(String firstName);

    public List<StudentEntity> findByFirstNameContaining(String firstName);

    @Query("select s from student s where s.emailId ilike %?1%")
    public List<StudentEntity> getStudentByEmailAddress(String email);

    @Query("select s from student s where s.emailId ilike %?1% and s.firstName ilike %?2%")
    public List<StudentEntity> getStudentByEmailAddressAndFirstName(String email, String firstName);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update student s set s.firstName = ?1 where s.emailId = ?2")
    public int updateStudentNameByEmailId(String firstName, String emailId);
}
