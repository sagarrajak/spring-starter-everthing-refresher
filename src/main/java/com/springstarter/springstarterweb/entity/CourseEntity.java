package com.springstarter.springstarterweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "course")
@Entity(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"teacher", "courseMaterial"})
public class CourseEntity {
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @Id
    private Long courseId;

    private String tile;

    private Integer credit;

    @OneToOne(mappedBy = "course", fetch = FetchType.LAZY)
    private CourseMaterialEntity courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                name = "course_id",
                referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    List<StudentEntity> students;

}


