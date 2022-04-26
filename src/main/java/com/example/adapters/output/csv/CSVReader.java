package com.example.adapters.output.csv;

import com.example.core.domain.User;
import com.example.ports.output.UserReaderCSVOutPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class CSVReader implements UserReaderCSVOutPort {

    public static final String SRC_MAIN_RESOURCES_FILE_CSV = "src/main/resources/file.csv";
    private final UserMapper mapper;

    private final static String SEPARATOR = ",";

    @Override
    public List<User> readUsersOfCSV() {

        // mock of port.readCSV();
        return List.of(
                new UserDto("Doe", "John", LocalDate.of(1982, 10, 8), "john.doe@foobar.com"),
                new UserDto("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@foobar.com"),
                new UserDto("Pancracio", "San", LocalDate.now(), "san.pancracio@foobar.com")

        ).stream().map(mapper::of).toList();
    }

    @Override
    public List<User> realReadUserOfCSV() {
        List<User> users = new ArrayList<User>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(SRC_MAIN_RESOURCES_FILE_CSV));
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] fields = line.split(SEPARATOR);

                users.add(new User(fields[0], fields[1], getBirthDate(fields), fields[3]));
                log.info(String.valueOf(users));

                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            log.error("Users File not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    private LocalDate getBirthDate(String[] fields) {
        final List<String> birthDateArrayString = Arrays.stream(fields[2].split("/")).map(String::trim).toList();
        return LocalDate.of(Integer.valueOf(birthDateArrayString.get(0)), Integer.valueOf(birthDateArrayString.get(1)), Integer.valueOf(birthDateArrayString.get(2)));
    }
}
