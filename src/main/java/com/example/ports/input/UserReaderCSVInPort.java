package com.example.ports.input;

import com.example.core.domain.User;

import java.util.List;

public interface UserReaderCSVInPort {
    List<User> readUsersOfCSV();
}
