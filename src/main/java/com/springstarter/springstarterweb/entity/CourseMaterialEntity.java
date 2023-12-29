package com.springstarter.springstarterweb.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "course_material")
@Entity(name = "CourseMaterialEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterialEntity {
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    @Id
    private Long courseMaterialId;
    private String url;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(
            name = "course_id",
            nullable = false
    )
    private CourseEntity course;
}
