package com.gi.Chat.Application.Api.service;

import com.gi.Chat.Application.Api.dto.ReqRes;
import com.gi.Chat.Application.Api.dto.UserDto;
import com.gi.Chat.Application.Api.entity.User;
import com.gi.Chat.Application.Api.mapper.UserMapper;
import com.gi.Chat.Application.Api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private JWTUtils jwtUtils;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AuthenticationManager authenticationManager;

  public ReqRes signUp(UserDto userDto) {
    ReqRes res = new ReqRes();

    try {
      User user = UserMapper.convertUserDto(userDto);

      user.setEmail(userDto.getEmail());
      user.setPassword(passwordEncoder.encode(userDto.getPassword()));
      user.setRole(userDto.getRole());

      User result = userRepo.save(user);

      if (result.getId() > 0) {
        res.setMessage("Sign up successful");
        res.setStatus(200);
        res.setUserDto(userDto);
      }
    } catch (Exception e) {

      res.setMessage(e.getMessage());
      res.setStatus(500);
    }

    return res;
  }

  public ReqRes signIn(ReqRes signInReq) {
    ReqRes res = new ReqRes();

    try {
      authenticationManager
          .authenticate(
              new UsernamePasswordAuthenticationToken(signInReq.getEmail(), signInReq.getPassword())
          );

      User foundUser = userRepo.findByEmail(signInReq.getEmail()).orElseThrow();

      var token = jwtUtils.generateToken(foundUser);
      var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), foundUser);
      res.setStatus(200);
      res.setToken(token);
      res.setRefreshToken(refreshToken);
      res.setExpirationTime("24 hours");
      res.setMessage("Sign in successful");
    } catch (Exception e) {
      res.setStatus(500);
      res.setMessage(e.getMessage());
    }

    return res;
  }

  public ReqRes refreshToken(ReqRes refreshTokenReq) {
    ReqRes res = new ReqRes();
    String email = jwtUtils.extractUsername(refreshTokenReq.getToken());
    User user = userRepo.findByEmail(email).orElseThrow();

    if (jwtUtils.isTokenValid(refreshTokenReq.getToken(), user)) {
      var jwt = jwtUtils.generateToken(user);

      res.setStatus(200);
      res.setToken(jwt);
      res.setRefreshToken(refreshTokenReq.getToken());
      res.setExpirationTime("24Hr");
      res.setMessage("Refresh successful.");
    }

    res.setStatus(500);

    return res;
  }
}
