package com.example.core.usecases;

import com.example.core.domain.User;
import com.example.ports.input.BirthDayManagerInPort;
import com.example.ports.output.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserBirthdays implements BirthDayManagerInPort {

    final MailService mail;
    final ImportUserCSV importUserCSV;

    @Override
    public void checkBirthdays() {
        this.importUserCSV.readUsersOfCSV().stream()
            .filter(User::isMyBirthDay)
           // .map(User::getMail)
            .forEach(mail::sendBirthDayGreeting);
    }
}
