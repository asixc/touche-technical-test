package com.example.adapters.input.cron;


import com.example.ports.input.BirthDayManagerInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class UserCron {

    final BirthDayManagerInPort birthDayManagerInPort;

    @Scheduled(cron = "0/5 * * * * *")
    public void generateDailyReport(){
        System.out.println("BirthDayManagerInPort");
        this.birthDayManagerInPort.checkBirthdays();
         /*
            final var users = this.userReaderCSVInPort.readUsersOfCSV().stream()
             .map(mapper::of)
                .collect(Collectors.toList());
          */

    }

}
