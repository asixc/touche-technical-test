package com.example.adapters.output.csv;

import java.time.LocalDate;

public record UserDto(String lastName, String firstName, LocalDate birthDate, String mail) {
}
