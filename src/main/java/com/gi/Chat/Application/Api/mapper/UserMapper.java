package com.gi.Chat.Application.Api.mapper;

import com.gi.Chat.Application.Api.dto.UserDto;
import com.gi.Chat.Application.Api.entity.User;

public class UserMapper {

  public static UserDto convertUser(User user) {
    return new UserDto(
        user.getId(),
        user.getEmail(),
        user.getPassword(),
        user.getRole(),
        user.getFirstName(),
        user.getMiddleName(),
        user.getLastName(),
        user.getBirthYear(),
        user.getBirthMonth(),
        user.getBirthDate(),
        user.getSex()
    );
  }

  public static User convertUserDto(UserDto userDto) {
    return new User(
        userDto.getId(),
        userDto.getEmail(),
        userDto.getPassword(),
        userDto.getRole(),
        userDto.getFirstName(),
        userDto.getMiddleName(),
        userDto.getLastName(),
        userDto.getBirthYear(),
        userDto.getBirthMonth(),
        userDto.getBirthDate(),
        userDto.getSex(),
        false
    );
  }
}
