package com.example.core.usecases;

import com.example.core.domain.User;
import com.example.ports.input.UserReaderCSVInPort;
import com.example.ports.output.UserReaderCSVOutPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImportUserCSV implements UserReaderCSVInPort {

    final UserReaderCSVOutPort port;

    @Override
    public List<User> readUsersOfCSV() {
        return this.port.readUsersOfCSV();
    }
}
