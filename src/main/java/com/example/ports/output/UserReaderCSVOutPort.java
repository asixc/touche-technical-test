package com.example.ports.output;

import com.example.core.domain.User;

import java.util.List;

public interface UserReaderCSVOutPort {
    List<User> readUsersOfCSV();

    List<User> realReadUserOfCSV();
}
