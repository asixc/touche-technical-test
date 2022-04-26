package com.example.core.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @InjectMocks User sut;

    @Test
    void testIsMyBirthdayExpectedFalse(){
        final var birthDateMock = LocalDate.of(1986,12,21);
        final var user = User.builder().birthDate(birthDateMock).build();

        final var res = user.isMyBirthDay();

        assertFalse(res);
    }

    @Test
    void testIsMyBirthdayExpectedTrue(){
        final var todayMock = LocalDate.now();
        final var user = User.builder().birthDate(todayMock).build();

        final var res = user.isMyBirthDay();

        assertTrue(res);
    }

    @Test
    void testForAddCoverage(){
        final var todayMock = LocalDate.of(1990, 5, 1);
        final var user = User.builder().birthDate(todayMock).build();

        final var res = user.getBirthDate();

        assertEquals(todayMock, res);
    }
}