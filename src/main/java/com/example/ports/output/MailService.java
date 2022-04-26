package com.example.ports.output;

import com.example.core.domain.User;

public interface MailService {
    void sendBirthDayGreeting(User user);
    //void sendBirthDayGreeting(String email);
}
