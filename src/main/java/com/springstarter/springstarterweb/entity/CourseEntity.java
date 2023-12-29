package com.springstarter.springstarterweb.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "course")
@Entity(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
}
