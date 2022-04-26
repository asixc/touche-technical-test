package com.example.adapters.output.csv;

import com.example.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User of(UserDto userDto);
}
