package com.gi.Chat.Application.Api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private String role;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDate;
    private String sex;
}
