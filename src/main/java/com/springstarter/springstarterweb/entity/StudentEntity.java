package com.springstarter.springstarterweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "student")
@Entity(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
}
