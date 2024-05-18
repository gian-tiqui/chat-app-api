package com.gi.Chat.Application.Api.controller;

import com.gi.Chat.Application.Api.dto.ReqRes;
import com.gi.Chat.Application.Api.dto.UserDto;
import com.gi.Chat.Application.Api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<ReqRes> signUp(@RequestBody UserDto signUpReq) {
    return ResponseEntity.ok(authService.signUp(signUpReq));
  }

  @PostMapping("/login")
  public ResponseEntity<ReqRes> signIn(@RequestBody ReqRes signUpReq) {
    return ResponseEntity.ok(authService.signIn(signUpReq));
  }

  @PostMapping("/refresh")
  public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes refreshTokenReq) {
    return ResponseEntity.ok(authService.refreshToken(refreshTokenReq));
  }
}
