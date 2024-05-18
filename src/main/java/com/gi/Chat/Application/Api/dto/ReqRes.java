package com.gi.Chat.Application.Api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqRes {

  private String error;
  private String message;
  private Integer status;
  private String token;
  private String refreshToken;
  private String expirationTime;
  private String email;
  private String password;
  private String role;
  private UserDto userDto;
}
