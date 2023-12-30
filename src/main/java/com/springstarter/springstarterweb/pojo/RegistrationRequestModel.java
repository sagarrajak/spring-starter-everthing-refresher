package com.springstarter.springstarterweb.pojo;

import com.springstarter.springstarterweb.controllers.RegistrationController;
import com.springstarter.springstarterweb.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequestModel {
    @NotBlank()
    private String firstName;

    @NotBlank()
    private String lastName;

    @Email()
    @NotBlank()
    private String email;

    @Column(length = 60)
    private String password;

    public UserEntity getUser() {
        UserEntity user = UserEntity.builder().firstName(this.firstName)
                .lastName(this.lastName)
                .email(this.email)
                .password(this.password)
                .build();
        return user;
    }
}
