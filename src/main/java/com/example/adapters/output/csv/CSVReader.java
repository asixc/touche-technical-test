package com.example.adapters.output.csv;

import com.example.core.domain.User;
import com.example.ports.output.UserReaderCSVOutPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class CSVReader implements UserReaderCSVOutPort {

    private final UserMapper mapper;

    @Override
    public List<User> readUsersOfCSV() {

        // mock of port.readCSV();
               return List.of(
                new UserDto("Doe", "John", LocalDate.of(1982,10,8), "john.doe@foobar.com"),
                new UserDto("Ann", "Mary", LocalDate.of(1975,9,11), "mary.ann@foobar.com"),
                new UserDto("Pancracio", "San", LocalDate.now(), "san.pancracio@foobar.com")

        ).stream().map(mapper::of).toList();
    }
}
