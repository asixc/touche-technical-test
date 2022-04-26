package com.example.core.usecases;

import com.example.core.domain.User;
import com.example.ports.output.MailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserBirthdaysTest {

    public static final String TEST_NAME = "TestName";
    public static final String TEST_LAST_NAME = "TestLastName";
    public static final String FAKECOUNT = "1";
    @InjectMocks
    UserBirthdays sut;

    @Mock
    MailService mail;

    @Mock
    ImportUserCSV importUserCSV;

    private List<User> users;

    @BeforeEach
    void setuo() {
        this.users = getUsers();
    }

    @Test
    void checkBirthdaysTest() {
        when(importUserCSV.readUsersOfCSV()).thenReturn(this.users);

        this.sut.checkBirthdays();

        verify(mail, times(2)).sendBirthDayGreeting(any(User.class));
    }

    private List<User> getUsers() {
        return List.of(
                User.builder().birthDate(LocalDate.of(2022, 5, 6)).build(),
                User.builder().firstName(TEST_NAME).lastName(TEST_LAST_NAME).birthDate(LocalDate.now()).build(),
                User.builder().firstName(TEST_NAME + FAKECOUNT).lastName(TEST_LAST_NAME + FAKECOUNT).birthDate(LocalDate.now()).build()
        );
    }

}