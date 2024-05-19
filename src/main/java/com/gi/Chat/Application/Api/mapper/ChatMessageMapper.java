package com.gi.Chat.Application.Api.mapper;

import com.gi.Chat.Application.Api.dto.ChatMessageDto;
import com.gi.Chat.Application.Api.entity.ChatMessage;

public class ChatMessageMapper {

  public static ChatMessage convertFromDto(ChatMessageDto chatMessageDto) {
    return new ChatMessage(
        chatMessageDto.getMessageId(),
        chatMessageDto.getRoomId(),
        chatMessageDto.getSenderId(),
        chatMessageDto.getContent(),
        chatMessageDto.getSentAt(),
        chatMessageDto.getUpdatedAt()
    );
  }

  public static ChatMessageDto convertToDto(ChatMessage chatMessage) {
    return new ChatMessageDto(
        chatMessage.getMessageId(),
        chatMessage.getRoomId(),
        chatMessage.getSenderId(),
        chatMessage.getContent(),
        chatMessage.getSentAt(),
        chatMessage.getUpdatedAt()
    );
  }
}
