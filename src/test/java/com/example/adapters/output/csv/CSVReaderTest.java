package com.example.adapters.output.csv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CSVReaderTest {
    @InjectMocks
    CSVReader sut;

    @Mock
    UserMapper mapper;

    @Test
    void realReadUserOfCSV() {

        var res = this.sut.realReadUserOfCSV();

        assertEquals(2, res.size());
    }

    @Test
    void readUserOfCSV() {

        var res = this.sut.readUsersOfCSV();

        assertEquals(3, res.size());
        verify(mapper, times(3)).of(any(UserDto.class));
    }
}