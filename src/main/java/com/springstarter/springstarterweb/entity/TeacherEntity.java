package com.springstarter.springstarterweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity(name = "teacher")
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeacherEntity {
    @SequenceGenerator(
            name = "teacher_sequence",
            allocationSize = 1,
            sequenceName = "teacher_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    @Id
    private Long teacherId;


    private String firstName;

    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
    List<CourseEntity> courses;
}
