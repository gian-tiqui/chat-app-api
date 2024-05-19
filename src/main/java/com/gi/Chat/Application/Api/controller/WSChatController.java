package com.gi.Chat.Application.Api.controller;

import com.gi.Chat.Application.Api.dto.ChatMessageDto;
import com.gi.Chat.Application.Api.entity.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WSChatController {

  @MessageMapping("/chat.sendMessage")
  @SendTo("/topic/public")
  public ChatMessageDto sendMessage(@Payload ChatMessageDto chatMessageDto) {
    return chatMessageDto;
  }

  @MessageMapping("/chat.addUser")
  @SendTo("/topic/public")
  public ChatMessageDto addUser(@Payload ChatMessageDto chatMessageDto, SimpMessageHeaderAccessor headerAccessor) {
    headerAccessor.getSessionAttributes().put("username", chatMessageDto.getSenderId());

    return chatMessageDto;
  }
}
