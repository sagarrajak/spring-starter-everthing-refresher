package com.springstarter.springstarterweb.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guardian {

    @Column(name = "guardian_name")
    private String name;

    @Column(name = "guardian_email",unique = true, nullable = false)
    private String email;


    @Column(name = "guardian_mobile")
    private String mobile;

}
