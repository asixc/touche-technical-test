package com.example.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
public class User {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String mail;

    public boolean isMyBirthDay() {
        return LocalDate.now().isEqual(this.birthDate);
    }
}
