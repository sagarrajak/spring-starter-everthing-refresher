package com.springstarter.springstarterweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationToken {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String token;
    private Date dateOfExpire;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public VerificationToken(UserEntity user, String token) {
        this.user = user;
        this.token = token;
        this.dateOfExpire = this.addTimeInMinutes(10);
    }

    public VerificationToken(String token) {
        this.token = token;
        this.dateOfExpire = this.addTimeInMinutes(10);
    }


    private Date addTimeInMinutes(Integer minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new  Date().getTime());
        calendar.add(Calendar.MINUTE, minutes);
        return new Date(calendar.getTime().getTime());
    }

}
