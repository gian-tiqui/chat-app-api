package com.gi.Chat.Application.Api.controller;

import com.gi.Chat.Application.Api.dto.ChatMessageDto;
import com.gi.Chat.Application.Api.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatMessageController {

  @Autowired
  private ChatMessageService chatMessageService;

  @PostMapping
  public ResponseEntity<Object> saveMessage(@RequestBody ChatMessageDto chatMessageDto) {
    return ResponseEntity.ok(chatMessageService.saveMessage(chatMessageDto));
  }
}
