package com.springstarter.springstarterweb.repository;

import com.springstarter.springstarterweb.entity.Guardian;
import com.springstarter.springstarterweb.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        StudentEntity student = StudentEntity.builder().emailId("someemail3@gmail.com")
                .guardian(
                        Guardian
                                .builder()
                                .email("somemail5@gmail.com")
                                .name("sdsfdf")
                                .mobile("233234234")
                                .build()
                )
                .firstName("dsdfsd")
                .lastName("sdfsdfsdf")
                .build();

        StudentEntity student2 = StudentEntity.builder().emailId("someemail2@gmail.com")
                .guardian(
                        Guardian
                                .builder()
                                .email("somemail2@gmail.com")
                                .name("parent")
                                .mobile("233234234")
                                .build()
                )
                .firstName("Prawin")
                .lastName("kumar")
                .build();
        studentRepository.saveAll(List.of(student2, student));
    }

    @Test
    public void printAllStudent() {
        List<StudentEntity> all = studentRepository.findAll();
        System.out.println("found all"+all);
    }

    @Test
    public void findStudentByFirstname() {
        List<StudentEntity> students = studentRepository.findByFirstNameIgnoreCase("prawin");
        System.out.println("found student"+students);
    }

    @Test
    public void findStudentContaining() {
        List<StudentEntity> students = studentRepository.findByFirstNameContaining("Prawin");
        System.out.println("found student"+students);
    }

    @Test
    public void findByEmailAddress() {
        List<StudentEntity> studentByEmailAddress = studentRepository.getStudentByEmailAddress("someemail3@gmail.com");
        System.out.println("found"+studentByEmailAddress);
    }

    @Test
    public void findByEmailAddressAndFirstName() {
        List<StudentEntity> studentByEmailAddress = studentRepository.getStudentByEmailAddressAndFirstName("@gmail.com", "pra");
        System.out.println("found"+studentByEmailAddress);
    }

    @Test
    public void updateByEmailAddress() {
        studentRepository.updateStudentNameByEmailId("Test123","someemail2@gmail.com");
    }
}