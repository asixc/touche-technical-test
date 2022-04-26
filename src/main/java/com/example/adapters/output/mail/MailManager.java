package com.example.adapters.output.mail;

import com.example.core.domain.User;
import com.example.ports.output.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailManager implements MailService {
    @Override
    public void sendBirthDayGreeting(User user) {
        // TODO: add real implementation for read csv files
        log.info("""
                Email To: {}
                Asunto: ¡Feliz cumpleaños!
                                
                ¡Feliz cumpleaños, querido {}!
                """, user.getMail(), getUserName(user));
        //log.info("Sending email to [{}]", user.getMail(), getUserName(user));
    }

    private String getUserName(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }
}
